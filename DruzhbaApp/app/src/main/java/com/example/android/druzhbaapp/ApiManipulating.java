package com.example.android.druzhbaapp;

import android.app.Application;

import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManipulating extends Application {
    private DataApi api;
    private FirebaseAuth auth;

    public void onCreate() {
        super.onCreate();
        api = createApi();
    }

    public FirebaseAuth getAuth() {
        return auth;
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
