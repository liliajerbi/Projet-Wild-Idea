package com.example.wildeas;

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

        //Liste
        List<Adders> addedList = new ArrayList<>();
        addedList.add(new Adders("Joséphine", "pro du about us"));
        addedList.add(new Adders("Joséphine", "pro du about us"));
        addedList.add(new Adders("Joséphine", "pro du about us"));
        addedList.add(new Adders("Joséphine", "pro du about us"));
        addedList.add(new Adders("Joséphine", "pro du about us"));
        addedList.add(new Adders("Joséphine", "pro du about us"));


        //ListView
        ListView ideasListView = findViewById(R.id.idea_view_list);
        ideasListView.setAdapter(new AdaptersIdeasList(this, addedList));

    }
}
