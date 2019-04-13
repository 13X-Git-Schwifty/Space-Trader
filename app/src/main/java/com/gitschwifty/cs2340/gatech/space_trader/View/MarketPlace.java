package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.gitschwifty.cs2340.gatech.space_trader.R;

/**
 * MarketPlace
 */
public class MarketPlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
        Log.d("mptest","created");
    }

    /**
     * @param v tag
     */
    public void goToBuy(View v) {
        Intent intent = new Intent(MarketPlace.this,BuyItem.class);
        startActivity(intent);
    }

    /**
     * @param v tag
     */
    public void goToSell(View v) {
        Intent intent = new Intent(MarketPlace.this,SellItem.class);
        startActivity(intent);
    }

    /**
     * @param v tag
     */
    public void goToMarketplace(View v) {
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        startActivity(intent);
    }

//    public void goToCargo(View v) {
//        Intent intent = new Intent(MarketPlace.this,CargoHold.class);
//        startActivity(intent);
//    }

    /**
     * @param v tag
     */
    public void back(View v) {
        Intent intent = new Intent(this, CurrentPlanetActivity.class);
        startActivity(intent);
    }
}
