package com.example.wildeas;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class add_page extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);



        Button button_add= findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st;
                EditText title_text = findViewById(R.id.title_text);

                EditText description_text = findViewById(R.id.descripiton_text);

                st=title_text.getText().toString();
                //("Value",st);



                //passer à la page Home
                Intent Home = new Intent(add_page.this, Home.class);
                startActivity(Home);

            }
        });

    }
}
