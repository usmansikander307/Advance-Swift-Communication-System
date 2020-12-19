package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Student_Login extends AppCompatActivity {
    public EditText loginEmailId, logInpasswd;
    Button btnLogIn;
    LinearLayout loginForm;
    Student student;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__login);
        loginEmailId = findViewById(R.id.etLogin);
        logInpasswd = findViewById(R.id.etPassword);
        loginForm=findViewById(R.id.loginform);


        btnLogIn = findViewById(R.id.login);
        if(SaveSharedPreference.getLoggedIn(getApplicationContext()).equalsIgnoreCase("Student")) {
            Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
            startActivity(intent);
        } else {
            loginForm.setVisibility(View.VISIBLE);
        }

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=loginEmailId.getText().toString().trim();
                String pass=logInpasswd.getText().toString().trim();
                if (email.isEmpty() || pass.isEmpty()) {
                    loginEmailId.setError("Field can't be empty");
                    logInpasswd.setError("Field can't be empty");

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    loginEmailId.setError("Please enter a valid email address");
                } else {
                    StudentLogin();
                }


            }

        });
    }
    private void StudentLogin()
    {
        final String name, email, password, rollno;
        email = loginEmailId.getText().toString();
        password = logInpasswd.getText().toString();

        student = new Student();
        progressDialog = new ProgressDialog(Student_Login.this);
        progressDialog.setTitle("Authenticating Please Wait....");
        progressDialog.show();

        StudentLoginServices studentLoginServices = RetrofitClient.getClient().create(StudentLoginServices.class);
        Call serviceCall = studentLoginServices.studentSignin(email,password);
        serviceCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful())
                {
                    SaveSharedPreference.setLoggedIn(getApplicationContext(), "Student");
                    progressDialog.dismiss();
                    Student student = (Student) response.body();
                    Toast.makeText(Student_Login.this, student.getMessage(), Toast.LENGTH_SHORT).show();
                    if(!student.isError()){
                        Intent i = new Intent(Student_Login.this, StudentActivity.class);
                        startActivity(i);
                        finish();
                    }
                    }
                    else
                    {
                        Toast.makeText(Student_Login.this, student.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }


            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Student_Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }


    }


