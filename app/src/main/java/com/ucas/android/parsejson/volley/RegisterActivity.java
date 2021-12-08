package com.ucas.android.parsejson.volley;

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
import com.ucas.android.parsejson.model.User;
import com.ucas.android.parsejson.model.UserResponse;
import com.ucas.android.parsejson.retrofit.Service;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;

public class RegisterActivity extends AppCompatActivity {
    private String base_url = "https://reqres.in/api/";
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
                makeRegisterRequest();
            }
        });
    }

    public void makeRegisterRequest() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("email", emailET.getText().toString());
            jsonObject.put("password", passwrodET.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, base_url + "register", jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("RegisterActivity", response.toString());
                try {
                    int id = response.getInt("id");
                    String token = response.getString("token");
                    Toast.makeText(RegisterActivity.this, "Welecome your id is" + id, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, GetUsersActivity.class));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        });

        requestQueue.add(jsonObjectRequest);
    }

}