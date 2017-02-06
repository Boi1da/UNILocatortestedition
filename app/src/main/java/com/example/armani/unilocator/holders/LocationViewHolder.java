package com.example.armani.unilocator.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.armani.unilocator.R;
import com.example.armani.unilocator.model.Unilocator;

/**
 * Created by Armani on 05/02/2017.
 */
public class LocationViewHolder extends RecyclerView.ViewHolder {

    private ImageView userImage;
    private TextView userTitle;
    private TextView userDescription;


    public LocationViewHolder(View itemView) {
        super(itemView);

        userImage = (ImageView)itemView.findViewById(R.id.user_image);
        userTitle = (TextView)itemView.findViewById(R.id.user_title);
        userDescription = (TextView)itemView.findViewById(R.id.user_description);

    }

    //Create a drawable UI
    public void updateUI(Unilocator location){
        String uri = location.getImgUrl();
        int resource = userImage.getResources().getIdentifier(uri, null, userImage.getContext().getPackageName());
        userImage.setImageResource(resource);
        userTitle.setText(location.getLocationTitle());
        userDescription.setText(location.getLocationAddress());

    }
}
