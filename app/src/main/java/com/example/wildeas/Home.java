package com.example.wildeas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.wildeas.adapter.AdaptersIdeasList;
import com.example.wildeas.models.Adders;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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
