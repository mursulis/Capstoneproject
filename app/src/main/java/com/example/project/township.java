package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class township extends AppCompatActivity implements MainAdapter.OnTreeListener {
    ImageButton offerbtn;
    RecyclerView recyclerView;
    ArrayList <MainModel> mainModels;
    MainAdapter mainAdapter;

    Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city};
    String[] treeName = {"Noble Fir", "Douglas Fir", "Fraser Fir", "Nordmann Fir"};
    String[] treeDesc = new String[treeName.length];
    Integer[] treeLargeImage = {R.drawable.noble,R.drawable.douglas, R.drawable.fraser, R.drawable.nordmann};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_township);

        try {
            this.getSupportActionBar().hide();
        }

        catch (NullPointerException e){}

        Fragment fragment = new MapFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();


        offerbtn = (ImageButton) findViewById(R.id.offerbtn);
        offerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openofferpopupcard();
            }
        });



        recyclerView = findViewById(R.id.recyclerview);

        treeDesc[0] = "Very Limited availability. Fragrant short green needles. Very full branching. " +
                "Excellent needle retention.";
        treeDesc[1] = "Beautiful green soft needles. Sizes from 5 to 9 ft tall.";
        treeDesc[2] = "Our most popular variety. Great needle retention. A perfect selection for heavy " +
                "ornaments. Unique two-tone, bluish color. Sizes from 6 to 16 ft tall.";
        treeDesc[3] = "N/A";

        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(township.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(township.this, mainModels, this);
        recyclerView.setAdapter(mainAdapter);

    }

    private void openofferpopupcard() {

        Intent offerpopupcard = new Intent(township.this, offerpopupcard.class);
        startActivity(offerpopupcard);

    }

    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com/maps/place/English+Gardens/@42.5445213,-83.364295,17z/data=!3m1!4b1!4m5!3m4!1s0x8824ba461ad76b3b:0x2b5d1fe6ccc5c657!8m2!3d42.5445213!4d-83.3621063"));
        startActivity(i);
    }


    @Override
    public void onTreeClick(int position) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                township.this, R.style.BottomSheetDialogTheme
        );
        View bottomSheetView = LayoutInflater.from(getApplicationContext())
                .inflate(
                        R.layout.description_bottom_sheet,
                        (LinearLayout)findViewById(R.id.bottomSheetContainer)
                );

        TextView titleTextView = (TextView) bottomSheetView.findViewById(R.id.TreeDescTitle);
        titleTextView.setText(treeName[position]);

        TextView descTextView = (TextView) bottomSheetView.findViewById(R.id.TreeDesc);
        descTextView.setText(treeDesc[position]);
        descTextView.setMovementMethod(new ScrollingMovementMethod());

        ImageView descImageView = (ImageView) bottomSheetView.findViewById(R.id.LargeTreeImage);
        descImageView.setImageResource(treeLargeImage[position]);

        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }
}