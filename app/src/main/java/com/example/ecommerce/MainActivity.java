package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Bitmap my_image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.categoryListView);

        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        Bitmap directory = BitmapFactory.decodeResource(getResources(), R.drawable.iphone12);


        //Inıtial Products
/*        ModelPost m1 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone7", "4.000TL", "Latest iphone", "20/02/2021");
        ModelPost m2 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone8", "5.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m3 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone9", "6.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m4 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone10", "7.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m5 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone11", "8.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m6 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone11max", "9.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m7 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone12", "10.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m8 = new ModelPost("Elektronik", "Akıllı Telefon", "Apple", "iphone12max", "11.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m9 = new ModelPost("Elektronik", "Akıllı Telefon", "Samsung", "Samsung1", "11.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m10 = new ModelPost("Elektronik", "Akıllı Telefon", "Samsung", "Samsung2", "11.000 TL", "Latest iphone", "20/02/2021");
        ModelPost m11 = new ModelPost("Elektronik", "Akıllı Telefon", "Samsung", "Samsung3", "11.000 TL", "Latest iphone", "20/02/2021");

        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iPhone7").setValue(m1);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone8").setValue(m2);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone9").setValue(m3);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone10").setValue(m4);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone11").setValue(m5);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone11max").setValue(m6);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone12").setValue(m7);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Apple").child("iphone12max").setValue(m8);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Samsung").child("samsung1").setValue(m9);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Samsung").child("samsung2").setValue(m10);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Samsung").child("samsung3").setValue(m11);


        ModelPost m1 = new ModelPost("Elektronik", "Akıllı Telefon", "Huawei", "Huawei1", "4.000TL", "First Huawei", "20/02/2021");
        ModelPost m2 = new ModelPost("Elektronik", "Akıllı Telefon", "Huawei", "Huawei2", "5.000TL", "Second Huawei", "20/02/2021");
        ModelPost m3 = new ModelPost("Elektronik", "Akıllı Telefon", "Huawei", "Huawei3", "6.000TL", "Third Huawei", "20/02/2021");
        ModelPost m4 = new ModelPost("Elektronik", "Akıllı Telefon", "Huawei", "Huawei4", "7.000TL", "Fourth Huawei", "20/02/2021");
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Huawei").child("Huawei1").setValue(m1);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Huawei").child("Huawei2").setValue(m2);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Huawei").child("Huawei3").setValue(m3);
        mDatabase.child("Main").child("Elektrik").child("Akıllı Telefon").child("Huawei").child("Huawei4").setValue(m4);
*/

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();
        StorageReference pathReference = storageRef.child("images-apple-smart-phones/apple.png");

        final long ONE_MEGABYTE = 1024 * 1024;
        pathReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                // Data for "images/island.jpg" is returns, use this as needed
                my_image = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle any errors
            }
        });


//readFromDB();















        ArrayList<Category> categoryList = new ArrayList<>();
        Bitmap supermarket = BitmapFactory.decodeResource(getResources(), R.drawable.cart);
        Bitmap fashion = BitmapFactory.decodeResource(getResources(), R.drawable.dress);
        Bitmap sports = BitmapFactory.decodeResource(getResources(), R.drawable.dumbbell);
        Bitmap electronics = BitmapFactory.decodeResource(getResources(), R.drawable.electronics);

        Category c1 = new Category("Alışveriş", "Alışveriş ve süpermarket ihtiyaçlarına dair her şey.", supermarket);
        Category c2 = new Category("Elektronik", "Elektronik ve Beyaz eşyaya dair her şey.", electronics);
        Category c3 = new Category("Moda", "Kıayfet, Kozmetik modaya dair her şey.", fashion);
        Category c4 = new Category("Spor", "Spor ürünleri, besinleri ve aletleri", sports);

        categoryList.add(c1);
        categoryList.add(c2);
        categoryList.add(c3);
        categoryList.add(c4);

        CategoryAdapter categoryAdapter = new CategoryAdapter(this,categoryList);
        listView.setAdapter(categoryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, categoryList.get(position).getCategoryName() + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, TitleActivity.class);

                if(position == 0){
                    String pass = categoryList.get(position).getCategoryName();
                    intent.putExtra("category", pass);
                }
                else if(position == 1){
                    String pass = categoryList.get(position).getCategoryName();
                    intent.putExtra("category", pass);
                }
                else if(position == 2){
                    String pass = categoryList.get(position).getCategoryName();
                    intent.putExtra("category", pass);
                }
                else if(position == 3){
                    String pass = categoryList.get(position).getCategoryName();
                    intent.putExtra("category", pass);
                }
                startActivity(intent);
            }
        });

    }


    public void readFromDB(){

        ModelPost m1 = new ModelPost();
        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference chatSpaceRef = rootRef.child("Main").child("Elektrik").child("Akıllı Telefon").child("Samsung");
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    //String key = ds.getKey();
                    //String msg = ds.child("price").getValue(String.class);

                    //String keyy = ds.getKey();
                    //String value =ds.getValue().toString();
                    ModelPost m1 = ds.getValue(ModelPost.class);
                    //System.out.println(keyy+value+"aqqq");

                    System.out.println(m1.getProductName()+"xD");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        chatSpaceRef.addListenerForSingleValueEvent(eventListener);
    }
}