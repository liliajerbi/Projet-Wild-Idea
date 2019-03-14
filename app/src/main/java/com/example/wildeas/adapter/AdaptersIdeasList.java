package com.example.wildeas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.wildeas.R;
import com.example.wildeas.models.Adders;

import java.util.List;

public class AdaptersIdeasList extends BaseAdapter {

    private Context context;
    private List<Adders> addedList ;
    private LayoutInflater inflater;

    public AdaptersIdeasList(Context context, List<Adders> addedList ) {
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
        String itemTitle= currentItem.getTitle();
        String itemDate= currentItem.getDate();
        String itemDescription= currentItem.getDescription();



        //recuperer item
        TextView itemTitleView = convertView.findViewById(R.id.item_title);
        itemTitleView.setText(itemTitle);

        TextView itemDateView = convertView.findViewById(R.id.item_date);
        itemDateView.setText(itemDate);

        TextView itemDescriptionView = convertView.findViewById(R.id.item_description);
        itemDescriptionView.setText(itemDescription);


        return convertView;
    }
}
