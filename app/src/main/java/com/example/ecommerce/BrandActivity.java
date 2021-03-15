package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class BrandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        ListView brandListView = findViewById(R.id.brandListView);

        Bitmap directory = BitmapFactory.decodeResource(getResources(), R.drawable.direction);
        Bitmap apple = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
        Bitmap huawei = BitmapFactory.decodeResource(getResources(), R.drawable.huawei);
        Bitmap samsung = BitmapFactory.decodeResource(getResources(), R.drawable.samsung);


        ArrayList<Brand> brandsSmartPhones = new ArrayList<>();
        brandsSmartPhones.add(new Brand("Apple", apple, directory));
        brandsSmartPhones.add(new Brand("Huawei", huawei, directory));
        brandsSmartPhones.add(new Brand("Samsung", samsung, directory));

        BrandAdapter categoryAdapter = new BrandAdapter(this,brandsSmartPhones);
        brandListView.setAdapter(categoryAdapter);

        Intent getExtra = getIntent();
        Bundle bundle = getExtra.getExtras();
        String extra = bundle.getString("title");
        System.out.println(extra+"Passing to List Products");

        Intent intent = new Intent(BrandActivity.this, ListProducts.class);

        brandListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String pass = brandsSmartPhones.get(position).getBrand();
                    intent.putExtra("brand", pass);
                    startActivity(intent);
            }
        });

    }
}