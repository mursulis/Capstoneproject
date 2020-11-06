package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class laguna extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laguna);

        recyclerView = findViewById(R.id.recyclerview);

        Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city};
        String[] treeName = {"Nobel Fir", "Douglas Fir", "Frazier Fir", "Nordmann Fir"};

        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(laguna.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(laguna.this, mainModels);
        recyclerView.setAdapter(mainAdapter);

    }


    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(Uri.parse("https://www.google.com/maps/place/Pumpkin+City/@33.6102595,-117.7061073,17z/data=!3m1!4b1!4m5!3m4!1s0x80dce8ef38a6f29d:0x70e5d4da5751a0de!8m2!3d33.6102595!4d-117.7039186"));

        startActivity(i);

    }

}