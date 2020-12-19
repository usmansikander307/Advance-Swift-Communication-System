package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.UpdatesuccesfullyResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class TeacherUpdateFragment extends Fragment {
    TextView textView1, textView2;
    RadioButton radioButton, radioButton2;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_status, null);
        textView1 = view.findViewById(R.id.teacherName);
        textView2 = view.findViewById(R.id.tet);
        radioButton = view.findViewById(R.id.radioButton1);
        radioButton2 = view.findViewById(R.id.radioButton2);
        showteachername();
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateStatus();
            }
        });
        return view;
    }

    private void showteachername() {
        ArrayList<String> dataToView = SaveSharedPreference.getTeacherData(getActivity());
        textView1.setText(dataToView.get(0));

        if (dataToView.get(1).equalsIgnoreCase("Available")) {
            radioButton.setChecked(true);
            radioButton2.setChecked(false);

        } else if (dataToView.get(1).equalsIgnoreCase("Not Available")) {
            radioButton.setChecked(false);
            radioButton2.setChecked(true);
        }
    }

    private void UpdateStatus(  ) {
        String name1;
        String status = null;
        name1 = textView1.getText().toString();
       if(radioButton.isChecked())
       {
           status="Available";
       }
       else if(radioButton2.isChecked())
       {
           status="Not Available";
       }

      //  status = radioButton2.getText().toString();

        // UpdatesuccesfullyResponse updatesuccesfullyResponse = new UpdatesuccesfullyResponse();
        Log.d("CheckValueeee dataa", "UpdateStatus: "+status+" name "+name1);
        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call serviceCall = teacherLoginServices.teacherupdate(name1, status);
        Toast.makeText(getActivity(), "Status: "+status+" name: "+name1, Toast.LENGTH_SHORT).show();
        serviceCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                UpdatesuccesfullyResponse response1 = (UpdatesuccesfullyResponse) response.body();
                if (response1.getMessage().equalsIgnoreCase("Update Successfully")) {
                    Toast.makeText(getActivity(), response1.getMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "Response "+ response1.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getActivity(), "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}