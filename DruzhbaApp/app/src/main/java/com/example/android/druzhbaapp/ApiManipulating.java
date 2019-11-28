package com.example.android.druzhbaapp;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManipulating extends Application {
    private DataApi api;

    public void onCreate() {
        super.onCreate();
        api = createApi();
    }

    public DataApi getApi() {
        return api;
    }

    public DataApi createApi() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us-central1-druzhbaapp.cloudfunctions.net/planes/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(DataApi.class);
    }
}
