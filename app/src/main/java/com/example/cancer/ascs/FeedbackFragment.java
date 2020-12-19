package com.example.cancer.ascs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.DataOperator.ScheduleResponse;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FeedbackFragment extends Fragment {

    EditText sClass,sArid;
    Button Submit;

    Spinner q1,q2,q3,q4,q5,q6;
    String aridpat="([0-9]{2})-([A-Z]{4})-([0-9]{2})";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_feedback,null);
        sClass=view.findViewById(R.id.etclass);
        sArid=view.findViewById(R.id.etarid);
        q1=view.findViewById(R.id.res1);
        q2=view.findViewById(R.id.res2);
        q3=view.findViewById(R.id.res3);
        q4=view.findViewById(R.id.res4);
        q5=view.findViewById(R.id.res5);
        q6=view.findViewById(R.id.res6);
        Submit=view.findViewById(R.id.submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = sArid.getText().toString();
                String c = sClass.getText().toString();
                if (r.length() == 0 || r.matches(aridpat)==false) {
                    sArid.setError("Please enter correct Arid# ");
                    //  return false;
                } else if (c.length() == 0) {
                    sClass.setError("Please enter correct Class ");
                    //return false;
                }
                else {

                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                final String date = dateFormat.format(calendar.getTime());
                StudentLoginServices studentLoginServices = RetrofitClient.getClient().create(StudentLoginServices.class);
                Call<ScheduleResponse> call = studentLoginServices.UploadeFeedback(q1.getSelectedItem().toString(), q1.getSelectedItem().toString(),
                        q1.getSelectedItem().toString(), q1.getSelectedItem().toString(), q1.getSelectedItem().toString(), q1.getSelectedItem().toString(),
                        date, sArid.getText().toString(), sClass.getText().toString());
                call.enqueue(new Callback<ScheduleResponse>() {
                    @Override
                    public void onResponse(Call<ScheduleResponse> call, Response<ScheduleResponse> response) {
                        ScheduleResponse response1 = response.body();
                        if (response1.getMessage().equalsIgnoreCase("Data Inserted Successfully")) {
                            Toast.makeText(getActivity(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Data insertion failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ScheduleResponse> call, Throwable t) {
                        Toast.makeText(getActivity(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        });
        return view;
    }


}
