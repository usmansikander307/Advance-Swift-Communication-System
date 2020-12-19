package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.UpdateStatusResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Teacher_Login extends AppCompatActivity  {
    public EditText login,pass;
    Button btn1;
    LinearLayout loginForm;
    Teacher teacher;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher__login);
        login = findViewById(R.id.Ttext);
        pass = findViewById(R.id.TPassword);
        loginForm=findViewById(R.id.myform);


        btn1 = findViewById(R.id.Tlogin);
        if(SaveSharedPreference.getLoggedIn(getApplicationContext()).equalsIgnoreCase("Teacher")) {
            Intent intent = new Intent(getApplicationContext(), TeacherActivity.class);
            startActivity(intent);
        } else {
            loginForm.setVisibility(View.VISIBLE);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=login.getText().toString().trim();
                String mypass=pass.getText().toString().trim();
                if (email.isEmpty() || mypass.isEmpty()) {
                    login.setError("Field can't be empty");
                    pass.setError("Field can't be empty");

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    login.setError("Please enter a valid email address");
                } else {
                    TeacherLogin();
                }


            }

        });
    }
    private void TeacherLogin()
    {
        final String name, email, password, Contact;
        email = login.getText().toString();
        password = pass.getText().toString();

        teacher = new Teacher();
        progressDialog = new ProgressDialog(Teacher_Login.this);
        progressDialog.setTitle("Authenticating Please Wait....");
        progressDialog.show();

        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call<UpdateStatusResponse> serviceCall = teacherLoginServices.teacherSignin(email,password);
        serviceCall.enqueue(new Callback<UpdateStatusResponse>() {
            @Override
            public void onResponse(Call<UpdateStatusResponse> call, Response<UpdateStatusResponse> response) {
                UpdateStatusResponse response1=response.body();
                if(response1.getMessage().equalsIgnoreCase("login Successful"))
                {
                    SaveSharedPreference.setLoggedIn(getApplicationContext(), "Teacher");
                    Toast.makeText(Teacher_Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    SaveSharedPreference.setTeacherData(Teacher_Login.this,response1.getData().get(0).getTName(),
                            response1.getData().get(0).getStatus(),
                            response1.getData().get(0).getTeacherID());
                    startActivity(new Intent(Teacher_Login.this,TeacherActivity.class));
                }
            }

            @Override
            public void onFailure(Call<UpdateStatusResponse> call, Throwable t) {
                Toast.makeText(Teacher_Login.this, "Exception: "+t, Toast.LENGTH_SHORT).show();
            }
        });
    }




}
