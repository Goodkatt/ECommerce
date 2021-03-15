package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class DetailActivity extends AppCompatActivity {
    ArrayList<String> finalA = new ArrayList<>();
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView iv = findViewById(R.id.detailImage);

        listView = findViewById(R.id.listviewDetail);
        Intent getExtra = getIntent();
        ModelSort m1 = new ModelSort();
        try {
            m1.stringToDate("20/02/1993");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Intent i = getIntent();
        ModelPost dene = (ModelPost) i.getSerializableExtra("sampleObject");
        ArrayList<ModelPost> p1 = new ArrayList<>();
        p1.add(dene);
        System.out.println(dene.getBrand());
        DetailAdapter productAdapter = new DetailAdapter(DetailActivity.this, p1);
        listView.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();

        sortByPrice();


    }




    public void sortByPrice(){



        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference chatSpaceRef = rootRef.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple");

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<ModelPost> hueX = new ArrayList<>();
                ArrayList<ModelSort> modelSortArrayList = new ArrayList<>();
                ArrayList<ModelSort> sortedArray = new ArrayList<>();
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    ModelPost m1 = ds.getValue(ModelPost.class);
                    hueX.add(m1);

                }

                String afterFirstSplit = "";
                String afterSecondSplit = "";
                for(int i = 0; i < hueX.size(); i++){
                    String [] firstSplit = hueX.get(i).getPrice().split("T");
                    afterFirstSplit = firstSplit[0];
                    String [] afterSeondSplitArray = afterFirstSplit.split("\\.");
                    afterSecondSplit = afterSeondSplitArray[0] + afterSeondSplitArray[1];
                    finalA.add(afterSecondSplit);
                }
                System.out.println(finalA.get(0)+finalA.get(1)+finalA.get(2));
                for (int i = 0; i < hueX.size(); i++){
                    ModelSort modelSort = new ModelSort();
                    try {
                        modelSortArrayList.add(modelSort.modelPostToModelSort(hueX.get(i)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                Collections.sort(modelSortArrayList, new ComparePrice());

                for (ModelSort lteam : modelSortArrayList) {
                    sortedArray.add(lteam);
                    System.out.println(lteam.getPrice() + "Azalan fiyata göre");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }

        };

        chatSpaceRef.addListenerForSingleValueEvent(eventListener);

    }
}