package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CargoHold;
import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.R;

public class MarketPlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
    }

    public void goToBuy(View v) {
        Intent intent = new Intent(MarketPlace.this,BuyItem.class);
        startActivity(intent);
    }

    public void goToSell(View v) {
        Intent intent = new Intent(MarketPlace.this,SellItem.class);
        startActivity(intent);
    }

//    public void goToCargo(View v) {
//        Intent intent = new Intent(MarketPlace.this,CargoHold.class);
//        startActivity(intent);
//    }

    public void back(View v) {
        Intent intent = new Intent(MarketPlace.this, CurrentPlanetActivity.class);
        startActivity(intent);
    }
}
