package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.StatusResponse;
import com.example.cancer.ascs.ModelClasses.TeacherNameResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TeacherStatusFragment extends Fragment {

    Spinner spinnerTeacher;
    TextView checkbtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_teacher_status,null);
        spinnerTeacher = view.findViewById(R.id.mySpinner);
        checkbtn=(TextView)view.findViewById(R.id.check);
        showTeacherName();
        return view;
    }
    TeacherLoginServices teacherLoginServices=RetrofitClient.getClient().create(TeacherLoginServices.class);
    private void showTeacherName() {
        Call<TeacherNameResponse> call=teacherLoginServices.teacherName();
        call.enqueue(new Callback<TeacherNameResponse>() {
            @Override
            public void onResponse(Call<TeacherNameResponse> call, Response<TeacherNameResponse> response) {
                final TeacherNameResponse Tresponse=response.body();
                //Toast.makeText(getActivity(), "Response: "+Tresponse.getTeacherArray().get(0).getTName(), Toast.LENGTH_SHORT).show();
                List<String> spnTeacherArray = new ArrayList<>();
                //spnTeacherArray.add("");
                for(int i=0;i<Tresponse.getTeacherArray().size();i++)
                {
                    spnTeacherArray.add(Tresponse.getTeacherArray().get(i).getTName());
                }
                try
                {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                            spnTeacherArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerTeacher.setAdapter(adapter);
                    spinnerTeacher.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            checkStatus(Tresponse.getTeacherArray().get(position).getTName());
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Catch Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeacherNameResponse> call, Throwable t) {
                Log.d("CheckSum", "onResponse: "+t.toString());
            }
        });

    }

    private void checkStatus(final String i) {

        checkbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<StatusResponse> call=teacherLoginServices.statusView(i);
                call.enqueue(new Callback<StatusResponse>() {
                    @Override
                    public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                        StatusResponse response1=response.body();
                        ProgressDialog myDialog = new ProgressDialog(getActivity());
                        myDialog.setMessage(i+"  is "+response1.getStatus()+".");
                        myDialog.setCancelable(false);
                        myDialog.setButton(DialogInterface.BUTTON_NEUTRAL, "Okay", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        myDialog.show();
                        //Toast.makeText(getActivity(), "Response "+response1.getStatus(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<StatusResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
