package com.example.cancer.ascs;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TeacherHomeFragment extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home_teacher,null);
        cardView1=view.findViewById(R.id.card1);
        cardView2=view.findViewById(R.id.cardView22);
        cardView3=view.findViewById(R.id.card3);
        cardView4=view.findViewById(R.id.card4);

        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MarkAttendaceFragment markAttendaceFragment=new MarkAttendaceFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.screenarea,markAttendaceFragment);
                ft.commit();

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherProfileFragment teacherProfileFragment=new TeacherProfileFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.screenarea,teacherProfileFragment);
                ft.commit();

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentViewNotificationFragment studentViewNotificationFragment=new StudentViewNotificationFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.screenarea,studentViewNotificationFragment);
                ft.commit();

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherUpdateFragment teacherUpdateFragment=new TeacherUpdateFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.screenarea,teacherUpdateFragment);
                ft.commit();

            }
        });
        return view;
    }
}
