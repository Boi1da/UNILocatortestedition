package com.example.armani.unilocator.model;

/**
 * Created by Armani on 05/02/2017.
 */

public class Unilocator {
    final String DRAWABLE = "drawable/";

   public String getImgUrl() {
        return DRAWABLE + UserImrUrl;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public String getUserTitle() {
        return userTitle;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public String getUserImrUrl() {
        return UserImrUrl;
    }

    private float longitude;
    private float latitude;
    private String userTitle;
    private String userDescription;
    private String UserImrUrl;


    //Change tommorow zzzz
    public Unilocator(float latitude, float longitude, String userTitle, String userDescription, String UserImrUrl) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.userTitle = userTitle;
        this.userDescription = userDescription;
        this.UserImrUrl = UserImrUrl;
    }


}


