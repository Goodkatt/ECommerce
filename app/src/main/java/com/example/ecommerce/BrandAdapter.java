package com.example.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BrandAdapter extends BaseAdapter {
    private ArrayList<Brand> brands;
    private Context context;
    private LayoutInflater layoutInflater;

    public BrandAdapter(Context context, ArrayList<Brand> brands){
        this.context = context;
        this.brands = brands;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return brands.size();
    }

    @Override
    public Object getItem(int position) {
        return brands.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = layoutInflater.inflate(R.layout.brand_page_list_view,null);
        ImageView photo = (ImageView) customView.findViewById(R.id.brandListImage);
        TextView titleName = (TextView) customView.findViewById(R.id.brandNameTxt);

        photo.setImageBitmap(brands.get(position).getBrandPic());
        titleName.setText(brands.get(position).getBrand());

        return customView;
    }
}
