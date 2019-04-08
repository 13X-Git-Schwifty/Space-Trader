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

    public static ArrayList<String> getmItemNames() {
        return mItemNames;
    }

    public static ArrayList<Integer> getmItemPrices() {
        return mItemPrices;
    }

    //vars
    private static ArrayList<String> mItemNames = new ArrayList<>();
    private static ArrayList<Integer> mItemPrices = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);
        Log.d(TAG, "onCreate: started.");
        updateInfo();
        initItems();
    }

    private void initItems() {
        Log.d(TAG, "initItems, preparing.");
        for (GoodsList item : GoodsList.values()) {
            if ((LoginActivity.getNewPlayer().getCurrPlanet().techLevel).equals(item.getMtlu())
            || (LoginActivity.getNewPlayer().getCurrPlanet().techLevel).equals(item.getMtlp())
            || (LoginActivity.getNewPlayer().getCurrPlanet().techLevel).equals(item.getTtp())){
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

        public void updateInfo() {
            //creditScore
            TextView creditScoreTV = findViewById(R.id.creditScoreDisplay);
            String cred =  "Your credit score is: " + LoginActivity.getNewPlayer().getCreditScore();
            creditScoreTV.setText(cred);
            //cargo space
            TextView cargoSpaceTV = findViewById(R.id.cargoSpaceDisplay);

            String size = "Remaingin cargo space is: 20";
            cargoSpaceTV.setText(size);
        }

}
