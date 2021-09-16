package com.example.bbq2.gps;

import android.util.Log;

public class VenueLocation {
    public final static String TAG = "Location";
    public double getLatitude() {
        Log.i(TAG,"Gwt latitude: " + latitude);
        return latitude;
    }

    public double getLongitude() {
        Log.i(TAG,"Gwt longitude: " + longitude);
        return longitude;
    }

    private double latitude;
    private double longitude;

    public VenueLocation() {
        latitude =  47.4979;
        longitude = 19.0402;
    }
}
