package com.allin.sdainfo.mymapas;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        //setar tipo mapa
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        LatLng ruaEli = new LatLng(-23.52405, -46.59152);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {

                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "lat = " + latitude + "\n long = " +longitude, Toast.LENGTH_SHORT).show();

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Marcacdor rua eli")
                        .snippet("Descrição")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_loja)
                        )
                );
            }
        });

        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Double latitude = latLng.latitude;
                Double longitude = latLng.longitude;

                Toast.makeText(MapsActivity.this, "lat = " + latitude + "\n long = " +longitude, Toast.LENGTH_SHORT).show();

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Marcacdor rua eli")
                        .snippet("Descrição")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_carro_roxo_48px)
                        )
                );
            }
        });

        /*
        mMap.addMarker(new MarkerOptions()
                      .position(ruaEli)
                      .title("Marcacdor rua eli")
                   //.icon(BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_YELLOW)
                      .icon(BitmapDescriptorFactory.fromResource(R.drawable.icone_loja)
                      )
        );*/

        mMap.moveCamera(//2.0 até 21.0 zoom
                CameraUpdateFactory.newLatLngZoom(ruaEli, 21));


    }
}