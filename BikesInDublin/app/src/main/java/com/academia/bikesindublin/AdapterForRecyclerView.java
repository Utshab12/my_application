package com.academia.bikesindublin;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;


public class AdapterForRecyclerView extends RecyclerView.Adapter<AdapterForRecyclerView.ItemsViewHolder>{
//the purpose to make this adapter class is to apply the AdapterDesignPattern as suggested by Android Docs to implement RecyclerList in views

    private List<JsonModelForStation> dataListForBikeStationInfo;

            //this context instance is to get the context from activity
            // and use it to navigate to other activity screen
    private Context contextForActivity;

    public AdapterForRecyclerView(Context contextForActivity, List<?> Data) {
        this.contextForActivity = contextForActivity;
        this.dataListForBikeStationInfo = (List<JsonModelForStation>) Data;

    }


    //methods overriding of RecyclerViewAdapter parent class
    @NonNull
    @Override
    public ItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            //inflating the recyclerLayout to RecyclerListview
        View mView= LayoutInflater.from(contextForActivity).inflate(R.layout.recyclerview_for_station_info, parent,false);
                    return new ItemsViewHolder(mView);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemsViewHolder holder, int position) {

        final JsonModelForStation jsonModelForStationItem = dataListForBikeStationInfo.get(position);


        holder.textViewForStationName.setText(jsonModelForStationItem.getName());
        holder.relativeLayoutForStation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(contextForActivity, DisplayStationFullInfo.class);
                Gson gson=new Gson();
                myIntent.putExtra("item",gson.toJson(jsonModelForStationItem));
                contextForActivity.startActivity(myIntent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataListForBikeStationInfo.size();
    }



    public static class ItemsViewHolder extends RecyclerView.ViewHolder{
        //associates the views in recyclerViewForStationInfo to their objects

        TextView textViewForStationName;
        RelativeLayout relativeLayoutForStation;


        public ItemsViewHolder(View itemView) {
            super(itemView);

            textViewForStationName=itemView.findViewById(R.id.textViewForStationName);
            relativeLayoutForStation=itemView.findViewById(R.id.relativeLayoutForStation);

        }
    }


}
