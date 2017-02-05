package com.example.armani.unilocator;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.armani.unilocator.fragments.MainFragment;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class MapsActivity extends FragmentActivity implements GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks, LocationListener {

    private MainFragment mainFragment;
    private GoogleApiClient mGoogleApiClient; //Create the Api client
    final int PERMISSION_LOCATION = 111;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this) // So the Api Client will autom manage itself
                .addConnectionCallbacks(this) //Google APi Client will call the functions for us
                .addApi(LocationServices.API) //Add the LocationServices Api
                .build();

        mainFragment = (MainFragment)getSupportFragmentManager().findFragmentById(R.id.container_main);

        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            //Maps Activity will load mainFragment here and show the map
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container_main, mainFragment)
                    .commit();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    //THIS SHOULD ONLY RUN IF THE USER GIVES PERMISSION!!!
    @Override
    public void onConnected(@Nullable Bundle bundle) { //Runs when were connected (duh)
        //Check for permission
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.ACCESS_FINE_LOCATION} , PERMISSION_LOCATION);
            Log.v("DONKEY" , "Requesting permissions");
        } else {
            Log.v("DONKEY" , "Starting Location Services from onConnected");
            startLocationServices();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onLocationChanged(Location location) {
        Log.v("DONKEY", "Long: " + location.getLongitude() + " - Lat " + location.getLongitude());
        mainFragment.setUserMarker(new LatLng(location.getLatitude(), location.getLongitude()));
    }

    @Override
    protected void onStart() {
        mGoogleApiClient.connect(); //Connect to the client when app starts
        super.onStart();
    }

    @Override
    protected void onStop() { //Stops when we enter background
        super.onStop();
    }


    //Checks the result of the permissions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_LOCATION: {
                //If more than 0 requests have been granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startLocationServices();
                    Log.v("DONKEY" , "Permission Granted - starting services");
                } else { //If its not been granted
                    //show a dialog saying something like "permission wasn't granted"
                    Log.v("DONKEY" , "Permission Granted - starting services");
                }
            }

        }
    }


    public void startLocationServices() { //Start the services ONCE were connected
        Log.v("DONKEY, "," Starting locations services Called"); //For debugging

        try { //See if this works
            LocationRequest req = LocationRequest.create().setPriority(LocationRequest.PRIORITY_LOW_POWER);
             /*PARAMETERS EXPLAINED
            1)It wants the Api Client were using
            2)The request we declared above ( how much power etc)
            3)Were is it calling back too
        */ Log.v("DONKEY" , "Requesting location updates");
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, req, this);
        } catch (SecurityException exception) {
            //Show dialog to user saying we cant get location unless they give this app permission
            Log.v("DONKEY", exception.toString());
        }

    }
}
