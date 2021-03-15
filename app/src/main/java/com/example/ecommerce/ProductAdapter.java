package com.example.ecommerce;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    private ArrayList<ModelPost> model;
    private Context context;
    private LayoutInflater layoutInflater;
    private Bitmap bm;

    public ProductAdapter(Context context, ArrayList<ModelPost> model) {
        this.model = model;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return model.size();
    }

    @Override
    public Object getItem(int position) {
        return model.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View customView = layoutInflater.inflate(R.layout.product_list_view, null);
        ImageView photo = (ImageView) customView.findViewById(R.id.productImg);
        TextView categoryName = (TextView) customView.findViewById(R.id.productName);
        TextView categoryDetail = (TextView) customView.findViewById(R.id.productPrice);

            photo.setImageAlpha(R.drawable.phone2);
            //photo.setImageBitmap(model.get(position).getPhoto());
            categoryName.setText(model.get(position).getProductName());
            categoryDetail.setText(model.get(position).getPrice());


        return customView;
    }

    public Bitmap strToBitmap(String path){
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference photoReference= storageReference.child(path);

        final long ONE_MEGABYTE = 1024 * 1024;
        photoReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                bm = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
            }
        });

        return bm;
    }
}
