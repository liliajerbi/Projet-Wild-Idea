package com.example.wildeas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Todo extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_aboutUs:
                Intent gotoAboutUs = new Intent(Todo.this, Home.class);
                startActivity(gotoAboutUs);
                return true;
            case R.id.action_deco:
                Intent gotoMain = new Intent(Todo.this, MainActivity.class);
                startActivity(gotoMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        TextView titre = findViewById(R.id.titre);
        TextView description = findViewById(R.id.description);
        TextView date = findViewById(R.id.date);

        Intent goToToDo = getIntent();
        String datevalue = goToToDo.getStringExtra("date");
        String titrevalue = goToToDo.getStringExtra("title");
        String descriptionvalue = goToToDo.getStringExtra("description");

        date.setText(datevalue);
        titre.setText(titrevalue);
        description.setText(descriptionvalue);

    }
}
