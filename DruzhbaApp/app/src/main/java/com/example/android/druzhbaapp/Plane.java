package com.example.android.druzhbaapp;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

public class Plane {
    @SerializedName("plane model")
    private String model;
    private String company;
    private String speed;
    private String route;
    private String poster;

    public Plane(String model, String company, String speed, String route, String poster) {
        this.model = model;
        this.company = company;
        this.speed = speed;
        this.route = route;
        this.poster = poster;
    }

    public String getModel() {
        return model;
    }

    public String getCompany() {
        return company;
    }

    public String getSpeed() {
        return speed;
    }

    public String getRoute() {
        return route;
    }

    public Uri getPoster() {
        return Uri.parse(poster);
    }
}
