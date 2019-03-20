package com.example.wildeas;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class add_page extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
                Intent gotoAboutUs = new Intent(add_page.this, AboutUs.class);
                startActivity(gotoAboutUs);
                return true;
            case R.id.action_deco:
                AlertDialog.Builder builder = new AlertDialog.Builder(add_page.this);
                builder.setTitle("Attention");
                builder.setMessage("Do you really want to quit this beautiful application ?");
                builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoMain = new Intent(add_page.this, MainActivity.class);
                        startActivity(gotoMain);
                    }
                });
                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.action_home:
                Intent gotoHome = new Intent(add_page.this, Home.class);
                startActivity(gotoHome);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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
                String categorieChoix = typeText.getText().toString();
                Intent homePage = new Intent(add_page.this, Home.class);
                homePage.putExtra("titleText", titleText);
                homePage.putExtra("dateText", dateText);
                homePage.putExtra("descripitonText", descripitonText);
                homePage.putExtra("categorieText" , categorieChoix);
                startActivity(homePage);
            }
        });

    }

}
