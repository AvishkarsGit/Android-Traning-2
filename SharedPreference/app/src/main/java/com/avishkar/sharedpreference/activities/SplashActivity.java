package com.avishkar.sharedpreference.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.avishkar.sharedpreference.Constant;
import com.avishkar.sharedpreference.MainActivity;
import com.avishkar.sharedpreference.R;

public class SplashActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Handler handler = new Handler();
        Runnable runnable= new Runnable() {
            @Override
            public void run() {
               checkLogin();
            }
        };
        handler.postDelayed(runnable, 3000); //1000 = 1second
    }

    private void checkLogin() {
        SharedPreferences preferences = getSharedPreferences(Constant.shared_pref_name,MODE_PRIVATE);
        boolean login = preferences.getBoolean("isLoggedIn",false);
        Intent i;
        if (login) {
           i = new Intent(SplashActivity.this, MainActivity.class);

        }
        else {
          i = new Intent(SplashActivity.this, LoginActivity.class);

        }
        startActivity(i);
        finish();
    }
}
