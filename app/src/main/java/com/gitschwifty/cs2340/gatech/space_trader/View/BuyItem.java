package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gitschwifty.cs2340.gatech.space_trader.Model.GoodsList;
import com.gitschwifty.cs2340.gatech.space_trader.Model.SolarSystem;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.BuyItemAdapter;

import java.util.ArrayList;

public class BuyItem extends AppCompatActivity {
    private static final String TAG = "BuyItem";

    //vars
    private ArrayList<String> mItemNames = new ArrayList<>();
    private ArrayList<Integer> mItemPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);
        Log.d(TAG, "onCreate: started.");
        initItems();
    }

    private void initItems() {
        Log.d(TAG, "initItems, preparing.");
        for (GoodsList item : GoodsList.values()) {
            if ((com.gitschwifty.cs2340.gatech.space_trader.View.CurrentPlanetActivity.getCurrentPlanet().techLevel).equals(item.getMtlu())
            || (com.gitschwifty.cs2340.gatech.space_trader.View.CurrentPlanetActivity.getCurrentPlanet().techLevel).equals(item.getMtlp())
            || (com.gitschwifty.cs2340.gatech.space_trader.View.CurrentPlanetActivity.getCurrentPlanet().techLevel).equals(item.getTtp())){
                mItemNames.add(item.toString());
                mItemPrices.add((int) (Math.random()* 200));
            } else  {
                mItemNames.add(item.toString());
                mItemPrices.add(0);
            }

        }
        initRecyclerView();
        }

        private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
            RecyclerView recyclerView = findViewById(R.id.buy_item_recycler_view);
            BuyItemAdapter adapter = new BuyItemAdapter(mItemNames, mItemPrices, this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

        }

}
