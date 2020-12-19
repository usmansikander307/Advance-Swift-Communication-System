package com.example.cancer.ascs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;

import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView student, teacher, admin, dataop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();
        setContentView(R.layout.activity_main);
        student = findViewById(R.id.studentcard);
        teacher = findViewById(R.id.teachercard);
        admin = findViewById(R.id.admincard);
        dataop = findViewById(R.id.dataopcard);
        student.setOnClickListener(this);
        teacher.setOnClickListener(this);
        admin.setOnClickListener(this);
        dataop.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.studentcard: {
                intent = new Intent(this, Student_Login.class);
                startActivity(intent);
                break;
            }
            case R.id.teachercard: {
                intent = new Intent(this, Teacher_Login.class);
                startActivity(intent);
                break;
            }
            case R.id.admincard: {
                intent = new Intent(this, Admin_Login.class);
                startActivity(intent);
                break;
            }
            case R.id.dataopcard: {
                intent = new Intent(this, Do_Login.class);
                startActivity(intent);
                break;
            }
        }

    }
}



