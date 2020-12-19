package com.example.cancer.ascs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewAttendanceFragment extends Fragment {
    DatabaseReference databaseReference;
    ArrayList<String> attendStudent;
    ArrayList<String> attend;
    ArrayList<String> attendDate;
    TextView t1,t2,t3;
    String aridnum;
    String section;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_view_attendance,null);
        t1=view.findViewById(R.id.atndate);
        t2=view.findViewById(R.id.atnnum);
        t3=view.findViewById(R.id.atnresult);


        attendStudent = new ArrayList<>();
        attendDate = new ArrayList<>();
        attend = new ArrayList<>();

        //TODO: Retrofit request to get student roll no, store in 'aridnum'.
        aridnum = "15-Arid-1166";

        databaseReference = FirebaseDatabase.getInstance().getReference("Students").child(aridnum);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               section =  dataSnapshot.child("section").getValue(String.class);


                databaseReference = FirebaseDatabase.getInstance().getReference("Attendance").child("java").child(section);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for(DataSnapshot snap: dataSnapshot.getChildren()){

                        attendDate.add(snap.getKey());
                            attendStudent.add(snap.child(aridnum).getKey());
                            attend.add(snap.child(aridnum).getValue(String.class));
                        }


                        //TODO: set to text boxes
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });




        return view;
    }

}
