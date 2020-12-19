package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class DeleteProductActivity extends AppCompatActivity {
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
        setContentView(R.layout.activity_delete_product);
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

                StudentCall();

            }


        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteData();
            }
        });
    }
    private void StudentCall() {

        Call<StuddentById> call=teacherLoginServices.showStudentData(pid);
        call.enqueue(new Callback<StuddentById>() {
            @Override
            public void onResponse(Call<StuddentById> call, retrofit2.Response<StuddentById> response) {
                StuddentById response1=response.body();
                if(response1.getSuccess()==1)
                {
                    productAtPID.setText("Arid No: "+response1.getStudent().get(0).getArid()+"\n"+
                            "Student Name: "+response1.getStudent().get(0).getName()+"\n"+
                            "Student ID: "+response1.getStudent().get(0).getPid()+"\n"+
                            "Student Email: "+response1.getStudent().get(0).getEmail()+"\n"+
                            "Student Password: "+response1.getStudent().get(0).getPass()+"\n");
                    layout.setVisibility(View.VISIBLE);


                }
                else
                {
                    Toast.makeText(DeleteProductActivity.this, "No Record Found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StuddentById> call, Throwable t) {
                Toast.makeText(DeleteProductActivity.this, "Exception: "+ t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void DeleteData() {
        Call<StatusResponse> call=teacherLoginServices.deleteStudentData(pid);
        call.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, retrofit2.Response<StatusResponse> response) {
                StatusResponse response1=response.body();
                if(response1.getMessage().equalsIgnoreCase("Deleted"))
                {
                    Toast.makeText(DeleteProductActivity.this, "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DeleteProductActivity.this, "Failed to delete Data", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(DeleteProductActivity.this, "Exception: "+t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
