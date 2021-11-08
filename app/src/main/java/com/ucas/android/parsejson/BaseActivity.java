package com.ucas.android.parsejson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ucas.android.parsejson.file.ParseJsonFileFromAssetsActivity;
import com.ucas.android.parsejson.file.ReadJsonFileFromRawActivity;
import com.ucas.android.parsejson.string.ParseJsonArrayFromStringActivity;
import com.ucas.android.parsejson.string.ParseJsonFromStringActivity;
import com.ucas.android.parsejson.volley.RegisterActivity;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    Button json_string_button, jsonArray_string_button, raw_button, assets_button, volley_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        json_string_button = findViewById(R.id.json_string_button);
        jsonArray_string_button = findViewById(R.id.jsonArray_string_button);
        raw_button = findViewById(R.id.raw_button);
        assets_button = findViewById(R.id.assets_button);
        volley_button = findViewById(R.id.volley_button);

        json_string_button.setOnClickListener(this);
        jsonArray_string_button.setOnClickListener(this);
        raw_button.setOnClickListener(this);
        assets_button.setOnClickListener(this);
        volley_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.json_string_button:
                startActivity(new Intent(BaseActivity.this, ParseJsonFromStringActivity.class));
                break;
            case R.id.jsonArray_string_button:
                startActivity(new Intent(BaseActivity.this, ParseJsonArrayFromStringActivity.class));
                break;
            case R.id.raw_button:
                startActivity(new Intent(BaseActivity.this, ReadJsonFileFromRawActivity.class));
                break;
            case R.id.assets_button:
                startActivity(new Intent(BaseActivity.this, ParseJsonFileFromAssetsActivity.class));
                break;
            case R.id.volley_button:
                startActivity(new Intent(BaseActivity.this, RegisterActivity.class));
                break;
        }
    }
}