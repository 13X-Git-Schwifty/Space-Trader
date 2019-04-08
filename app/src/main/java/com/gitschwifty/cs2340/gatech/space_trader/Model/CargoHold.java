package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CargoHold extends AppCompatActivity{
    public CargoHold() {
    }

    public static void add(GoodsList goodsList) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("players").child(LoginActivity.getNewPlayer().getUID()).child("goods").child(goodsList.toString()).push().setValue(goodsList);
    }

    public void remove(GoodsList goodsList) {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("players").child(LoginActivity.getNewPlayer().getUID()).child("goods").child(goodsList.toString()).removeValue();
    }
//    public int getSize() {
//        return toDisplay.size();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_hold);
    }
}

