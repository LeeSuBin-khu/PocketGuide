package com.lee.pg;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class Spot_Adapter extends RecyclerView.Adapter<Spot_Adapter.SpotViewHolder>{

    List<Spot> spots;

    public Spot_Adapter(List<Spot> spots){
        this.spots = spots;
    }

    @Override
    public SpotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_spot, parent, false);
        Log.println(Log.INFO, "card", "card");
        SpotViewHolder pvh = new SpotViewHolder(v);
        return pvh;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)

    @Override
    public void onBindViewHolder(SpotViewHolder holder, int position) {
        holder.spotName.setText(spots.get(position).getName());
        holder.spotLocation.setText(spots.get(position).getLocation());
        //Ion.with(holder.spotImage).error(R.mipmap.ic_launcher).load(spots.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return spots.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class SpotViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView cv;
        MaterialTextView spotName;
        MaterialTextView spotLocation;
        ShapeableImageView spotImage;

        SpotViewHolder(View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.card_spot);
            spotName = itemView.findViewById(R.id.text_spot_name);
            spotLocation = itemView.findViewById(R.id.text_spot_location);
            spotImage = itemView.findViewById(R.id.image_spot);
        }
    }

}