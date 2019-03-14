package com.example.wildeas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wildeas.adapter.AdaptersIdeasList;
import com.example.wildeas.models.Adders;

import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.ArrayList;

import java.util.List;

public class Home extends AppCompatActivity {

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
                Intent gotoAboutUs = new Intent(Home.this, AboutUs.class);
                startActivity(gotoAboutUs);
                return true;
            case R.id.action_deco:
                Intent gotoMain = new Intent(Home.this, MainActivity.class);
                startActivity(gotoMain);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView texthello = findViewById(R.id.textHello);
        Intent intent = getIntent();
        String hello = intent.getStringExtra("textName");
        texthello.setText("Welcome " + hello + "!");

        Spinner spinnercategories = findViewById(R.id.spinner);
        List categories = new ArrayList();
        categories.add("Films");
        categories.add("Series");
        categories.add("Anime");

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item,
                categories
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercategories.setAdapter(adapter);




        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoaddPage = new Intent(Home.this, add_page.class);
                startActivity(gotoaddPage);
            }
        });

        Intent added = getIntent();
        String myTitle = added.getStringExtra("titleText");
        String myDate = added.getStringExtra("dateText");
        String myDescripiton = added.getStringExtra("descripitonText");



        //Liste
        List<Adders> filmList = new ArrayList<>();

        filmList.add(new Adders("Du Miel plein la tête","Nick et Sarah élèvent leur fille de 10 ans, Tilda, dans les environs de Londres. Malgré leurs problèmes de couple, Amadeus  père de Nick, s'installe chez eux à contrecœur. En effet, atteint de la maladie d'Alzheimer et veuf depuis peu de temps, il est désormais incapable de vivre seul. ", " 20-09-2019 "));
        filmList.add(new Adders("Harry Potter", "the best one", "20-1-2018"));
        filmList.add(new Adders("Harry Potter", "the best one", "20-1-2018"));
        filmList.add(new Adders(myTitle, myDescripiton, myDate));

        /* List<Adders> serieList = new ArrayList<>();

        filmList.add(new Adders("Harry Potter", "the best a"));
        filmList.add(new Adders("Harry Potter", "the best one"));
        filmList.add(new Adders("Harry Potter", "the best one"));
        filmList.add(new Adders(myTitle, myDescripiton,myDate)); */

        /*List<Adders> animeList = new ArrayList<>();

        filmList.add(new Adders("Harry Potter","the best", "20-1-2018"));
        filmList.add(new Adders("Harry Potter", "the best one", "20-1-2018"));
        filmList.add(new Adders("Harry Potter", "the best one", "20-1-2018"));
        filmList.add(new Adders(myTitle,myDescripiton, myDate)); */


        //ListView
        ListView ideasListView = findViewById(R.id.idea_view_list);
        ideasListView.setAdapter(new AdaptersIdeasList(this, filmList));

       /* ListView ideasListView = findViewById(R.id.idea_view_list);
        ideasListView.setAdapter(new AdaptersIdeasList(this, serieList)); */

       /* ListView ideasListView = findViewById(R.id.idea_view_list);
        ideasListView.setAdapter(new AdaptersIdeasList(this, animeList)); */


    }
}
