package com.example.wildeas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menulauncher, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
                Intent gotoAboutUs = new Intent(MainActivity.this, AboutUs.class);
                startActivity(gotoAboutUs);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button buttonGo = findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                 EditText textName = findViewById(R.id.textName);
                 EditText textPassword = findViewById(R.id.textPassword);
                 String login = textName.getText().toString();
                 String password = textPassword.getText().toString();
                    if (login.equals("wild") && password.equals("wild")) {

                        SharedPreferences sharedpref = MainActivity.this.getSharedPreferences("com.example.wildeas", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpref.edit();
                        editor.putString("Login", login);
                        editor.apply();
                        Intent homePage = new Intent(MainActivity.this, Home.class);
                        //homePage.putExtra("textName", login);
                        startActivity(homePage);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Wrong login/password", Toast.LENGTH_LONG).show();
                    }
            }

        });
    }
}