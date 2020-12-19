package com.example.cancer.ascs;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ViewAllTeacher extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private static String TAG = MainActivity.class.getSimpleName();

    //progress dialog
    private ProgressDialog pDialog;

    private ListView studentsList;
    private TextView noConnection;
    private TextView viewDescription;
    private SwipeRefreshLayout swipeLayout;

    //temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_teacher);
        studentsList = (ListView) findViewById(R.id.listview_all_products);
        noConnection = (TextView) findViewById(R.id.no_connection);
        viewDescription = (TextView) findViewById(R.id.view_description);
        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_layout);
        swipeLayout.setOnRefreshListener(this);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please Wait....");
        pDialog.setCancelable(false);

        if (checkForConnection()){
            viewDescription.setVisibility(View.VISIBLE);
            makeJsonObjectRequest();
        }
        else{
            viewDescription.setVisibility(View.GONE);
            noConnection.setVisibility(View.VISIBLE);
        }
    }

    private void makeJsonObjectRequest() {

        showpDialog();

        final List<String> studentssArrayList = new ArrayList<String>();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                EndPoint.URL_SHOWTEACHER,null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString()); //for android log cat??

                        try {
                            // Parsing json object response
                            // response will be a json object


                            int success = response.getInt("success");
                            if (success == 1){
                                JSONArray students = response.getJSONArray("students");
                                for(int i =0; i<students.length(); i++){
                                    JSONObject phone = students.getJSONObject(i);
                                    String name = phone.get("name").toString();
                                    String email = phone.get("email").toString();
                                    String cont = phone.get("cont").toString();
                                    String pass = phone.get("pass").toString();
                                    String arid = phone.get("qual").toString();

                                   // jsonResponse +="";

                                    jsonResponse += "Name: " + name + "\n\n";
                                    jsonResponse += "Email: " + email + "\n\n";
                                    jsonResponse += "Contact: " + cont + "\n\n";
                                    jsonResponse += "Password: " + pass + "\n\n";
                                    jsonResponse += "Qualification: " + arid + "\n\n";
                                    studentssArrayList.add(jsonResponse);

                                }

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                                        ViewAllTeacher.this,
                                        android.R.layout.simple_list_item_1,
                                        studentssArrayList );

                                studentsList.setAdapter(arrayAdapter);
                            }
                            else {
                                Toast.makeText(ViewAllTeacher.this, "No teachers in the database", Toast.LENGTH_LONG).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog();

                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG,"Error: "+ volleyError.getMessage() );
                Toast.makeText(getApplicationContext(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });
        //adding request to request queue
        AppController.getInstance(ViewAllTeacher.this).addToRequestQueue(jsonObjReq);
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

    @Override
    public void onRefresh() {
        if (checkForConnection()){
            viewDescription.setVisibility(View.VISIBLE);
            noConnection.setVisibility(View.GONE);
            makeJsonObjectRequest();
            swipeLayout.setRefreshing(false);

        }
        else{
            studentsList.setVisibility(View.GONE);
            viewDescription.setVisibility(View.GONE);
            noConnection.setVisibility(View.VISIBLE);
            swipeLayout.setRefreshing(false);

        }
    }

    @Override
    public void onDestroy() {
        // You must call this or the ad adapter may cause a memory leak
        super.onDestroy();
    }

    private Boolean checkForConnection() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
