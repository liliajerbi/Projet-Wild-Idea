package com.example.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.buttonSend);
        final EditText first = findViewById(R.id.firstnameText);
        final EditText last = findViewById(R.id.lastnameText);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String lastname = last.getText().toString();
                final String firstname = first.getText().toString();
                Toast.makeText(MainActivity.this, "Congratulation " + firstname + " " + lastname, Toast.LENGTH_SHORT).show();
            }
        });
    }
}