package com.academia.bikesindublin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import java.util.List;

//NAME
//STUDENT NUMBER

public class DisplayRecyclerList extends AppCompatActivity {

    RecyclerView recyclerViewForStationData;
    AdapterForRecyclerView adapterForRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_recycler_list);

        List<JsonModelForStation> list = RenderGoogleMapMarkers.listOfStations;

        //configuration of recyclerAdapter
            recyclerViewForStationData =findViewById(R.id.recyclerViewForStationsList);
                        adapterForRecyclerView =new AdapterForRecyclerView(this, list);
                        //decorating recyclerAdapter
            recyclerViewForStationData.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewForStationData.setItemAnimator(new DefaultItemAnimator());
            recyclerViewForStationData.setAdapter(adapterForRecyclerView);

        adapterForRecyclerView.notifyDataSetChanged();





    }
}
