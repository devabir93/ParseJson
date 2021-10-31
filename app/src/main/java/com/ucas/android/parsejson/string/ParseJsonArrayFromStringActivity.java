package com.ucas.android.parsejson.string;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ucas.android.parsejson.CustomAdapter;
import com.ucas.android.parsejson.R;
import com.ucas.android.parsejson.model.Contact;
import com.ucas.android.parsejson.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ParseJsonArrayFromStringActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<User> userList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientation
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        parsejson();
    }

    private void parsejson() {
        try {
            JSONObject jsonObjectFile = new JSONObject(getListData());
            JSONArray jsonArray = jsonObjectFile.getJSONArray("users");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int id = jsonObject1.getInt("id");
                String name = jsonObject1.getString("name");
                String email = jsonObject1.getString("email");
                String gender = jsonObject1.getString("gender");

                JSONObject contactObj = jsonObject1.getJSONObject("contact");
                String mobile = contactObj.getString("mobile");
                String home = contactObj.getString("home");
                Contact contact = new Contact();
                contact.setMobile(mobile);
                contact.setHomee(home);

                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setEmail(email);
                user.setContact(contact);
                user.setGender(gender);

                userList.add(user);

            }
            Log.d("userList", userList.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        CustomAdapter customAdapter = new CustomAdapter(ParseJsonArrayFromStringActivity.this, userList);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }


    private String getListData() {
        String jsonStr = "{\n" +
                "  \"users\": [\n" +
                "    {\n" +
                "      \"id\": \"1087\",\n" +
                "      \"name\": \"Abhishek Saini\",\n" +
                "      \"email\": \"saini.abhishek@gmail.com\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"contact\": {\n" +
                "        \"mobile\": \"+91 0000000000\",\n" +
                "        \"home\": \"00 000000\",\n" +
                "        \"office\": \"00 000000\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1088\",\n" +
                "      \"name\": \"Gourav\",\n" +
                "      \"email\": \"gourav9188@gmail.com\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"contact\": {\n" +
                "        \"mobile\": \"+91 0000000000\",\n" +
                "        \"home\": \"00 000000\",\n" +
                "        \"office\": \"00 000000\"\n" +
                "      }\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"1089\",\n" +
                "      \"name\": \"Akshay\",\n" +
                "      \"email\": \"akshay@gmail.com\",\n" +
                "      \"gender\": \"male\",\n" +
                "      \"contact\": {\n" +
                "        \"mobile\": \"+91 0000000000\",\n" +
                "        \"home\": \"00 000000\",\n" +
                "        \"office\": \"00 000000\"\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        return jsonStr;
    }

}