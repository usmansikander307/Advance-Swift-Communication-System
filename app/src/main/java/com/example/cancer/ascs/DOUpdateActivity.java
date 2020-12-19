package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cancer.ascs.ModelClasses.DataOperator.DataOperatorbyid;
import com.example.cancer.ascs.ModelClasses.StatusResponse;
import com.example.cancer.ascs.ModelClasses.Student.StuddentById;

import retrofit2.Call;
import retrofit2.Callback;

public class DOUpdateActivity extends AppCompatActivity {
    Button buttonViewAtId, buttonUpdate;
    EditText studentIdInput, newName, newEmail, newcont, newPass;
    TextView StudentAtPID;
    String jsonResponse;
    static String TAG = UpdateProductActivity.class.getSimpleName();
    TeacherLoginServices teacherLoginServices;
    ProgressDialog pDialog;
    String pid;
    String pattern="^[0-9]$";
    String negpat="-[0-9]*";


    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doupdate);
        buttonViewAtId = (Button) findViewById(R.id.button_view_at_id);
        buttonUpdate = (Button) findViewById(R.id.btn_update);
        newName = (EditText) findViewById(R.id.new_name);
        teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        newEmail = (EditText) findViewById(R.id.new_price);
        newcont = (EditText) findViewById(R.id.new_description);
        newPass = (EditText) findViewById(R.id.new_pass);
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


        if (name.length() == 0  ||name.matches(negpat)) {
            newName.setError("Please enter correct name for the Student.");
            return false;
        } else if (email.length() == 0 || email.matches(negpat)){
            newEmail.setError("Please enter correct Email");
            return false;}
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            newEmail.setError("Please enter a valid email address");
            return false;
        }
        else if (cont.length() == 0 || cont.matches(negpat)){
            newcont.setError("Please enter correct Contact");
            return false;
        }
        else if (pass.length() == 0 || pass.matches(negpat)){
            newPass.setError("Please enter correct Password ");
            return false;
        }

        else{
            return true;
        }
    }


    private void getProductAtPID() {

        Call<DataOperatorbyid> call = teacherLoginServices.showdataoperatorData(pid);
        call.enqueue(new Callback<DataOperatorbyid>() {
            @Override
            public void onResponse(Call<DataOperatorbyid> call, retrofit2.Response<DataOperatorbyid> response) {
                DataOperatorbyid response1 = response.body();
                if (response1.getSuccess() == 1) {
                    StudentAtPID.setText(
                            " Name: " + response1.getStudent().get(0).getName() + "\n" +
                            " ID: " + response1.getStudent().get(0).getPid() + "\n"+
                            " Contact: " + response1.getStudent().get(0).getCont() + "\n"+
                            " Password: " + response1.getStudent().get(0).getPass() + "\n"+
                            " Email: "+response1.getStudent().get(0).getEmail()+"\n");
                    layout.setVisibility(View.VISIBLE);
                    buttonUpdate.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(DOUpdateActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DataOperatorbyid> call, Throwable t) {
                Toast.makeText(DOUpdateActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void UpdateData() {
        String name=newName.getText().toString().trim();
        String email=newEmail.getText().toString().trim();
        String cont=newcont.getText().toString().trim();
        String pass=newPass.getText().toString().trim();
        Call<StatusResponse> call = teacherLoginServices.updatedataoperatorData(pid,name,email,pass,cont);
        call.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, retrofit2.Response<StatusResponse> response) {
                StatusResponse response1 = response.body();
                if (response1.getMessage().equalsIgnoreCase("Updated")) {
                    Toast.makeText(DOUpdateActivity.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(DOUpdateActivity.this, "Failed to Update Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(DOUpdateActivity.this, "Exception: " + t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
