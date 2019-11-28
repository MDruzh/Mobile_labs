package com.example.android.druzhbaapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataApi {
    @GET("planes")
    Call<List<Plane>> getPlane();
}
