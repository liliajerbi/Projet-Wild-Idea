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

                EditText title_text = findViewById(R.id.title_text);
                String titleText = title_text.getText().toString();
                EditText descripiton_text = findViewById(R.id.descripiton_text);
                String descripitonText = descripiton_text.getText().toString();
                EditText date_text = findViewById(R.id.date_text);
                String dateText = date_text.getText().toString();
                EditText typeText = findViewById(R.id.type_text);
                String categorie = typeText.getText().toString();
                Intent homePage = new Intent(add_page.this, Home.class);
                homePage.putExtra("titleText", titleText);
                homePage.putExtra("dateText", dateText);
                homePage.putExtra("descripitonText", descripitonText);
                homePage.putExtra("categorieText" , categorie);
                startActivity(homePage);
            }
        });

    }

}
