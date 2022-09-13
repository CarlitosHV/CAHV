package com.example.cahv;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Ubicacion_Real extends Fragment implements OnMapReadyCallback {

    private GoogleMap map;
    Button btnSatelite, btnHibrido, btnUbi;
    double latitude;
    double longitude;

    public static Ubicacion_Real newInstance() {
        return new Ubicacion_Real();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_ubicacion__real, container, false);

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.map, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);


        btnSatelite = root.findViewById(R.id.btnGSatelite);
        btnSatelite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            }
        });


        btnHibrido = root.findViewById(R.id.btnGHibrido);
        btnHibrido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        });


        return root;
    }



    public void onMapReady(@NonNull GoogleMap googleMap) {
        map = googleMap;
        LatLng mex = new LatLng(latitude, longitude);
        map.addMarker(new MarkerOptions()
                .position(mex)
                .title("Mi ubicación"));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        map.moveCamera(CameraUpdateFactory.newLatLng(mex));
    }

}