package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Spaceship;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
public class Ship {

    private Spaceship shipType;
    private int currFuel;
    private int currCargoSpace;
    private HashMap<GoodsList, Integer> inventory;
    private SolarSystem currSystem;

    Ship (Spaceship shipType, SolarSystem currSystem) {
        this.shipType = shipType;
        currFuel = shipType.getFuelCapacity();
        currCargoSpace = shipType.getMaxCargo();
        this.inventory = null;
        this.currSystem = currSystem;
    }

    Ship() {

    }
    public boolean hasSpace() {
        return shipType.getMaxCargo() - inventory.size() > 0;
    }

    public HashMap<GoodsList, Integer> getInventory() {
        return inventory;
    }

    public SolarSystem getLocation() {
        return currSystem;
    }

    public int getCurrCargoSpace() {
        return currCargoSpace;
    }

    public int getCurrFuel() {
        return currFuel;
    }

    public Spaceship getShipType() {
        return shipType;
    }


    public List findAccessibleSystems() {
        List<SolarSystem> possDest = new ArrayList<>();
        Coordinate currLoc = currSystem.location;
        int travelDist = currFuel * this.getShipType().getFuelDistance();
        for (SolarSystem ss : SolarSystem.values()) {
            if (Coordinate.distance(currLoc,ss.location) <= travelDist && Coordinate.distance(currLoc,ss.location) != 0) {
                possDest.add(ss);
            }
        }
        return possDest;
    }

    public int costTravel(SolarSystem s) {
        int efficiency = this.getShipType().getFuelDistance();
        int dist = Coordinate.distance(currSystem.location, s.location);
        int cost = dist/efficiency;
        return cost;
    }

    public void travel(SolarSystem s) {
        this.currFuel -= this.costTravel(s);
        RandomEvent event = RandomEvent.eventGen();
        currSystem = s;
        if (event == null) {
            Log.d("Activity", "No Event");
        }
        if (event == RandomEvent.BONUS) {
            LoginActivity.getNewPlayer().setCreditScore(LoginActivity.getNewPlayer().getCreditScore() + 150);
            Log.d("Activity", "Bonus");
        }
        if (event == RandomEvent.WARPED) {
//            SolarSystem[] ss = SolarSystem.values();
//            currSystem = ss[new Random().nextInt(10)];
            Log.d("Activity", "Cargo Lost");
        }
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
        Query planet = ref.orderByChild("currShip");
        planet.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                dataSnapshot.child(LoginActivity.getNewPlayer().getUID()).child("currShip").child("currFuel").getRef().setValue(currFuel);
                dataSnapshot.child(LoginActivity.getNewPlayer().getUID()).child("currShip").child("location").getRef().setValue(currSystem);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
