package com.example.wildeas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.wildeas.R.layout.activity_launcher;

public class LauncherActivity extends AppCompatActivity {

    private final int LAUNCH_TIME_OUT = 3000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent mainIntent = new Intent(LauncherActivity.this, MainActivity.class);
                LauncherActivity.this.startActivity(mainIntent);
                LauncherActivity.this.finish();
            }
        }, LAUNCH_TIME_OUT);


    }
}
