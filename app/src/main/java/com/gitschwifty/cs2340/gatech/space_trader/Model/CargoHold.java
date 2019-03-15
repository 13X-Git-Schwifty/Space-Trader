package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;

import java.util.ArrayList;

public class CargoHold extends AppCompatActivity{
    ArrayList<GoodsList> toDisplay = new ArrayList<>();

    public CargoHold() {
        ArrayList<GoodsList> cargoItems = LoginActivity.getNewPlayer().getPlayerGoods();
        for (int i = 0; i< cargoItems.size(); i++) {
            toDisplay.add(cargoItems.get(i));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_hold);
    }
}

