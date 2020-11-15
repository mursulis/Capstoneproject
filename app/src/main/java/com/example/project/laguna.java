package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class laguna extends AppCompatActivity implements MainAdapter.OnTreeListener {
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city};
    Integer[] treeLargeImage = {R.drawable.noble,R.drawable.douglas, R.drawable.fraser, R.drawable.nordmann};
    String[] treeName = {"Nobel Fir", "Douglas Fir", "Fraser Fir", "Nordmann Fir"};
    String[] treeDesc = new String[treeName.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laguna);

        recyclerView = findViewById(R.id.recyclerview);

        treeDesc[0] = "Nobles are fast becoming the most desired tree for the holidays. The branches of " +
                "the Noble fir are evenly spaced and have bluish-green needles. Known for its " +
                "beauty, the Noble Fir has a long sustainability and sturdy branches which make it " +
                "an excellent tree for displaying heavy ornaments.";
        treeDesc[1] = "The Douglas Fir has been the major Christmas tree variety used in the Pacific " +
                "Northwest since the 1920’s. Douglas Firs are more dense than their counterpart " +
                "firs. Their needles are dark green in color, are soft to the touch, radiate in all " +
                "directions from the branch and have a sweet fragrance when crushed.";
        treeDesc[2] = "The Fraser fir branches turn slightly upward. They have good form and needle-" +
                "retention. They are dark blue green in color. They have a pleasant scent.";
        treeDesc[3] = "Native to the Caucasus Mountains in the former Soviet Republic of Georgia they " +
                "are the latest trend in exotic trees.";

        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(laguna.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(laguna.this, mainModels, this);
        recyclerView.setAdapter(mainAdapter);
    }


    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com/maps/place/Pumpkin+City/@33.6102595,-117.7061073,17z/data=!3m1!4b1!4m5!3m4!1s0x80dce8ef38a6f29d:0x70e5d4da5751a0de!8m2!3d33.6102595!4d-117.7039186"));
        startActivity(i);
    }

    @Override
    public void onTreeClick(int position) {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                laguna.this, R.style.BottomSheetDialogTheme
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