package com.ucas.android.parsejson.retrofit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ucas.android.parsejson.CustomAdapter;
import com.ucas.android.parsejson.CustomAdapter2;
import com.ucas.android.parsejson.R;
import com.ucas.android.parsejson.model.User;
import com.ucas.android.parsejson.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitGetUserActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    CustomAdapter2 customAdapter;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);
        // get the reference of RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        customAdapter = new CustomAdapter2(RetrofitGetUserActivity.this);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
        service=Service.RetrofitClient.getRetrofitInstance();
        getUsers();

    }

    private void getUsers() {
        service.getUsers().enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.body() != null)
                    customAdapter.setData(response.body().getUserList());

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}