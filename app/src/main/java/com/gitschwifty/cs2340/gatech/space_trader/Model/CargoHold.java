package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * CargoHold
 */
public class CargoHold extends AppCompatActivity{

    /**
     * @param goodsList tag
     */
    public static void add(GoodsList goodsList) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("players").child(LoginActivity.getNewPlayer().getUID()).child("goods").
                child(goodsList.toString()).push().setValue(goodsList);
    }

    /**
     * @param goodsList tag
     */
    public void remove(GoodsList goodsList) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("players").child(LoginActivity.getNewPlayer().getUID()).child("goods").
                child(goodsList.toString()).removeValue();
    }

    /**
     * @return getSize
     */
    public int getSize() {
        return toDisplay.size();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_hold);
    }
}

