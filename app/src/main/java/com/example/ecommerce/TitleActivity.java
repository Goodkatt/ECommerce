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

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        Bitmap directory = BitmapFactory.decodeResource(getResources(), R.drawable.direction);
        ArrayList<Title> supermarketList = defineSupermarketTitles(directory);
        ArrayList<Title> electronicsList = defineElectronicsTitles(directory);
        ArrayList<Title> fashionList = defineFashionTitles(directory);
        ArrayList<Title> sportsList = defineSportsTitles(directory);
        ListView titleListView = findViewById(R.id.titleListView);
        int flag = 0;
        Intent intent = new Intent(TitleActivity.this, BrandActivity.class);


        Intent getExtra = getIntent();
        Bundle bundle = getExtra.getExtras();
        String extra = bundle.getString("category");

        if(extra.equals("Alışveriş")){
            TitleAdapter categoryAdapter = new TitleAdapter(this,supermarketList);
            titleListView.setAdapter(categoryAdapter);
            titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0){
                        String pass = supermarketList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 1){
                        String pass = supermarketList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 2){
                        String pass = supermarketList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                }
            });

        }
        else if(extra.equals("Elektronik")){
            TitleAdapter categoryAdapter = new TitleAdapter(this,electronicsList);
            titleListView.setAdapter(categoryAdapter);
            titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0){
                        String pass = electronicsList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 1){
                        String pass = electronicsList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 2){
                        String pass = electronicsList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                }
            });
        }
        else if(extra.equals("Moda")){
            TitleAdapter categoryAdapter = new TitleAdapter(this,fashionList);
            titleListView.setAdapter(categoryAdapter);
            titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0){
                        String pass = fashionList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 1){
                        String pass = fashionList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 2){
                        String pass = fashionList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                }
            });
        }
        else if(extra.equals("Spor")){
            TitleAdapter categoryAdapter = new TitleAdapter(this,sportsList);
            titleListView.setAdapter(categoryAdapter);
            titleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0){
                        String pass = sportsList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                    else if(position == 1){
                        String pass = sportsList.get(position).getTitle();
                        intent.putExtra("title", pass);
                        startActivity(intent);
                    }
                }
            });
        }



    }




    public ArrayList<Title> defineSupermarketTitles(Bitmap directory){
        ArrayList<Title> supermarketList = new ArrayList<>();
        supermarketList.add(new Title("İçecek", directory));
        supermarketList.add(new Title("Yiyecek", directory));
        supermarketList.add(new Title("Temizlik", directory));

        return supermarketList;

    }
    public ArrayList<Title> defineElectronicsTitles(Bitmap directory){
        ArrayList<Title> electronicsList = new ArrayList<>();
        electronicsList.add(new Title("Akıllı Telefon", directory));
        electronicsList.add(new Title("Bilgisayar", directory));
        electronicsList.add(new Title("Televizyon", directory));
        return electronicsList;
    }
    public ArrayList<Title> defineFashionTitles(Bitmap directory){
        ArrayList<Title> fashionList = new ArrayList<>();
        fashionList.add(new Title("Erkek Giyim", directory));
        fashionList.add(new Title("Kadın Giyim", directory));
        fashionList.add(new Title("Çocuk Giyim", directory));
        return fashionList;
    }
    public ArrayList<Title> defineSportsTitles(Bitmap directory){
        ArrayList<Title> sportsList = new ArrayList<>();
        sportsList.add(new Title("Spor Ayakkabı", directory));
        sportsList.add(new Title("Taraftar Ürünleri", directory));
        return sportsList;
    }
}