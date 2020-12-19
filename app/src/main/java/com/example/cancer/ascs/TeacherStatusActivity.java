package com.example.cancer.ascs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TeacherStatusActivity extends AppCompatActivity {
    String[] items = new String[] {"Dr. Yasir Hafeez", "Dr. Saud Altaf", "Mr.Tariq Ali"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_status);
        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}
