package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import com.google.android.gms.maps.MapView;

import java.util.ArrayList;

public class petaluma extends AppCompatActivity implements MainAdapter.OnTreeListener{

    ImageButton offerbtn;
    RecyclerView recyclerView;
    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    Integer[] treeLogo = {R.drawable.city,R.drawable.city, R.drawable.city, R.drawable.city, R.drawable.city, R.drawable.city};
    Integer[] treeLargeImage = {R.drawable.silvertip, R.drawable.douglas, R.drawable.nordmann, R.drawable.noble,
                                R.drawable.grand, R.drawable.fraser};
    String[] treeName = {"Silvertip Fir", "Douglas Fir", "Nordmann Fir", "Noble Fir", "Grand Fir", "Fraser Fir"};
    String[] treeDesc = new String[treeName.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petaluma);

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

        treeDesc[0] = "The Silvertip Fir is the most sought-after Christmas tree. Their naturally beautiful " +
                "silver tips and mountain fragrance is an inviting experience. Shaped with sturdy, " +
                "layered branches for many ornaments. The needles have a green/blueish tint " +
                "with silver tips.";
        treeDesc[1] = "The Douglas Fir is actually not a true fir tree and is sometimes referred to as " +
                "Douglas Tree or Oregon pine. Because this tree responded so well to shearing " +
                "and a farm environment it became a very popular Christmas tree since the " +
                "1920’s. The Douglas is frequently referred to as the “old fashion tree”. The " +
                "needles are a feathery dark green, soft to the touch and have a sweet fresh " +
                "fragrance. The tree is dense with a conical shape.";
        treeDesc[2] = "The Nordmann Fir is the most popular tree in Europe and is commonly grown in " +
                "Germany and Norway. The Nordmann is gaining popularity in the U.S. because of " +
                "its outstanding symmetrical form and relatively open branch structure with " +
                "distinct whorls. The Nordmann is sheared and cultured in the U.S. which changes " +
                "the natural characteristics of the tree. The needles are short, dark green that lay " +
                "flat on the branch with a deep green silvery underside that is soft to the touch. It " +
                "is considered a tree with long lasting qualities with minimal needle drop; " +
                "although it does need to be displayed in water.";
        treeDesc[3] = "The Noble Fir is one of the most important conifer species used for production of " +
                "high-quality Christmas trees in the Pacific Northwest. The Noble fir is native to " +
                "the Pacific Northwest where it is grown extensively in the higher elevations of " +
                "Oregon and Washington states. The Noble Fir does very well in extreme " +
                "conditions in both warm and cold environments and has a beautiful spruce like " +
                "appearance with evenly spaced strong branches.";
        treeDesc[4] = "The Grand Fir is distinguished from other Pacific Northwest firs by its sprays of " +
                "lustrous needles that are in two distinct rows. The needles are 1 to 1 ½ inches " +
                "long with glossy dark green top and white on the underside. The symmetry, dark " +
                "glossy color, and strong citrus fragrance make the Grand Fir one of the preferred " +
                "species of Christmas Trees in the Northwest.";
        treeDesc[5] = "The Fraser Fir is a native of the Blue Ridge Mountains in North Carolina. There " +
                "are some trees in production on the west coast where it is becoming popular " +
                "because of its narrow pyramid shape, strong slightly upturned branches which " +
                "gives this tree a compact appearance. It has a wonderful citrus odor and is said " +
                "to have the best needle retention of all the trees. The Fraser Fir has been used " +
                "more times in the Blue Room at the White House than any other tree species.";


        mainModels = new ArrayList<>();
        for (int i=0;i<treeLogo.length;i++){
            MainModel model = new MainModel(treeLogo[i], treeName[i]);
            mainModels.add(model);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(petaluma.this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(petaluma.this, mainModels, this);
        recyclerView.setAdapter(mainAdapter);

    }

    private void openofferpopupcard() {

        Intent offerpopupcard = new Intent(petaluma.this, offerpopupcard.class);
        startActivity(offerpopupcard);

    }

    public void click (View v){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com/maps/place/100+Fairgrounds+Dr,+Petaluma,+CA+94952/@38.2423203,-122.6339072,17z/data=!3m1!4b1!4m5!3m4!1s0x8085b4013134c291:0x23b42998b38bcae9!8m2!3d38.2423203!4d-122.6317185"));
        startActivity(i);
    }


    @Override
    public void onTreeClick(int position) {

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                petaluma.this, R.style.BottomSheetDialogTheme
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