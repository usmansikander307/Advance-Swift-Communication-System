package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.AdminArray;
import com.example.cancer.ascs.ModelClasses.InsertNotification;
import com.example.cancer.ascs.ModelClasses.TeacherNameResponse;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;




public class UploadNotification extends Fragment {
    Button button;
    EditText edittext2;
    TextView edittext1;
    Spinner spinner;
    String msg;
    String negpat="-[0-9]*";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload_notification, container, false);
        spinner = view.findViewById(R.id.admin);

        getAdminId();

       edittext1 = view.findViewById(R.id.date);
        edittext2 = view.findViewById(R.id.body);
        button = view.findViewById(R.id.btnUpload);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        final String date = dateFormat.format(calendar.getTime());
        edittext1.setText(date);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    uploadNotification();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private boolean validate() {

        msg=edittext2.getText().toString();
        if (msg.length() == 0 || msg.matches(negpat)) {
            edittext2.setError("Please enter proper notification.");
            return false;
        }
        else{
            return true;
        }
    }


    InsertNotification scheduleArray;
    public  void uploadNotification()
    {
        String date=edittext1.getText().toString().trim();
        String body=edittext2.getText().toString().trim();
        String name=spinner.getSelectedItem().toString().trim();

        scheduleArray = new InsertNotification();
        teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call serviceCall = teacherLoginServices.notification(name,date,body);
        serviceCall.enqueue(new Callback<InsertNotification>() {
            @Override
            public void onResponse(Call<InsertNotification> call, Response<InsertNotification> response) {
                if(response.isSuccessful())
                {
                    scheduleArray = response.body();
                    if(!scheduleArray.isError())
                    {
                        Toast.makeText(getContext(), "Successfully Uploaded", Toast.LENGTH_SHORT).show();
                        edittext2.setText("");
                    }
                    else
                    {
                        Toast.makeText(getActivity(), scheduleArray.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<InsertNotification> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    TeacherLoginServices teacherLoginServices=RetrofitClient.getClient().create(TeacherLoginServices.class);
    public void getAdminId()
    {
        Call<AdminArray> call=teacherLoginServices.selectAdmins();
        call.enqueue(new Callback<AdminArray>() {
            @Override
            public void onResponse(Call<AdminArray> call, Response<AdminArray> response) {
                final AdminArray Tresponse=response.body();
                //Toast.makeText(getActivity(), "Response: "+Tresponse.getTeacherArray().get(0).getTName(), Toast.LENGTH_SHORT).show();
                List<String> spnTeacherArray = new ArrayList<>();
                //spnTeacherArray.add("");
                for(int i=0;i<Tresponse.getAdminArray().size();i++)
                {
                    spnTeacherArray.add(Tresponse.getAdminArray().get(i).getAdmName());
                }
                try
                {
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,
                            spnTeacherArray);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter(adapter);



                }
                catch (Exception e)
                {
                    Toast.makeText(getActivity(), "Catch Exception"+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AdminArray> call, Throwable t) {
                Log.d("CheckSum", "onResponse: "+t.toString());
            }
        });
    }

}
