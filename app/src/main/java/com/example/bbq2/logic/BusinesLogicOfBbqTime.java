package com.example.bbq2.logic;

import android.util.Log;

public class BusinesLogicOfBbqTime {
    public final static String TAG = "BusinesLogicOfBbqTime";
    private static final double MINIMUM_TEMPERATURE_FOR_BBQ = 20.0;
    private static final double MAXIMUM_RAIN_FOR_BBQ = 2.0;
    private static final String LETS_HAVE_A_BBQ_MESSAGE = "You can do a barbeque!";

    public boolean isItBbqTime(double temp, double rain){
        boolean result = temp >= MINIMUM_TEMPERATURE_FOR_BBQ && rain < MAXIMUM_RAIN_FOR_BBQ;
        Log.i(TAG, "isItBbqTime: " + result);
        return result;
    }

    public String getBbqMessage(){
        Log.i(TAG, "BBQ message: " + LETS_HAVE_A_BBQ_MESSAGE);
        return LETS_HAVE_A_BBQ_MESSAGE;
    }
}
