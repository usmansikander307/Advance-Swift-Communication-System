package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.cancer.ascs.ModelClasses.StatusResponse;
import com.example.cancer.ascs.ModelClasses.Student.StuddentById;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

public class UpdateProductActivity extends AppCompatActivity {
    Button buttonViewAtId, buttonUpdate;
    EditText studentIdInput, newName, newEmail, newcont, newPass, newArid;
    TextView StudentAtPID;
    String jsonResponse;
    static String TAG = UpdateProductActivity.class.getSimpleName();
    TeacherLoginServices teacherLoginServices;
    ProgressDialog pDialog;
    String pid;
    String aridpat="([0-9]{2})-([A-Z]{4})-([0-9]{2})";
    String negpat="-[0-9]*";


    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);
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
                String cont=newcont.getText().toString();

                getProductAtPID();
            }
        });
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate())
                {
                    UpdateData();
                }



            }
        });

    }

    private boolean validate() {

        String   name =newName.getText().toString();
        String email = newEmail.getText().toString();
        String  cont = newcont.getText().toString();
        String pass = newPass.getText().toString();
        String arid = newPass.getText().toString();

        if (name.length() == 0 || name.matches(negpat)) {
            newName.setError("Please enter correct name for the Student.");
            return false;
        } else if (email.length() == 0 || email.matches(negpat)){
            newEmail.setError("Please enter correct Email");
            return false;
        }
             else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                newEmail.setError("Please enter a valid email address");
                return false;
        }
        else if (cont.length() == 0  || cont.matches(negpat) ){
            newcont.setError("Please enter correct Contact");
            return false;
        }
        else if (pass.length() == 0 || pass.matches(negpat) ){
            newPass.setError("Please enter correct Password ");
            return false;
        }
        else if (arid.length() == 0 ||  arid.matches(aridpat)==false){
            newArid.setError("Please enter correct Password ");
            return false;
        }
        else{
            return true;
        }
    }


    private void getProductAtPID() {

        Call<StuddentById> call = teacherLoginServices.showStudentData(pid);
        call.enqueue(new Callback<StuddentById>() {
            @Override
            public void onResponse(Call<StuddentById> call, retrofit2.Response<StuddentById> response) {
                StuddentById response1 = response.body();
                if (response1.getSuccess() == 1) {
                    StudentAtPID.setText("Arid No: " + response1.getStudent().get(0).getArid() + "\n" +
                            "Student Name: " + response1.getStudent().get(0).getName() + "\n" +
                            "Student ID: " + response1.getStudent().get(0).getPid() + "\n"+
                            "Student Contact: " + response1.getStudent().get(0).getCont() + "\n"+
                            "Student Password: " + response1.getStudent().get(0).getPass() + "\n"+
                            "Student Email: "+response1.getStudent().get(0).getEmail()+"\n");
                    layout.setVisibility(View.VISIBLE);
                    buttonUpdate.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(UpdateProductActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StuddentById> call, Throwable t) {
                Toast.makeText(UpdateProductActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void UpdateData() {
        String name=newName.getText().toString().trim();
        String email=newEmail.getText().toString().trim();
        String cont=newcont.getText().toString().trim();
        String pass=newPass.getText().toString().trim();
      String arid=newArid.getText().toString().trim();
        Call<StatusResponse> call = teacherLoginServices.updateStudentData(pid,name,email,cont,pass,arid);
        call.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, retrofit2.Response<StatusResponse> response) {
                StatusResponse response1 = response.body();
                if (response1.getMessage().equalsIgnoreCase("Updated")) {
                    Toast.makeText(UpdateProductActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(UpdateProductActivity.this, "Failed to Update Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(UpdateProductActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
