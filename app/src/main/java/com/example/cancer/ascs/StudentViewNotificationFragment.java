package com.example.cancer.ascs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.NotificationArrayItem;
import com.example.cancer.ascs.ModelClasses.ViewNotification;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentViewNotificationFragment extends Fragment {
    ViewNotification<NotificationArrayItem> timetableArray;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_student_view_notification, container, false);
        recyclerView = view.findViewById(R.id.TimetablerecyleList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        Showdata();


        return view;


    }
    private void Showdata()
    {
        timetableArray = new ViewNotification<>();
        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call serviceCall = teacherLoginServices.shownotification();
        serviceCall.enqueue(new Callback<ViewNotification<NotificationArrayItem>> () {
            @Override
            public void onResponse(Call<ViewNotification<NotificationArrayItem>> call, Response<ViewNotification<NotificationArrayItem>> response) {
                if(response.isSuccessful())
                {
                    timetableArray = response.body();
                    if(!timetableArray.isError())
                    {
                        List<NotificationArrayItem> timetableArrayList = timetableArray.getNotificationArray();

                        Notification_Recycle_Adapter data= new Notification_Recycle_Adapter(getActivity(), timetableArrayList);
                        recyclerView.setAdapter(data);
                        //Toast.makeText(showSchedule.this, scheduleArray.getScheduleArray().get(0).getRName(), Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getActivity(), timetableArray.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ViewNotification<NotificationArrayItem>> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}