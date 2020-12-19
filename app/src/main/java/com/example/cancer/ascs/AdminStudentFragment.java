package com.example.cancer.ascs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AdminStudentFragment extends Fragment {
    TextView textView;
    Button btn1,btn2,btn3,btn4;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_student, container, false);
        btn1=view.findViewById(R.id.btnnew);
        btn2=view.findViewById(R.id.btnedit);
        btn3=view.findViewById(R.id.btndel);
        btn4=view.findViewById(R.id.btnshow);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),NewProductActivity.class);
                startActivity(i);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),UpdateProductActivity.class);
                startActivity(i);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),DeleteProductActivity.class);
                startActivity(i);


            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getActivity(),ViewProductActivity.class);
                startActivity(i);


            }
        });
        return view;
    }

}
