package com.example.wildeas.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.wildeas.R;
import com.example.wildeas.Todo;
import com.example.wildeas.models.Adders;

import java.util.List;

public class AdaptersIdeasList extends ArrayAdapter<Adders> {

    private Context context;
    private List<Adders> addedList ;
    private LayoutInflater inflater;

    public AdaptersIdeasList(Context context, List<Adders> addedList ) {
        super(context,0, addedList);
        this.context= context;
        this.addedList=addedList;
        this.inflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return addedList.size();
    }

    @Override
    public Adders getItem(int position) {
        return addedList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = (View) inflater.inflate(R.layout.adapter_item , null);

        //recuperation elements
        Adders currentItem = getItem(position) ;
        final String itemTitle= currentItem.getTitle();
        final String itemDate= currentItem.getDate();
        final String itemDescription= currentItem.getDescription();

        //recuperer item
        final TextView itemTitleView = convertView.findViewById(R.id.item_title);
        itemTitleView.setText(itemTitle);

        final TextView itemDateView = convertView.findViewById(R.id.item_date);
        itemDateView.setText(itemDate);

        final TextView itemDescriptionView = convertView.findViewById(R.id.item_description);
        itemDescriptionView.setText(itemDescription);

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToToDo = new Intent(getContext(),Todo.class);
                goToToDo.putExtra("title", itemTitle);
                goToToDo.putExtra("date", itemDate);
                goToToDo.putExtra("description", itemDescription);
                getContext().startActivity(goToToDo);
            }
        });

        return convertView;
    }
}
