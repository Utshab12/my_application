package com.academia.bikesindublin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;


//this class displays the station data in activity
public class DisplayStationFullInfo extends AppCompatActivity {

    TextView textViewForStationName, textViewForStationAddress, textViewForNumberOfBikes,
            textViewForBanking, textViewForStatus, textViewForBonus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_station_full_info);

        textViewForStationName =findViewById(R.id.textViewForStationName);

        textViewForStationAddress =findViewById(R.id.textViewForStationAddress);

        textViewForNumberOfBikes =findViewById(R.id.textViewForNumberOfBikes);

        textViewForBanking =findViewById(R.id.textViewForBanking);

        textViewForStatus =findViewById(R.id.textViewForStatus);

        textViewForBonus =findViewById(R.id.textViewForBonus);

                    //getting data from previous intent and parsing it to Json model of station
            String jsonStr= getIntent().getStringExtra("item");
                    Gson gson=new Gson();
            JsonModelForStation data=gson.fromJson(jsonStr,JsonModelForStation.class);

        textViewForStationName.setText(data.getName());

        textViewForStationAddress.setText("Address of Station:\n\t"+data.getAddress());

        textViewForNumberOfBikes.setText("Available Bikes on Station:\n\t"+data.getAvailable_bikes());

        textViewForBanking.setText("Is Banking Available ?:\n\t"+data.isBanking());

        textViewForStatus.setText("Status of Station:\n\t"+data.getStatus());

        textViewForBonus.setText("Is Bonus Available ?:\n\t"+data.isBonus());


    }
}
