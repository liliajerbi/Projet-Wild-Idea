package com.example.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Intent intent = getIntent();
        String extraValue = intent.getStringExtra("LOGIN");
        Toast.makeText(HomeActivity.this, extraValue, Toast.LENGTH_LONG).show();
    }
}
