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
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.ViewResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewResultFragment extends Fragment {
    Button Submit;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15;
    ScrollView Sview;
    EditText roll,ettclass;
    String aridpat="([0-9]{2})-([A-Z]{4})-([0-9]{2})";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_result, null);
        Submit = view.findViewById(R.id.btncheck);
        roll = view.findViewById(R.id.etarid);
        ettclass=view.findViewById(R.id.etclass);
        t1 = view.findViewById(R.id.txtstd);
        t2 = view.findViewById(R.id.txtdbclass);
        t3 = view.findViewById(R.id.txtdbshift);
        t4 = view.findViewById(R.id.sub1);
        t5 = view.findViewById(R.id.sub2);
        t6 = view.findViewById(R.id.sub3);
        t7 = view.findViewById(R.id.sub4);
        t8 = view.findViewById(R.id.sub5);
        t9 = view.findViewById(R.id.sub6);
        t10 = view.findViewById(R.id.res1);
        t11 = view.findViewById(R.id.res2);
        t12 = view.findViewById(R.id.res3);
        t13 = view.findViewById(R.id.res4);
        t14 = view.findViewById(R.id.res5);
        t15 = view.findViewById(R.id.res6);
        Sview = view.findViewById(R.id.s1);

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = roll.getText().toString();
                String c = ettclass.getText().toString();
                if (r.length() == 0 || r.matches(aridpat)==false) {
                    roll.setError("Please enter correct Arid# ");
                    //  return false;
                } else if (c.length() == 0 ) {
                    ettclass.setError("Please enter correct Class ");
                    //return false;
                }

                    ShowData();

            }
        });
        return view;

    }



    private void ShowData() {
        String RollNo = roll.getText().toString();
        String ClassStudent=ettclass.getText().toString();
        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call<ViewResult> serviceCall = teacherLoginServices.showResult(RollNo,ClassStudent);
        serviceCall.enqueue(new Callback<ViewResult>() {
            @Override
            public void onResponse(Call<ViewResult> call, Response<ViewResult> response) {
                ViewResult viewResult = response.body();
                if (viewResult.getSuccess() == 1) {

                    t1.setText(viewResult.getStudent().get(0).getName());
                    t2.setText(viewResult.getStudent().get(0).getJsonMemberClass());
                    t3.setText(viewResult.getStudent().get(0).getShift());

                    t4.setText(viewResult.getStudent().get(0).getSub1());
                    t5.setText(viewResult.getStudent().get(0).getSub2());
                    t6.setText(viewResult.getStudent().get(0).getSub3());
                    t7.setText(viewResult.getStudent().get(0).getSub4());
                    t8.setText(viewResult.getStudent().get(0).getSub5());
                    t9.setText(viewResult.getStudent().get(0).getSub6());

                    t10.setText(viewResult.getStudent().get(0).getSub1obt());
                    t11.setText(viewResult.getStudent().get(0).getSub2obt());
                    t12.setText(viewResult.getStudent().get(0).getSub3obt());
                    t13.setText(viewResult.getStudent().get(0).getSub4obt());
                    t14.setText(viewResult.getStudent().get(0).getSub5obt());
                    t15.setText(viewResult.getStudent().get(0).getSub6obt());


                } else {
                    Toast.makeText(getContext(), "No Data Found", Toast.LENGTH_SHORT).show();
                    Sview.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onFailure(Call<ViewResult> call, Throwable t) {
                Toast.makeText(getContext(), "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}