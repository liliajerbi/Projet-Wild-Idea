package com.example.wildeas;


import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import java.io.IOException;


public class add_page extends AppCompatActivity {
    String mImageUrl = null;
    String category ="";

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
                builder.setTitle(R.string.caution);
                builder.setMessage(R.string.messagequit);
                builder.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent gotoMain = new Intent(add_page.this, MainActivity.class);
                        startActivity(gotoMain);
                    }
                });
                builder.setNegativeButton(R.string.no, null);
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                mImageUrl = uri.toString();
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.imgView);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void buttonchecked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioCine:
                if (checked)
                    category = "Film";
                    break;
            case  R.id.radioSerie:
                if (checked)
                    category = "Serie";
                    break;
            case  R.id.radioAnime:
                if (checked)
                    category = "Anime";
                    break;
        }
    }

    final int PICK_IMAGE_REQUEST = 1400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        Button button_add= findViewById(R.id.button_add);
        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(add_page.this);
                builder.setTitle(R.string.caution);
                builder.setMessage(R.string.confirmadd);
                builder.setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText title_text = findViewById(R.id.title_text);
                        String titleText = title_text.getText().toString();
                        EditText descripiton_text = findViewById(R.id.descripiton_text);
                        String descripitonText = descripiton_text.getText().toString();
                        EditText date_text = findViewById(R.id.date_text);
                        String dateText = date_text.getText().toString();

                        Intent homePage = new Intent(add_page.this, Home.class);
                        homePage.putExtra("titleText", titleText);
                        homePage.putExtra("dateText", dateText);
                        homePage.putExtra("descripitonText", descripitonText);
                        homePage.putExtra("imageIcon",mImageUrl );
                        homePage.putExtra("categorie", category);

                        startActivity(homePage);
                    }
                });
                builder.setNegativeButton(R.string.no, null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        Button buttonLoadImage = findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent();
// Show only images, no videos or anything else
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
// Always show the chooser (if there are multiple options available)
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
            }
        });
    }

}
