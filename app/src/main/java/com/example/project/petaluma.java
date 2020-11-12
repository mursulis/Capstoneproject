package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;

public class petaluma extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petaluma);

        recyclerView = findViewById(R.id.recyclerview);

        Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city, R.drawable.city, R.drawable.city};
        String[] treeName = {"Silvertip Fir", "Douglas Fir", "Nordmann Fir", "Noble Fir", "Grand Fir", "Fraser Fir"};
        String[] treeDesc = {"Silvertip desc", "Douglas desc", "Nordmann desc", "Noble desc", "Grand desc", "Fraser desc"};



        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(petaluma.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(petaluma.this, mainModels);
        recyclerView.setAdapter(mainAdapter);


        Button buttonDesc = findViewById(R.id.buttonDesc);
        buttonDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                        petaluma.this, R.style.BottomSheetDialogTheme
                );
                View bottomSheetView = LayoutInflater.from(getApplicationContext())
                        .inflate(
                                R.layout.description_bottom_sheet,
                                (LinearLayout)findViewById(R.id.bottomSheetContainer)
                        );
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
            }
        });

    }

    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);

        i.setData(Uri.parse("https://www.google.com/maps/place/100+Fairgrounds+Dr,+Petaluma,+CA+94952/@38.2423203,-122.6339072,17z/data=!3m1!4b1!4m5!3m4!1s0x8085b4013134c291:0x23b42998b38bcae9!8m2!3d38.2423203!4d-122.6317185"));

        startActivity(i);

    }



}