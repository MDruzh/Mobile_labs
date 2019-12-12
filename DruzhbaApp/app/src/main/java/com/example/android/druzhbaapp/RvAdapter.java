package com.example.android.druzhbaapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PlaneViewHolder> {
    private List<Plane> planes;
    private Context context;

    public RvAdapter(Context context, List<Plane> planes) {
        this.context = context;
        this.planes = planes;
    }

    @NonNull
    @Override
    public RvAdapter.PlaneViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {

        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list_of_items, parent, false);
        return new PlaneViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final PlaneViewHolder planeViewHolder, final int i) {
        Picasso.get().load(planes.get(i).getPoster()).into(planeViewHolder.avatar);
        planeViewHolder.model.setText(planes.get(i).getModel());
        planeViewHolder.company.setText(planes.get(i).getCompany());
        planeViewHolder.speed.setText(planes.get(i).getSpeed());
        planeViewHolder.route.setText(planes.get(i).getRoute());
        planeViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItemDetails(i);
            }
        });
    }

    private void openItemDetails(int position) {
        Intent intent = new Intent(context, DataContainer.class);
        intent.putExtra("company", planes.get(position).getCompany());
        intent.putExtra("model", planes.get(position).getModel());
        intent.putExtra("route", planes.get(position).getRoute());
        intent.putExtra("speed", planes.get(position).getSpeed());
        intent.putExtra("image", planes.get(position).getPoster());

        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return planes.size();
    }

    public static class PlaneViewHolder extends RecyclerView.ViewHolder {
        private ImageView avatar;
        private TextView model;
        private TextView company;
        private TextView speed;
        private TextView route;
        //private SwipeRefreshLayout refreshLayout;
        private LinearLayout layout;

        PlaneViewHolder(View itemView) {
            super(itemView);
            //refreshLayout = (SwipeRefreshLayout) itemView.findViewById(R.id.swipe);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            model = (TextView) itemView.findViewById(R.id.plane_model);
            company = (TextView) itemView.findViewById(R.id.plane_company);
            speed = (TextView) itemView.findViewById(R.id.plane_speed);
            route = (TextView) itemView.findViewById(R.id.plane_route);
            layout = itemView.findViewById(R.id.main_layout);
        }
    }

}
