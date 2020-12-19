package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.Teacher.TeacherByid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;

public class TeacherProfileFragment extends Fragment {

    TextView name1,email1,contact1,qualification1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_teacher_profile, container, false);
        name1=view.findViewById(R.id.txtstd);
        email1=view.findViewById(R.id.txtdbclass);
        contact1= view.findViewById(R.id.txtdbshift);
        qualification1=view.findViewById(R.id.txtqual);
        getProductAtPID();
    return view;
    }
    private void getProductAtPID() {
        ArrayList<String> dataToView = SaveSharedPreference.getTeacherData(getActivity());
        Toast.makeText(getContext(), "Context data: "+dataToView.get(2), Toast.LENGTH_SHORT).show();
        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call<TeacherByid> call = teacherLoginServices.showTeacherData(dataToView.get(2));
        call.enqueue(new Callback<TeacherByid>() {
            @Override
            public void onResponse(Call<TeacherByid> call, retrofit2.Response<TeacherByid> response) {
                TeacherByid response1 = response.body();
                if (response1.getSuccess() == 1) {
                    name1.setText(response1.getStudent().get(0).getName());
                    email1.setText(response1.getStudent().get(0).getEmail());
                    contact1.setText(response1.getStudent().get(0).getCont());
                    qualification1.setText(response1.getStudent().get(0).getQual());

                } else {
                    Toast.makeText(getContext(), "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeacherByid> call, Throwable t) {
                Toast.makeText(getContext(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
