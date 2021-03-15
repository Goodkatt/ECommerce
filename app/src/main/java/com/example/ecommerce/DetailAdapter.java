package com.example.ecommerce;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailAdapter extends BaseAdapter {
    private ArrayList<ModelPost> models;
    private Context context;
    private LayoutInflater layoutInflater;

    public DetailAdapter(Context context, ArrayList<ModelPost> models){
        this.context = context;
        this.models = models;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }




    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int position) {
        return models.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = layoutInflater.inflate(R.layout.detail_view,null);
        ImageView detailImage = (ImageView) customView.findViewById(R.id.detailImage);

        TextView priceText = (TextView) customView.findViewById(R.id.priceText);
        TextView brandText = (TextView) customView.findViewById(R.id.brandText);
        TextView modelText = (TextView) customView.findViewById(R.id.modelText);
        TextView detailText = (TextView) customView.findViewById(R.id.detailText);
        TextView dateText = (TextView) customView.findViewById(R.id.dateText);


        priceText.setText(models.get(position).getPrice());
        brandText.setText(models.get(position).getBrand());
        modelText.setText(models.get(position).getProductName());
        detailText.setText(models.get(position).getDetail());
        dateText.setText(models.get(position).getAddDate());

        return customView;
    }
}
