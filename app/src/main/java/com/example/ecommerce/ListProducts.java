package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ListProducts extends AppCompatActivity {
    ArrayList<ModelPost> hue;
    TabLayout tabLayout;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_products);


/*        Bitmap directory = BitmapFactory.decodeResource(getResources(), R.drawable.iphone12);
        Bitmap iphone7 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone7);
        Bitmap iphone8 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone7);
        Bitmap iphone10 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone10);
        Bitmap iphone11 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone11);
        Bitmap iphone11max = BitmapFactory.decodeResource(getResources(), R.drawable.iphone11max);
        Bitmap iphone12 = BitmapFactory.decodeResource(getResources(), R.drawable.iphone12);
        Bitmap iphone12max = BitmapFactory.decodeResource(getResources(), R.drawable.iphone12max);

        ArrayList<Bitmap> phoneImages = new ArrayList<>();
        phoneImages.add(iphone7);
        phoneImages.add(iphone10);
        phoneImages.add(iphone11);
        phoneImages.add(iphone11max);
        phoneImages.add(iphone12);
        phoneImages.add(iphone12max);
        phoneImages.add(iphone8);
        phoneImages.add(iphone7);
*/




        listView = findViewById(R.id.productListView);
        hue = new ArrayList<>();
        Intent getExtra = getIntent();
        Bundle bundle = getExtra.getExtras();
        String extra = bundle.getString("brand");
        System.out.println(extra+"Passing to List Products");



        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference chatSpaceRef = rootRef.child("Main").child("Elektrik").child("Akıllı Telefon").child(extra);

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ModelPost> hueX = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ModelPost m1 = ds.getValue(ModelPost.class);
                    hueX.add(m1);
                }


                ProductAdapter productAdapter = new ProductAdapter(ListProducts.this, hueX);
                listView.setAdapter(productAdapter);
                productAdapter.notifyDataSetChanged();




                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            ModelPost pass = hueX.get(position);
                            ArrayList<ModelPost> ne = new ArrayList<>();
                            ne.add(pass);
                            Intent intent = new Intent(ListProducts.this, DetailActivity.class);
                            intent.putExtra("sampleObject", pass);
                            startActivity(intent);


                    }
                });
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        chatSpaceRef.addListenerForSingleValueEvent(eventListener);








    }


    //READ ALL CHILD NODES FROM DB WITH THEIR INFORMATION AND SAVE IT TO AN ARRAYLIST

}