package com.example.wildeas;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
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
                Intent gotoMain = new Intent(add_page.this, MainActivity.class);
                startActivity(gotoMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    final int RESULT_LOAD_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);


        Button button_add = findViewById(R.id.button_add);
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
                homePage.putExtra("categorieText", categorieChoix);
                //homePage.putExtra("mnemonic", )
                startActivity(homePage);
            }
        });

        Button buttonLoadImage = findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};

                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String picturePath = cursor.getString(columnIndex);
                cursor.close();

                ImageView imageView = (ImageView) findViewById(R.id.imgView);
                imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

            }

        }

}
