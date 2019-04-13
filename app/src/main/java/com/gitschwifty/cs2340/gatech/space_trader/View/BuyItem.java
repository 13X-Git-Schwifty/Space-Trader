package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.gitschwifty.cs2340.gatech.space_trader.Model.GoodsList;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.BuyItemAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
@SuppressWarnings("ALL")
public class BuyItem extends AppCompatActivity {
    private static final String TAG = "BuyItem";
    private static final int PRICE_DET = 200;

    /**
     * @return mItemNames
     */
    public static List<String> getmItemNames() {
        return Collections.unmodifiableList(mItemNames);
    }

    /**
     * @return mItemPrices
     */
    public static List<Integer> getmItemPrices() {
        return Collections.unmodifiableList(mItemPrices);
    }

    //vars
    private static final ArrayList<String> mItemNames = new ArrayList<>();
    private static final ArrayList<Integer> mItemPrices = new ArrayList<>();


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
                mItemPrices.add((int) (Math.random() * PRICE_DET));

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

        private void updateInfo() {
            //creditScore
            TextView creditScoreTV = findViewById(R.id.creditScoreDisplay);
            String cred =  "Your credit score is: " + LoginActivity.getNewPlayer().getCreditScore();
            creditScoreTV.setText(cred);
            //cargo space
            TextView cargoSpaceTV = findViewById(R.id.cargoSpaceDisplay);

            String size = "Remaining cargo space is: 20";
            cargoSpaceTV.setText(size);
        }

}
