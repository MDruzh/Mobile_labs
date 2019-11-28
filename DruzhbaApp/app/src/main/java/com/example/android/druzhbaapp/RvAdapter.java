package com.example.android.druzhbaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.PlaneViewHolder> {
    private List<Plane> planes;

    public RvAdapter(List<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public PlaneViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_list_of_items, viewGroup, false);
        PlaneViewHolder planeViewHolder = new PlaneViewHolder(v);
        return planeViewHolder;
    }

    @Override
    public void onBindViewHolder(final PlaneViewHolder planeViewHolder, final int i) {
        Picasso.get().load(planes.get(i).getPoster()).into(planeViewHolder.avatar);
        planeViewHolder.model.setText(planes.get(i).getModel());
        planeViewHolder.company.setText(planes.get(i).getCompany());
        planeViewHolder.speed.setText(planes.get(i).getSpeed());
        planeViewHolder.route.setText(planes.get(i).getRoute());
    }

    @Override
    public int getItemCount() {
        return planes.size();
    }

    public static class PlaneViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView avatar;
        private TextView model;
        private TextView company;
        private TextView speed;
        private TextView route;
        private SwipeRefreshLayout refreshLayout;

        PlaneViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            refreshLayout = (SwipeRefreshLayout) itemView.findViewById(R.id.swipe);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
            model = (TextView) itemView.findViewById(R.id.model);
            company = (TextView) itemView.findViewById(R.id.company);
            speed = (TextView) itemView.findViewById(R.id.speed);
            route = (TextView) itemView.findViewById(R.id.route);
        }
    }

}
