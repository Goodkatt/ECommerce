package com.example.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TitleAdapter extends BaseAdapter {


    private ArrayList<Title> titles;
    private Context context;
    private LayoutInflater layoutInflater;


    public TitleAdapter(Context context, ArrayList<Title> titles) {
        this.context = context;
        this.titles = titles;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return titles.size();
    }

    @Override
    public Object getItem(int position) {
        return titles.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = layoutInflater.inflate(R.layout.titles_view,null);
        ImageView photo = (ImageView) customView.findViewById(R.id.titleImage);
        TextView titleName = (TextView) customView.findViewById(R.id.titleText);

        photo.setImageBitmap(titles.get(position).getDirection());
        titleName.setText(titles.get(position).getTitle());

        return customView;
    }
}
