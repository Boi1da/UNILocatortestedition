package com.example.armani.unilocator.model;

/**
 * Created by Armani on 05/02/2017.
 */

public class Unilocator {

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getLocationTitle() {
        return locationTitle;
    }

    public String getLocationAddress() {
        return locationAddress;
    }

    public String getLocationImrUrl() {
        return locationImrUrl;
    }

    private float longitude;
    private float latitude;
    private String locationTitle;
    private String locationAddress;
    private String locationImrUrl;

    public Unilocator(float latitude, float longitude, String locationTitle, String locationAddress, String locationImrUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.locationTitle = locationTitle;
        this.locationAddress = locationAddress;
        this.locationImrUrl = locationImrUrl;
    }
}


