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
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.StatusResponse;
import com.example.cancer.ascs.ModelClasses.Student.StuddentById;
import com.example.cancer.ascs.ModelClasses.Teacher.TeacherByid;

import retrofit2.Call;
import retrofit2.Callback;

public class UpdateTeacherActivity extends AppCompatActivity {
    Button buttonViewAtId, buttonUpdate;
    EditText studentIdInput, newName, newEmail, newcont, newPass, newArid;
    TextView StudentAtPID;
    String jsonResponse;
    static String TAG = UpdateTeacherActivity.class.getSimpleName();
    TeacherLoginServices teacherLoginServices;
    ProgressDialog pDialog;
    String pid;
    String pattern="^[0-9]$";
    String negpat="-[0-9]*";

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_teacher);

        buttonViewAtId = (Button) findViewById(R.id.button_view_at_id);
        buttonUpdate = (Button) findViewById(R.id.btn_update);
        newName = (EditText) findViewById(R.id.new_name);
        teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        newEmail = (EditText) findViewById(R.id.new_price);
        newcont = (EditText) findViewById(R.id.new_description);
        newPass = (EditText) findViewById(R.id.new_pass);
        newArid = (EditText) findViewById(R.id.new_arid);

        StudentAtPID = (TextView) findViewById(R.id.view_product_at_id);


        layout = (LinearLayout) findViewById(R.id.linearView);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        buttonViewAtId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentIdInput = findViewById(R.id.pid_input);
                pid = studentIdInput.getText().toString();


                getProductAtPID();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    UpdateData();
                }


            }
        });

    }

    private boolean validate() {

     String   name =newName.getText().toString();
     String email=newEmail.getText().toString();
       String cont = newcont.getText().toString();
      String  pass = newPass.getText().toString();
       String arid = newArid.getText().toString();

        if (name.length() == 0 || name.matches(negpat)) {
            newName.setError("Please enter correct name for the teacher.");
            return false;
        } else if (cont.length() == 0 || name.matches(negpat) || cont.length()>11 || cont.length()<11 || cont.matches(pattern)==false){
            newcont.setError("Please enter correct number");
            return false;
        }
        else if (pass.length() == 0 || name.matches(negpat)){
            newPass.setError("Please enter correct password");
            return false;
        }
        else if (arid.length() == 0 || arid.matches(negpat) ){
            newArid.setError("Please enter correct  Qualification ");
            return false;
        }
        else if (email.length() == 0 || email.matches(negpat)){
            newEmail.setError("Please enter correct  Email ");
            return false;}
            else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                newEmail.setError("Please enter a valid email address");
                return false;
        }
        else{
            return true;
        }
    }

    private void getProductAtPID() {

        Call<TeacherByid> call = teacherLoginServices.showTeacherData(pid);
        call.enqueue(new Callback<TeacherByid>() {
            @Override
            public void onResponse(Call<TeacherByid> call, retrofit2.Response<TeacherByid> response) {
                TeacherByid response1 = response.body();
                if (response1.getSuccess() == 1) {
                    StudentAtPID.setText("Teacher Email: " + response1.getStudent().get(0).getEmail() + "\n" +
                            "Teacher Name: " + response1.getStudent().get(0).getName() + "\n" +
                            "Teacher Qualification: " + response1.getStudent().get(0).getQual() + "\n"+
                            "Teacher Contact: " + response1.getStudent().get(0).getCont() + "\n"+
                            "Teacher Password: " + response1.getStudent().get(0).getPass() + "\n");
                    layout.setVisibility(View.VISIBLE);
                    buttonUpdate.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(UpdateTeacherActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeacherByid> call, Throwable t) {
                Toast.makeText(UpdateTeacherActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void UpdateData() {
        String name=newName.getText().toString().trim();
        String email=newEmail.getText().toString().trim();
        String cont=newcont.getText().toString().trim();
        String pass=newPass.getText().toString().trim();
        String qualification=newArid.getText().toString().trim();
        Call<StatusResponse> call = teacherLoginServices.updateTeacherData(pid,name,email,cont,pass,qualification);
        call.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, retrofit2.Response<StatusResponse> response) {
                StatusResponse response1 = response.body();
                if (response1.getMessage().equalsIgnoreCase("Updated")) {
                    Toast.makeText(UpdateTeacherActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                   // Intent i = new Intent(UpdateTeacherActivity.this,FeedbackFragment.class);
                   // startActivity(i);
                   // finish();
                } else {
                    Toast.makeText(UpdateTeacherActivity.this, "Failed to Update Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(UpdateTeacherActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
