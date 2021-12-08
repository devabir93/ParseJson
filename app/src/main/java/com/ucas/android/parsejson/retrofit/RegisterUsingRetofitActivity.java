package com.ucas.android.parsejson.retrofit;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ucas.android.parsejson.R;
import com.ucas.android.parsejson.model.RegisterRequestBody;
import com.ucas.android.parsejson.model.RegisterResponse;
import com.ucas.android.parsejson.model.UserResponse;
import com.ucas.android.parsejson.volley.GetUsersActivity;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterUsingRetofitActivity extends AppCompatActivity {
    Button registerBtn;
    EditText emailET, passwrodET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailET = findViewById(R.id.username);
        passwrodET = findViewById(R.id.password);
        registerBtn = findViewById(R.id.register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUsingRetrofit();
            }
        });
    }

    public void registerUsingRetrofit(){
        RegisterRequestBody user = new RegisterRequestBody("eve.holt@reqres.in","pistol");
        Service.RetrofitClient.getRetrofitInstance().register(user).enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, retrofit2.Response<RegisterResponse> response) {
                Toast.makeText(RegisterUsingRetofitActivity.this, "Welcome your id is" + response.body().getId(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }

}