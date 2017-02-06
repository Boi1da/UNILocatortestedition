package com.example.armani.unilocator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.armani.unilocator.R;
import com.example.armani.unilocator.holders.LocationViewHolder;
import com.example.armani.unilocator.model.Unilocator;

import java.util.ArrayList;


/**
 * Created by Armani on 05/02/2017.
 */

public class LocationsAdapter extends RecyclerView.Adapter<LocationViewHolder> {

    private ArrayList<Unilocator> locations;

    public LocationsAdapter(ArrayList<Unilocator> locations) {
        this.locations = locations;
    }

    @Override
    public void onBindViewHolder(LocationViewHolder holder, int position) {
        final Unilocator location = locations.get(position);
        holder.updateUI(location);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Load the page to here. Maybe to show about the page??
            }

    });
}

    @Override
    public int getItemCount() {
        //Need to know how many locations are nearby
        return locations.size();
    }

    @Override
    //Create a new VIEW everytime we need one
    public LocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View card = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_location, parent, false);
        return new LocationViewHolder(card);
    }


}
