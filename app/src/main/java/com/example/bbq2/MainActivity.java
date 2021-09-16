package com.example.bbq2;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bbq2.api.ApiUrlBuilder;
import com.example.bbq2.gps.VenueLocation;
import com.example.bbq2.logic.BusinesLogicOfBbqTime;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "MainActivity";
    private VenueLocation venueLocation = new VenueLocation();
    private ApiUrlBuilder apiUrlBuilder = new ApiUrlBuilder();
    private BusinesLogicOfBbqTime businesLogicOfBbqTime = new BusinesLogicOfBbqTime();
    private RequestQueue queue;
    private TextView textView;
    private double temp;
    private double rain = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.messageBox);
        queue = Volley.newRequestQueue(this);

        doBbq();
    }

    public void doBbq() {
        Log.i(TAG, "BBQ start");
        double lat = venueLocation.getLatitude();
        double lon = venueLocation.getLongitude();
        String url = apiUrlBuilder.getUrl(lat, lon);
        getWeather(url);
    }

    private void quit() {
        Log.i(TAG, "quit - good bye");
        finish();
        System.exit(0);
    }

    private void getWeather(String url) {
        JsonObjectRequest request = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i(TAG, "Response: " + response.toString());
                        JSONObject current = null;
                        try {
                            current = response.getJSONObject("current");
                            temp = Double.parseDouble(current.getString("temp"));
                            Log.i(TAG, "temp: " + temp);
                            String weather = current.getJSONArray("weather")
                                    .getJSONObject(0).getString("main");
                            Log.i(TAG, "weather: " + weather);
                            if (weather.equals("Rain")) {
                                rain = Double.parseDouble(current.getJSONObject("rain")
                                        .getString("1h"));
                            }
                            Log.i(TAG, "rain: " + rain);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        decideAboutTheBbq();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage());
                    }
                });
        queue.add(request);
    }

    private void decideAboutTheBbq() {
        if (businesLogicOfBbqTime.isItBbqTime(temp, rain)) {
            String text = businesLogicOfBbqTime.getBbqMessage();
            textView.setText(text);
        } else {
            quit();
        }
    }
}