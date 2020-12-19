package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.AdminArray;
import com.example.cancer.ascs.ModelClasses.InsertNotification;
import com.example.cancer.ascs.ModelClasses.Insertresult;
import com.example.cancer.ascs.ModelClasses.StudentArray;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UploadResultFragment extends Fragment {

Spinner spinner;
EditText e,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16;
Button button;
String name,arid,Classs,sh,c1,num1,c2,num2,c3,nu3,c4,num4,c5,num5,c6,num6;
    String negpat="-[0-9]*";
    String aridpat="([0-9]{2})-([A-Z]{4})-([0-9]{2})";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload_result, container, false);
        e15=view.findViewById(R.id.c0);
        e16=view.findViewById(R.id.c0l);


        e=view.findViewById(R.id.cl);
        e2=view.findViewById(R.id.shift);
        e3=view.findViewById(R.id.cr1);
        e4=view.findViewById(R.id.cr1num);
        e5=view.findViewById(R.id.cr2);
        e6=view.findViewById(R.id.cr2num);
        e7=view.findViewById(R.id.cr3);
        e8=view.findViewById(R.id.cr3num);
        e9=view.findViewById(R.id.cr4);
        e10=view.findViewById(R.id.cr4num);
        e11=view.findViewById(R.id.cr5);
        e12=view.findViewById(R.id.cr5num);
        e13=view.findViewById(R.id.cr6);
        e14=view.findViewById(R.id.cr6num);
        button=view.findViewById(R.id.btnUpload);



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    uploadResult();
                }
            }
        });

        return view;
    }

    private boolean validate() {

        name = e15.getText().toString();
        arid = e16.getText().toString();
        Classs = e.getText().toString();
        sh = e2.getText().toString();
        c1 = e3.getText().toString();
        num1 = e4.getText().toString();
        c2= e5.getText().toString();
        num2 = e6.getText().toString();
        c3 = e7.getText().toString();
        nu3 = e8.getText().toString();
        c4 = e9.getText().toString();
        num4 = e10.getText().toString();
        c5 = e11.getText().toString();
        num5 = e12.getText().toString();

        c6 = e13.getText().toString();
        num6 = e14.getText().toString();


        if (name.length() == 0 || name.matches(negpat)) {
            e15.setError("Please enter correct name for the student.");
            return false;
        } else if(arid.length()==0 || arid.matches(negpat) || arid.matches(aridpat)==false){
            e16.setError("Please enter correct arid num for the student.");
            return false;
        } else if (Classs.length() == 0 || Classs.matches(negpat)){
            e.setError("Please enter correct Class");
            return false;
        }
        else if (sh.length() == 0 || sh.matches(negpat)){
            e2.setError("Please enter correct Shift");
            return false;
        }
        else if (c1.length() == 0 || c1.matches(negpat)){
            e3.setError("Please enter correct Subject");
            return false;
        }
     else if(num1.length()==0 || num1.matches(negpat)){
        e4.setError("Please enter correct Number.");
        return false;
    } else if (c2.length() == 0 || c2.matches(negpat)){
        e5.setError("Please enter correct Subject");
        return false;
    }
        else if (num2.length() == 0 || num2.matches(negpat)){
        e6.setError("Please enter correct Number");
        return false;
    }
        else if (c3.length() == 0 || c3.matches(negpat)){
        e7.setError("Please enter correct Subject");
        return false;
    }
     else if(nu3.length()==0 || nu3.matches(negpat)){
        e8.setError("Please enter correct Number");
        return false;
        } else if (c4.length() == 0 || c4.matches(negpat)){
        e9.setError("Please enter correct Subject");
        return false;
        }
        else if (num4.length() == 0 ||  num4.matches(negpat)){
        e10.setError("Please enter correct Number");
        return false;
        }
        else if (c5.length() == 0 || c5.matches(negpat)){
        e11.setError("Please enter correct Subject");
        return false;
        }
        else if (num5.length() == 0 || num5.matches(negpat)){
            e12.setError("Please enter correct  number");
            return false;
        }
        else if (c6.length() == 0 || c6.matches(negpat)){
            e13.setError("Please enter correct Subject");
            return false;
        }
        else if (num6.length() == 0 || num6.matches(negpat)){
            e14.setError("Please enter correct  number");
            return false;
        }
        else{
            return true;
        }
    }

    TeacherLoginServices teacherLoginServices=RetrofitClient.getClient().create(TeacherLoginServices.class);
    Insertresult insertresult;

    public  void uploadResult()
    {
        String name=e15.getText().toString().trim();
        String arid=e16.getText().toString().trim();
        String cla=e.getText().toString().trim();
        String shift=e2.getText().toString().trim();
        String sub1=e3.getText().toString().trim();
        Float sub1num=Float.valueOf(e4.getText().toString().trim());
        String sub2=e5.getText().toString().trim();
        Float sub2num=Float.valueOf(e6.getText().toString().trim());
        String sub3=e7.getText().toString().trim();
        Float sub3num= Float.valueOf(e8.getText().toString().trim());
        String sub4=e9.getText().toString().trim();
        Float sub4num= Float.valueOf(e10.getText().toString().trim());
        String sub5=e11.getText().toString().trim();
        Float sub5num= Float.valueOf(e12.getText().toString().trim());
        String sub6=e13.getText().toString().trim();
        Float sub6num= Float.valueOf(e14.getText().toString().trim());

        insertresult = new Insertresult();
        teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call serviceCall = teacherLoginServices.result(name,arid,cla,shift,sub1,sub1num,sub2,sub2num,sub3,sub3num,sub4,sub4num,sub5,sub5num,sub6,sub6num);

        serviceCall.enqueue(new Callback<Insertresult>() {
            @Override
            public void onResponse(Call<Insertresult> call, Response<Insertresult> response) {
                if(response.isSuccessful())
                {
                    insertresult = response.body();
                   // Toast.makeText(getContext(),insertresult.getMessage(),Toast.LENGTH_SHORT).show();
                    if(!insertresult.isError())
                    {
                        Toast.makeText(getContext(), "Successfully Uploaded", Toast.LENGTH_SHORT).show();
                        e.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        e6.setText("");
                        e7.setText("");
                        e8.setText("");
                        e9.setText("");
                        e10.setText("");
                        e11.setText("");
                        e12.setText("");
                        e13.setText("");
                        e14.setText("");
                        e15.setText("");
                        e16.setText("");
                    }
                    else
                    {
                        Toast.makeText(getActivity(), insertresult.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Insertresult> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
