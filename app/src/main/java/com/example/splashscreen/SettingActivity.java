package com.example.splashscreen;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText etName, etContact, etAddress, etRedMsg, etYellowMsg, etGreenMsg, etP1, etP2, etP3, etP4, etP5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        etName = findViewById(R.id.etName);
        etContact = findViewById(R.id.etContact);
        etAddress = findViewById(R.id.etAddress);
        etRedMsg = findViewById(R.id.etRedMsg);
        etYellowMsg = findViewById(R.id.etYellowMsg);
        etGreenMsg = findViewById(R.id.etGreenMsg);
        etP1 = findViewById(R.id.etP1);
        etP2 = findViewById(R.id.etP2);
        etP3 = findViewById(R.id.etP3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences("myPreference", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("name"))
            etName.setText(sharedPreferences.getString("name", ""));
        if (sharedPreferences.contains("contact"))
            etContact.setText(sharedPreferences.getString("contact", ""));
        if (sharedPreferences.contains("address"))
            etAddress.setText(sharedPreferences.getString("address", ""));

        if (sharedPreferences.contains("redMsg"))
            etRedMsg.setText(sharedPreferences.getString("redMsg", ""));
        if (sharedPreferences.contains("yellowMsg"))
            etYellowMsg.setText(sharedPreferences.getString("yellowMsg", ""));
        if (sharedPreferences.contains("greenMsg"))
            etGreenMsg.setText(sharedPreferences.getString("greenMsg", ""));

        if (sharedPreferences.contains("p1"))
            etP1.setText(sharedPreferences.getString("p1", ""));
        if (sharedPreferences.contains("p2"))
            etP2.setText(sharedPreferences.getString("p2", ""));
        if (sharedPreferences.contains("p3"))
            etP3.setText(sharedPreferences.getString("p3", ""));
    }

    private void setData(String name, String contact, String address, String redMsg, String yellowMsg,
                         String greenMsg, String p1, String p2, String p3) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.putString("contact", contact);
        editor.putString("address", address);

        editor.putString("redMsg", redMsg);
        editor.putString("yellowMsg", yellowMsg);
        editor.putString("greenMsg", greenMsg);

        editor.putString("p1", p1);
        editor.putString("p2", p2);
        editor.putString("p3", p3);
        editor.commit();

        etName.setText("");
        etContact.setText("");
        etAddress.setText("");

        etRedMsg.setText("");
        etYellowMsg.setText("");
        etGreenMsg.setText("");

        etP1.setText("");
        etP2.setText("");
        etP3.setText("");
    }

    public void saveClick(View view) {
        String name = etName.getText().toString().trim();
        String contact = etContact.getText().toString().trim();
        String address = etAddress.getText().toString().trim();

        String redMsg = etRedMsg.getText().toString().trim();
        String yellowMsg = etYellowMsg.getText().toString().trim();
        String greenMsg = etGreenMsg.getText().toString().trim();

        String p1 = etP1.getText().toString().trim();
        String p2 = etP2.getText().toString().trim();
        String p3 = etP3.getText().toString().trim();
        setData(name, contact, address, redMsg, yellowMsg, greenMsg, p1, p2, p3);
        Toast.makeText(this, "Successfully Saved...!!!!", Toast.LENGTH_SHORT).show();
        finish();
    }

}