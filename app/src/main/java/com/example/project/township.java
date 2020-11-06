package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class township extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList <MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_township);

        recyclerView = findViewById(R.id.recyclerview);

        Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city};
        String[] treeName = {"Nobel Fir", "Douglas Fir", "Frazier Fir", "Nordmann Fir"};

        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(township.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(township.this, mainModels);
        recyclerView.setAdapter(mainAdapter);

    }

    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(Uri.parse("https://www.google.com/maps/place/English+Gardens/@42.5445213,-83.364295,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ba461ad76b3b:0x2b5d1fe6ccc5c657!8m2!3d42.5445213!4d-83.3621063"));

        startActivity(i);

    }


}