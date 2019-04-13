package com.gitschwifty.cs2340.gatech.space_trader.ViewModel;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.SolarSystem;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

/**
 * MyAdapter
 */
@SuppressWarnings("ALL")
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final List<SolarSystem> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        final TextView name;
        final TextView coord;
        final TextView fuel;
        final ImageView personPhoto;
        final CardView c;

        MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txtName);
            coord = itemView.findViewById(R.id.txtDistance);
            personPhoto = itemView.findViewById(R.id.img);
            fuel = itemView.findViewById(R.id.txtFuel);
            c = itemView.findViewById(R.id.card);
        }
    }

    /**
     * @param myDataset tag
     */
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

    @SuppressLint({"RecyclerView", "SetTextI18n"})
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
