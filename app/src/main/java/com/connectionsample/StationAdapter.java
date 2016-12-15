package com.connectionsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.connectionsample.models.Station;

import java.util.ArrayList;

/**
 * Created by chiu on 2016/12/15.
 */

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.StationViewHolder> {

    private ArrayList<Station> mStations = new ArrayList<>();

    public StationAdapter() {

    }

    @Override
    public StationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_station, parent, false);
        return new StationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StationViewHolder holder, int position) {
        holder.mTxtStation.setText(mStations.get(position).getStation());
        holder.mTxtDescription.setText(mStations.get(position).getDestination());
        holder.mTxtUpdate.setText(mStations.get(position).getUpdateTime());
    }

    @Override
    public int getItemCount() {
        return mStations.size();
    }

    public void setStations(ArrayList<Station> stations) {
        mStations = stations;
        notifyDataSetChanged();
    }


    static class StationViewHolder extends RecyclerView.ViewHolder {
        public TextView mTxtStation;
        public TextView mTxtDescription;
        public TextView mTxtUpdate;

        public StationViewHolder(View itemView) {
            super(itemView);
            mTxtDescription = (TextView) itemView.findViewById(R.id.txt_description);
            mTxtStation = (TextView) itemView.findViewById(R.id.txt_station);
            mTxtUpdate = (TextView) itemView.findViewById(R.id.txt_update_time);
        }
    }
}
