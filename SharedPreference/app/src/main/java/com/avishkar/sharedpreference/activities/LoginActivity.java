package com.avishkar.sharedpreference.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.avishkar.sharedpreference.Constant;
import com.avishkar.sharedpreference.MainActivity;
import com.avishkar.sharedpreference.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        //init comp
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


    }
    private void login() {
        SharedPreferences preferences = getSharedPreferences(Constant.shared_pref_name,MODE_PRIVATE); //creating a local storage in android
        SharedPreferences.Editor editor = preferences.edit(); //create a reference of an editor interface (used for writing in storage)
        editor.putBoolean("isLoggedIn",true);
        editor.apply();
        Toast.makeText(this, "Login successfully....", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

}