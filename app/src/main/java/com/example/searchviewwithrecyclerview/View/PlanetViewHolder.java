package com.example.searchviewwithrecyclerview.View;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.searchviewwithrecyclerview.Model.Planet;
import com.example.searchviewwithrecyclerview.R;
import com.squareup.picasso.Picasso;

public class PlanetViewHolder extends RecyclerView.ViewHolder {
    private TextView planetNameView;
    private ImageView planetImageView;

    public PlanetViewHolder(@NonNull View itemView, TextView planetNameView, ImageView planetImageView) {
        super(itemView);
        this.planetNameView = itemView.findViewById(R.id.textview_planetname);
        this.planetImageView = itemView.findViewById(R.id.imageview_planetimage);
    }

    public void onBind(final Planet planet) {
        planetNameView.setText(planet.getPlanetName());
        Picasso.get().load(planet.getPlanetImage()).into(planetImageView);
    }
}
