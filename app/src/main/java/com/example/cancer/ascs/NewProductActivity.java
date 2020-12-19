package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class NewProductActivity extends AppCompatActivity {
    private EditText Name,Email,Contact,Passw,aridnum;
    private Button btnAdd;
    private ProgressDialog pDialog;
    private static String TAG = NewProductActivity.class.getSimpleName();

    String name,email,cont,pass,arid;
    String aridpat="([0-9]{2})-([A-Z]{4})-([0-9]{2})";
    String negpat="-[0-9]*";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        Name = (EditText) findViewById(R.id.name);
        Email = (EditText) findViewById(R.id.email);
        Contact = (EditText) findViewById(R.id.cont);
        Passw = (EditText) findViewById(R.id.pass);
        aridnum = (EditText) findViewById(R.id.arid);

        btnAdd = (Button) findViewById(R.id.button);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Adding the Student to our database");
        pDialog.setCancelable(false);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    addNewProductToDatabase();
                }

            }
        });
    }

    private boolean validate() {

        name = Name.getText().toString();
        email = Email.getText().toString();
        cont = Contact.getText().toString();
        pass = Passw.getText().toString();
     arid = aridnum.getText().toString();

        if (name.length() == 0 || name.matches(negpat)) {
            Name.setError("Please enter correct name for the student.");
            return false;
        } else if(email.length()==0 || email.matches(negpat)){
            Email.setError("Please enter correct email for the student.");
            return false;}
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Email.setError("Please enter a valid email address");
            return false;
        } else if (cont.length() == 0 || cont.matches(negpat)){
            Contact.setError("Please enter correct number");
            return false;
        }
        else if (pass.length() == 0 || pass.matches(negpat)){
            Passw.setError("Please enter correct password");
            return false;
        }
        else if (arid.length() == 0 || arid.matches(negpat) || arid.matches(aridpat)==false){
            aridnum.setError("Please enter correct  arid number");
            return false;
        }
        else{
            return true;
        }
    }

    private void addNewProductToDatabase(){

        showpDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, EndPoint.URL_ADD,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Students").child(aridnum.getText().toString().trim());
                        databaseReference.child("name").setValue(Name.getText().toString().trim());
                        databaseReference.child("Email").setValue(Email.getText().toString().trim());


                        resetFields();
                        hidepDialog();
                        Toast.makeText(NewProductActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hidepDialog();
                        Toast.makeText(NewProductActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("Std_name",name);
                params.put("Std_email",email);
                params.put("Std_cont", cont);
                params.put("Std_pass",pass);
                params.put("Std_arid",arid);

                return params;
            }
        };
        AppController.getInstance(NewProductActivity.this).addToRequestQueue(stringRequest);

    }

    private void resetFields() {
        Name.setText("");
        Email.setText("");
        Contact.setText("");
        Passw.setText("");
        aridnum.setText("");
    }


    private void showpDialog(){
        if(!pDialog.isShowing()){
            pDialog.show();
        }
    }

    private void hidepDialog(){
        if(pDialog.isShowing()){
            pDialog.dismiss();
        }
    }
}
