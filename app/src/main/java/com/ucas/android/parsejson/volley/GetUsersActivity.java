package com.ucas.android.parsejson.volley;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetUsersActivity extends AppCompatActivity {

    String baseUrl = "https://run.mocky.io/v3/429be02a-c716-4c3a-9c7f-9c5b847cc84e";
    List<User> userList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);
        // get the reference of RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        getUsers();
    }

    private void getUsers() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, baseUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("GetUsersActivity", response.toString());
                try {
                    JSONArray userArray = response.getJSONArray("users");
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
                CustomAdapter customAdapter = new CustomAdapter(GetUsersActivity.this, userList);
                recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @org.jetbrains.annotations.Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("","");
                return map;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                return super.getHeaders();
            }
        };
        requestQueue.add(jsonObjectRequest);
    }
    private void getUsersString() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest jsonObjectRequest = new StringRequest(Request.Method.GET, baseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("GetUsersActivity", response);
                try {
                    JSONObject jsonObject = new JSONObject((response));
                    JSONArray userArray = jsonObject.getJSONArray("users");
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
                CustomAdapter customAdapter = new CustomAdapter(GetUsersActivity.this, userList);
                recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}