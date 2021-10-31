package com.ucas.android.parsejson.file;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ucas.android.parsejson.R;
import com.ucas.android.parsejson.model.Address;
import com.ucas.android.parsejson.model.Company;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ReadJsonFileFromRawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_json_file_from_raw);
        TextView nameTv = findViewById(R.id.name_tv);
        TextView websitesTv = findViewById(R.id.website_tv);
        TextView streetTv = findViewById(R.id.street_tv);
        TextView cityTv = findViewById(R.id.city_tv);
        try {
            Company company = readCompanyJSONFile();
            nameTv.setText(company.getName());
            streetTv.setText(company.getAddress().getStreet());
            cityTv.setText(company.getAddress().getCity());

            StringBuilder websiteStr = new StringBuilder();
            for (int i = 0; i < company.getWebsites().length; i++) {
                websiteStr.append(company.getWebsites()[i]).append("\n");
            }
            websitesTv.setText(websiteStr.toString());

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }


    public Company readCompanyJSONFile() throws IOException, JSONException {

        // Read content of user_list.json
        String jsonText = readText(this, R.raw.company);


        JSONObject jsonRoot = new JSONObject(jsonText);


        int id = jsonRoot.getInt("id");
        String name = jsonRoot.getString("name");

        JSONArray jsonArray = jsonRoot.getJSONArray("websites");
        String[] websites = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {
            websites[i] = jsonArray.getString(i);
        }

        JSONObject jsonAddress = jsonRoot.getJSONObject("address");
        String street = jsonAddress.getString("street");
        String city = jsonAddress.getString("city");
        Address address = new Address(street, city);

        Company company = new Company();
        company.setId(id);
        company.setName(name);
        company.setAddress(address);
        company.setWebsites(websites);
        return company;
    }


    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String s = null;
        while ((s = br.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}