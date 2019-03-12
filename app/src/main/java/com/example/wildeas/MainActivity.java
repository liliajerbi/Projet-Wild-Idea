package com.example.wildeas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonGo = findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText textName = findViewById(R.id.textName);

                Intent HomePage = new Intent(MainActivity.this, Home.class);
                startActivity(HomePage);
            }
        });
    }
}
