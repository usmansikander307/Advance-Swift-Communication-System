package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class TeacherDeleteActivity extends AppCompatActivity {
    private Button buttonViewAtId, buttonDelete;
    private EditText productIdInput;
    private TextView productAtPID;
    //temporary string to show the parsed response
    private String jsonResponse;
    private static String TAG = DeleteProductActivity.class.getSimpleName();
    private ProgressDialog pDialog;
    private String pid;
    TeacherLoginServices teacherLoginServices;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_delete);
        buttonViewAtId = (Button) findViewById(R.id.btn_show_at_id);
        buttonDelete = (Button) findViewById(R.id.button_delete);
        teacherLoginServices = RetrofitClient.getClient().create(TeacherLoginServices.class);
        productAtPID = (TextView) findViewById(R.id.textview_product_at_id);

        layout = (LinearLayout) findViewById(R.id.product_deletion_view);

        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        buttonViewAtId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productIdInput = (EditText) findViewById(R.id.delete_product_id);
                pid = productIdInput.getText().toString();

                TeacherCall();

            }


        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData();
            }
        });
    }
    private void TeacherCall() {

        Call<TeacherByid> call=teacherLoginServices.showTeacherData(pid);
        call.enqueue(new Callback<TeacherByid>() {
            @Override
            public void onResponse(Call<TeacherByid> call, retrofit2.Response<TeacherByid> response) {
                TeacherByid response1=response.body();
                if(response1.getSuccess()==1)
                {
                    productAtPID.setText("Teacher Name: "+response1.getStudent().get(0).getName()+"\n"+
                            "Teacher Email: "+response1.getStudent().get(0).getEmail()+"\n"+
                            "Teacher Qualification: "+response1.getStudent().get(0).getQual()+"\n"+
                            "Teacher Contact: "+response1.getStudent().get(0).getCont()+"\n"+
                            "Teacher Password: "+response1.getStudent().get(0).getPass()+"\n");
                    layout.setVisibility(View.VISIBLE);


                }
                else
                {
                    Toast.makeText(TeacherDeleteActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TeacherByid> call, Throwable t) {
                Toast.makeText(TeacherDeleteActivity.this, "Exception: "+ t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DeleteData() {
        Call<StatusResponse> call=teacherLoginServices.deleteTeacherData(pid);
        call.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, retrofit2.Response<StatusResponse> response) {
                StatusResponse response1=response.body();
                if(response1.getMessage().equalsIgnoreCase("Deleted"))
                {
                    Toast.makeText(TeacherDeleteActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(TeacherDeleteActivity.this, "Failed to delete Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(TeacherDeleteActivity.this, "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
