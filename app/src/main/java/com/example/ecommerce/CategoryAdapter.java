package com.example.ecommerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {


    private ArrayList<Category> categories;
    private Context context;
    private LayoutInflater layoutInflater;


    public CategoryAdapter(Context context, ArrayList<Category> categories){
        this.context = context;
        this.categories = categories;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View customView = layoutInflater.inflate(R.layout.category_page_list_view,null);
        ImageView photo = (ImageView) customView.findViewById(R.id.categoryListImage);
        TextView categoryName = (TextView) customView.findViewById(R.id.categoryNameTxt);
        TextView categoryDetail = (TextView) customView.findViewById(R.id.categoryDetailTxt);

        photo.setImageBitmap(categories.get(position).getCategoryImage());
        categoryName.setText(categories.get(position).getCategoryName());
        categoryDetail.setText(categories.get(position).getCategorySubtitle());

        return customView;
    }
}
