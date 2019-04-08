package com.gitschwifty.cs2340.gatech.space_trader.ViewModel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.SolarSystem;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.CurrentPlanetActivity;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.gitschwifty.cs2340.gatech.space_trader.View.SolarSystemActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<SolarSystem> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView name;
        TextView coord;
        TextView fuel;
        ImageView personPhoto;
        CardView c;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.txtName);
            coord = (TextView)itemView.findViewById(R.id.txtDistance);
            personPhoto = (ImageView)itemView.findViewById(R.id.img);
            fuel = (TextView) itemView.findViewById(R.id.txtFuel);
            c = itemView.findViewById(R.id.card);
        }
    }

    public MyAdapter(List<SolarSystem> myDataset) {
        mDataset = myDataset;
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.card, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int i) {
        if (!mDataset.get(i).name.equals(LoginActivity.getNewPlayer().currentPlanet.name)) {
            holder.name.setText(mDataset.get(i).name);
            holder.coord.setText("X: "+ mDataset.get(i).location.getX()+ " Y: " + mDataset.get(i).location.getY());
            holder.personPhoto.setImageResource(mDataset.get(i).imagePath);
            holder.fuel.setText("Fuel Needed: " + LoginActivity.getNewPlayer().getSpaceship().costTravel(mDataset.get(i)));
        }

        holder.c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginActivity.getNewPlayer().getSpaceship().travel(mDataset.get(i));
                LoginActivity.getNewPlayer().setCurrPlanet(new CurrentPlanet(mDataset.get(i).ordinal()));
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
                Query planet = ref.orderByChild("currentPlanet");
                planet.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        dataSnapshot.child(LoginActivity.getNewPlayer().getUID()).child("currentPlanet").getRef().setValue(new CurrentPlanet(mDataset.get(i).ordinal()));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
