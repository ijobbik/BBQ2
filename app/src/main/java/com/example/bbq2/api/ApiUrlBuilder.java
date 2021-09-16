package com.example.bbq2.api;

import android.util.Log;

public class ApiUrlBuilder {
    public final static String TAG = "ApiUrlBuilder";
    private static final String URL_PRE = "https://api.openweathermap.org/data/2.5/onecall?";
    private static final String LAT = "lat=";
    private static final String LON = "&lon=";
    private static final String EXCLUDE_AND_UNITS = "&exclude=minutely,hourly,daily,alerts&units=metric";
    private static final String APP_ID = "&appid=";
    private static final String API_KEY = "7aec8a60233f2696bddde03d624bb925";
    private String url;

    public String getUrl(double lat, double lon){
        url = URL_PRE + LAT + lat + LON + lon + EXCLUDE_AND_UNITS + APP_ID + API_KEY;
        Log.i(TAG,"Get url: " + url);
        return url;
    }
}
