package com.example.searchviewwithrecyclerview.Controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.searchviewwithrecyclerview.Model.Planet;
import com.example.searchviewwithrecyclerview.R;
import com.example.searchviewwithrecyclerview.View.PlanetViewHolder;

import java.util.List;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetViewHolder> {
    private List<Planet> planetList;

    public PlanetAdapter(List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview_itemview, viewGroup, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder planetViewHolder, int position) {
        planetViewHolder.onBind(planetList.get(position));
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public void setData(List<Planet> planetList) {
        this.planetList = planetList;
        notifyDataSetChanged();
    }
}
