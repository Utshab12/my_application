package com.academia.bikesindublin;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


//Student Name
//Student Number


public class RenderGoogleMapMarkers extends FragmentActivity implements OnMapReadyCallback {



    private SupportMapFragment supportMapFragment;

    public static List<JsonModelForStation> listOfStations;
    int i = 0;
    private Button buttonForList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps_marker);

        //Button to navigate to listOfStations screen
        buttonForList = findViewById(R.id.buttonForList);
        buttonForList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(getApplicationContext(), DisplayRecyclerList.class);
                startActivity(myIntent);
            }
        });
        listOfStations =new ArrayList<>();

        supportMapFragment = (SupportMapFragment)getSupportFragmentManager()
                .findFragmentById(R.id.fragmentForGoogleMaps);

        final RequestQueue mQueue;
            mQueue = Volley.newRequestQueue(this);

        String urlForRequest = "https://api.jcdecaux.com/vls/v1/stations?contract=dublin&apiKey=814fba215ef221286fb345992da46f42064ccbb7";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, urlForRequest, null,new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject myStationJson = response.getJSONObject(i);
                                Gson gson=new Gson();
                                    JsonModelForStation model=gson.fromJson(myStationJson.toString(),JsonModelForStation.class);

                                listOfStations.add(model);
                            }

                            getMarkersData();

                            mQueue.stop();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);

    }



    public void getMarkersData(){
        if(i == 0){
                //getting the markers data for view of markers
            supportMapFragment.getMapAsync(this);
        }
        //setting to 1 so that, the asynchronous requests stop after getting response 1st time
        i = 1;

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
                        //overriding of method to render markers in Google Maps View
        int size = (int)listOfStations.size()/4;
        for(int i = 0; i < size; i++) {
            LatLng myloc=new LatLng(listOfStations.get(i).getPos().getLatitude(), listOfStations.get(i).getPos().getLongitude());
            googleMap.addMarker(new MarkerOptions().position(myloc).title(listOfStations.get(i).getName()));
                //setting camera zoom
                 googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(myloc, 8f));
        }
    }
}
