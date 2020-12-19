package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Admin_Login extends AppCompatActivity {
    public EditText loginEmailId, login;
    Button btn;
    LinearLayout loginForm;
    Admin admin;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__login);
        loginEmailId = findViewById(R.id.etLogin);
        login = findViewById(R.id.etPassword);
        loginForm = findViewById(R.id.loginform);


        btn = findViewById(R.id.Login);
        if (SaveSharedPreference.getLoggedIn(getApplicationContext()).equalsIgnoreCase("Admin")) {
            Intent intent = new Intent(getApplicationContext(), AdminActivity.class);
            startActivity(intent);
        } else {
            loginForm.setVisibility(View.VISIBLE);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = loginEmailId.getText().toString().trim();
                String pass = login.getText().toString().trim();
                if (email.isEmpty() || pass.isEmpty()) {
                    loginEmailId.setError("Field can't be empty");
                    login.setError("Field can't be empty");

                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    loginEmailId.setError("Please enter a valid email address");
                } else {
                    AdminLogin();
                }


            }

        });
    }
    private void AdminLogin()
    {
        final  String  email, password;
        email = loginEmailId.getText().toString();
        password = login.getText().toString();

        admin = new Admin();
        progressDialog = new ProgressDialog(Admin_Login.this);
        progressDialog.setTitle("Authenticating Please Wait....");
        progressDialog.show();

        TeacherLoginServices teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        Call serviceCall = teacherLoginServices.adminSignin(email,password);
        serviceCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful())
                {
                   SaveSharedPreference.setLoggedIn(getApplicationContext(), "Admin");
                    progressDialog.dismiss();
                    Admin admin = (Admin) response.body();
                  Toast.makeText(Admin_Login.this, admin.getMessage(), Toast.LENGTH_SHORT).show();
                    if(!admin.isError()){

                        Intent i = new Intent(Admin_Login.this, AdminActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
                else
                {
                    Toast.makeText(Admin_Login.this, admin.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(Admin_Login.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
