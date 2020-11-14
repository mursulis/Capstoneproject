
package com.example.project;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    private final LatLng pumpkin = new LatLng(33.610362, -117.703894);
    private final LatLng english = new LatLng(42.544390, -83.362303);
    private final LatLng pronzini = new LatLng(38.242468, -122.631735);

    private Marker markerpumpkin;
    private Marker markerenglish;
    private Marker markerpronzini;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, container, false);
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                markerpumpkin = googleMap.addMarker(new MarkerOptions()
                        .position(pumpkin)
                        .title("Pumpkin City"));

                markerenglish = googleMap.addMarker(new MarkerOptions()
                        .position(english)
                        .title("English Gardens"));

                markerpronzini = googleMap.addMarker(new MarkerOptions()
                        .position(pronzini)
                        .title("Pronzini Christmas Trees"));


            }

        });
        return view;

    }


}
