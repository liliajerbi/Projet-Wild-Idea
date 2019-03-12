package com.example.sharedpreferences;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonSave);
        final TextView backup = findViewById(R.id.backup);
        final SharedPreferences sharePref = MainActivity.this.getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharePref.edit();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            EditText rememberme = findViewById(R.id.rememberMe);
            String remember = rememberme.getText().toString();
            editor.putString("dataToRecup", remember);
            editor.apply();
            backup.setText(sharePref.getString("dataToRecup", "Empty"));
            }
        });
        backup.setText(sharePref.getString("dataToRecup", "Empty"));
    }
}