package com.ucas.android.parsejson.string;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ucas.android.parsejson.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ParseJsonFromStringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nameTv = findViewById(R.id.name_tv);
        TextView emailTv = findViewById(R.id.email_tv);
        TextView ageTv = findViewById(R.id.age_tv);
        String jsonStr = "{\"name\":\"Abir Abdullah\",\"Email\":\"ambadullah@ucas.edu.ps\",\"age\":28}";
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            String name = jsonObject.getString("name");
            String email = jsonObject.getString("Email");
            String age = jsonObject.getString("age");

            nameTv.setText(name);
            emailTv.setText(email);
            ageTv.setText(String.valueOf(age));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}