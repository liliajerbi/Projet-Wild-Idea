package com.example.wildeas;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.IOException;

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
                builder.setTitle("Attention");
                builder.setMessage("Do you really want to quit this beautiful application ?");
                builder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoMain = new Intent(Todo.this, MainActivity.class);
                        startActivity(gotoMain);
                    }
                });
                builder.setNegativeButton("No", null);
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
        ImageView image = findViewById(R.id.imgViewIcon);

        Intent goToToDo = getIntent();
        String datevalue = goToToDo.getStringExtra("date");
        String titrevalue = goToToDo.getStringExtra("title");
        String descriptionvalue = goToToDo.getStringExtra("description");
        String imageValue = goToToDo.getStringExtra("image");

        loadImage(imageValue, image);
        date.setText(datevalue);
        titre.setText(titrevalue);
        description.setText(descriptionvalue);


    }

    public void loadImage(String imageValue, ImageView image) {
        Uri myUri = Uri.parse(imageValue);
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), myUri);
            image.setImageBitmap(bitmap);
        } catch (IOException e) {
            int resId = getResources().getIdentifier(imageValue, "drawable", getPackageName());
            image.setImageResource(resId);
            e.printStackTrace();
        }
    }
}
