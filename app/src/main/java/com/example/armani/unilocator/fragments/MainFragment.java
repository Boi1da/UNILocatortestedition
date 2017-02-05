package com.example.armani.unilocator.fragments;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.armani.unilocator.R;
import com.example.armani.unilocator.model.Unilocator;
import com.example.armani.unilocator.services.DataService;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment implements OnMapReadyCallback {


    private GoogleMap mMap; //This is the actual map that i can use
    private MarkerOptions userMarker;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("DONKEY", "Check if this is being created");

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        //This must be used to actually use the map
        mapFragment.getMapAsync(this);

        return view;

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }

    //Set a marker based on USER position
    public void setUserMarker(LatLng latLng) {
        if (userMarker == null){
            userMarker = new MarkerOptions().position(latLng).title("Current Location");
            mMap.addMarker(userMarker);
            Log.v("DONKEY" , "Current location: " + latLng.latitude + " Long: " + latLng.longitude);
        }

        updateMapForCampus("stjohns");
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));

    }

    //Change to work with the update
    private void updateMapForCampus(String campus){
        //Check 10 mile raduis for stuff
        ArrayList<Unilocator> locations = DataService.getInstance().getCampusLocationsWithin10milesofEnteredSite(campus);

        for (int x = 0; x < locations.size(); x++) {
            Unilocator loc = locations.get(x);
            MarkerOptions marker = new MarkerOptions().position(new LatLng(loc.getLatitude(), loc.getLongitude()));
            marker.title(loc.getLocationTitle());
            marker.snippet(loc.getLocationAddress());
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.map_pin));
            mMap.addMarker(marker);

        }
    }

}
