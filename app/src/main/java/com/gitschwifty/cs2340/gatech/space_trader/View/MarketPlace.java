package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gitschwifty.cs2340.gatech.space_trader.R;

public class MarketPlace extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);
    }

    public void buyitem (View v) {
        Intent intent = new Intent(MarketPlace.this, BuyItem.class);
        startActivity(intent);

    }

    public void sellitem (View v) {
        Intent intent = new Intent(MarketPlace.this, SellItem.class);
        startActivity(intent);

    }
}
