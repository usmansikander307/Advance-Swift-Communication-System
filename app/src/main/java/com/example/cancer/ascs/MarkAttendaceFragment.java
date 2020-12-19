package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.Teacher.TeacherByid;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class MarkAttendaceFragment extends Fragment {

    String contact, sub, sec;
    ArrayList<String> subArrayList;
    ArrayList<String> secArrayList;
    ArrayList<String> studentArrayList;
    DatabaseReference databaseReference;
    Spinner subSpinner, secSpinner;

    Button takeAtt, present, absent;
    TextView aridnum;

    int studentCount=0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mark_attendace, container, false);

        subArrayList = new ArrayList<>();
        secArrayList = new ArrayList<>();
        studentArrayList = new ArrayList<>();

        subSpinner = view.findViewById(R.id.subjects_spinner);
        secSpinner = view.findViewById(R.id.sections_spinner);

        takeAtt = view.findViewById(R.id.fetch);
        present = view.findViewById(R.id.present);
        absent = view.findViewById(R.id.absent);
        aridnum = view.findViewById(R.id.aridnum);


        //Retrive Contact first
        ArrayList<String> dataToView = SaveSharedPreference.getTeacherData(getActivity());
        Toast.makeText(getContext(), "Context data: " + dataToView.get(2), Toast.LENGTH_SHORT).show();
        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call<TeacherByid> call = teacherLoginServices.showTeacherData(dataToView.get(2));
        call.enqueue(new Callback<TeacherByid>() {
            @Override
            public void onResponse(Call<TeacherByid> call, retrofit2.Response<TeacherByid> response) {
                TeacherByid response1 = response.body();
                if (response1.getSuccess() == 1) {
                    contact = response1.getStudent().get(0).getCont();

                    databaseReference = FirebaseDatabase.getInstance().getReference("Subjects").child(contact);
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                subArrayList.add(snapshot.getValue(String.class));
                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, subArrayList);
                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


                            subSpinner.setAdapter(adapter);

                            subSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    sub = subSpinner.getItemAtPosition(position).toString();

                                    if (!secArrayList.isEmpty()) {
                                        secArrayList.clear();
                                    }


                                    //Retriving sections
                                    databaseReference = FirebaseDatabase.getInstance().getReference("Classes").child(contact).child(sub);
                                    databaseReference.addValueEventListener(new ValueEventListener() {
                                        @Override
                                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                                            if (!secArrayList.isEmpty()) {
                                                secArrayList.clear();
                                            }

                                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                                secArrayList.add(snapshot.getValue(String.class));
                                            }

                                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, secArrayList);
                                            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                                            secSpinner.setAdapter(adapter);

                                            secSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                @Override
                                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                    sec = secSpinner.getItemAtPosition(position).toString();
                                                }

                                                @Override
                                                public void onNothingSelected(AdapterView<?> parent) {

                                                }
                                            });

                                        }

                                        @Override
                                        public void onCancelled(@NonNull DatabaseError databaseError) {

                                        }
                                    });


                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                } else {
                    Toast.makeText(getContext(), "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<TeacherByid> call, Throwable t) {
                Toast.makeText(getContext(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        //Fetching data
        takeAtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                databaseReference = FirebaseDatabase.getInstance().getReference("StudentEnrolledToSubjects").child(sub).child(sec);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                            studentArrayList.add(snapshot.getKey());
                        }

                        takeAttendance();
                        }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


        return view;
    }

    public void takeAttendance(){

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        final String date = dateFormat.format(calendar.getTime());

        if(studentCount <= studentArrayList.size()-1) {
            aridnum.setText(studentArrayList.get(studentCount));

            present.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    databaseReference = FirebaseDatabase.getInstance().getReference("Attendance").child(sub).child(sec).child(date).child(studentArrayList.get(studentCount));
                    databaseReference.setValue("present");
                    studentCount++;
                    takeAttendance();


                }
            });


            absent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    databaseReference = FirebaseDatabase.getInstance().getReference("Attendance").child(sub).child(sec).child(date).child(studentArrayList.get(studentCount));
                    databaseReference.setValue("absent");
                    studentCount++;
                    takeAttendance();
                }
            });
        }

        else{
            aridnum.setText("All done");
            present.setClickable(false);
            absent.setClickable(false);
        }

    }
}
