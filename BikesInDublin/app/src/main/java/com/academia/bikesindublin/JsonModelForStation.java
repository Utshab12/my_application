package com.academia.bikesindublin;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


//NAME
//STUDENT NUMBER

//making this class serializable to use in intents
public class JsonModelForStation {

            @SerializedName("number")
            private int number;

           @SerializedName("contract_name")
            private String contract_name;

            @SerializedName("name")
            private String name;

            @SerializedName("address")
            private String address;

             @SerializedName("position")
            private Position pos;

            @SerializedName("banking")
            private boolean banking;

             @SerializedName("bonus")
            private boolean bonus;

           @SerializedName("bike_stands")
            private int bike_stands;

           @SerializedName("available_bike_stands")
            private int available_bike_stands;

    @SerializedName("available_bikes")
    private int available_bikes;

            @SerializedName("status")
            private String status;

            @SerializedName("last_update")
            private long last_update;

    public JsonModelForStation() {
    }

    public JsonModelForStation(int number, String contract_name, String name, String address, Position pos, boolean banking, boolean bonus, int bike_stands, int available_bike_stands, int available_bikes, String status, long last_update) {
        this.number = number;
        this.contract_name = contract_name;
        this.name = name;
        this.address = address;
        this.pos = pos;
        this.banking = banking;
        this.bonus = bonus;
        this.bike_stands = bike_stands;
        this.available_bike_stands = available_bike_stands;
        this.available_bikes = available_bikes;
        this.status = status;
        this.last_update = last_update;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContract_name(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPos() {
        return pos;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public boolean isBanking() {
        return banking;
    }

    public void setBanking(boolean banking) {
        this.banking = banking;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public int getBike_stands() {
        return bike_stands;
    }

    public void setBike_stands(int bike_stands) {
        this.bike_stands = bike_stands;
    }

    public int getAvailable_bike_stands() {
        return available_bike_stands;
    }

    public void setAvailable_bike_stands(int available_bike_stands) {
        this.available_bike_stands = available_bike_stands;
    }

    public int getAvailable_bikes() {
        return available_bikes;
    }

    public void setAvailable_bikes(int available_bikes) {
        this.available_bikes = available_bikes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getLast_update() {
        return last_update;
    }

    public void setLast_update(long last_update) {
        this.last_update = last_update;
    }
}
