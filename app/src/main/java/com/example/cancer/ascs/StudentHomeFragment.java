package com.example.cancer.ascs;

import android.app.Activity;
import android.content.Intent;
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

import java.util.zip.Inflater;

public class StudentHomeFragment extends Fragment {
    CardView cardView1,cardView2,cardView3,cardView4,cardView5,cardView6;
    Fragment viewScheduleFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view= inflater.inflate(R.layout.fragment_home_student,null);
        cardView1=view.findViewById(R.id.cardView2);
        cardView2=view.findViewById(R.id.cardView);
        cardView3=view.findViewById(R.id.cardView5);
        cardView4=view.findViewById(R.id.cardview6);
        cardView5=view.findViewById(R.id.cardview4);
        cardView6=view.findViewById(R.id.cardView3);
        cardView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewScheduleFragment=new ViewScheduleFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,viewScheduleFragment);
                ft.commit();

            }
        });
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAttendanceFragment viewAttendanceFragment=new ViewAttendanceFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,viewAttendanceFragment);
                ft.commit();

            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewResultFragment viewAttendanceFragment=new ViewResultFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,viewAttendanceFragment);
                ft.commit();

            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FeedbackFragment feedbackFragment=new FeedbackFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,feedbackFragment);
                ft.commit();

            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentViewNotificationFragment studentViewNotificationFragment=new StudentViewNotificationFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,studentViewNotificationFragment);
                ft.commit();

            }
        });

        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeacherStatusFragment teacherStatusFragment=new TeacherStatusFragment();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction ft=fragmentManager.beginTransaction();
                ft.replace(R.id.fLayout,teacherStatusFragment);
                ft.commit();

            }
        });


        return view;
    }

}
