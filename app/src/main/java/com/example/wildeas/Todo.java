package com.example.wildeas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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
                Intent gotoAboutUs = new Intent(Todo.this, AboutUs.class);
                startActivity(gotoAboutUs);
                return true;
            case R.id.action_deco:
                AlertDialog.Builder builder = new AlertDialog.Builder(Todo.this);
                builder.setTitle(R.string.caution);
                builder.setMessage(R.string.messagequit);
                builder.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoMain = new Intent(Todo.this, MainActivity.class);
                        startActivity(gotoMain);
                    }
                });
                builder.setNegativeButton(R.string.no, null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            case R.id.action_home:
                Intent gotoHome = new Intent(Todo.this, Home.class);
                startActivity(gotoHome);
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
