package com.ucas.android.parsejson.volley;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ucas.android.parsejson.CustomAdapter;
import com.ucas.android.parsejson.R;
import com.ucas.android.parsejson.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VolleyActivity extends AppCompatActivity {
    private String url = "https://run.mocky.io/v3/c885d250-6078-4618-8155-ce66d5ff1e61";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // get the reference of RecyclerView
         recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        fetchJsonObject();


        //fetchStringObject();
    }

    private void fetchStringObject() {
        List<User> userList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("onResponse",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
    private void fetchJsonObject() {
        List<User> userList = new ArrayList<>();
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest stringRequest=new JsonObjectRequest(Request.Method.GET, url,null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("onResponse",response.toString());
                try {
                    // get JSONObject from JSON file
                    // fetch JSONArray named users
                    JSONArray userArray = response.getJSONArray("users");
                    // implement for loop for getting users list data

                    for (int i = 0; i < userArray.length(); i++) {
                        // create a JSONObject for fetching single user data
                        JSONObject userDetail = userArray.getJSONObject(i);
                        // fetch email and name and store it in arraylist
                        User user = new User();
                        user.setName(userDetail.getString("name"));
                        user.setEmail(userDetail.getString("email"));
                        // create a object for getting contact data from JSONObject
                        // fetch mobile number and store it in arraylist
                        userList.add(user);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //  call the constructor of CustomAdapter to send the reference and data to Adapter
                CustomAdapter customAdapter = new CustomAdapter(VolleyActivity.this, userList);
                recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(stringRequest);
    }
}