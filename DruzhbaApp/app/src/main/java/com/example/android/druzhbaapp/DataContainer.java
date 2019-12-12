package com.example.android.druzhbaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class DataContainer extends AppCompatActivity {
    private TextView model;
    private TextView company;
    private TextView route;
    private TextView speed;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_container);
        model = findViewById(R.id.model_of_plane);
        company = findViewById(R.id.company_of_plane);
        route = findViewById(R.id.route_of_plane);
        speed = findViewById(R.id.speed_of_plane);
        photo = findViewById(R.id.plane_avatar);

        getData();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getData() {
        if (getIntent().hasExtra("model") &&
                getIntent().hasExtra("company") &&
                getIntent().hasExtra("route") &&
                getIntent().hasExtra("speed")){
            String modelOfPlane = getIntent().getStringExtra("model");
            String companyOfPlane = getIntent().getStringExtra("company");
            String routeOfPlane = getIntent().getStringExtra("route");
            String speedOfPlane = getIntent().getStringExtra("speed");
            String avatarOfPlane = getIntent().getStringExtra("image");

            setData(modelOfPlane, companyOfPlane, routeOfPlane, speedOfPlane, avatarOfPlane);
        }
    }

    private void setData(String modelOfPlane,
                         String companyOfPlane,
                         String routeOfPlane,
                         String speedOfPlane,
                         String avatarOfPlane) {
        model.setText(modelOfPlane);
        company.setText(companyOfPlane);
        route.setText(routeOfPlane);
        speed.setText(speedOfPlane);
        Picasso.get().load(avatarOfPlane).into(photo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(DataContainer.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
