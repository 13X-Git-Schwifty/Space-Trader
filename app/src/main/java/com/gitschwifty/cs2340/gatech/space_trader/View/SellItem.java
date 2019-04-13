package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.gitschwifty.cs2340.gatech.space_trader.Model.GoodsList;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.SellItemAdapter;
import com.gitschwifty.cs2340.gatech.space_trader.View.BuyItem;


import java.util.ArrayList;
import java.util.Arrays;

import static com.gitschwifty.cs2340.gatech.space_trader.View.BuyItem.*;

public class SellItem extends AppCompatActivity {

    ArrayList<String> itemNames = getmItemNames();
    ArrayList<String> temp = new ArrayList<>();
    ArrayList<Integer> temp1 = new ArrayList<>();

    ArrayList<Integer> itemPrices = getmItemPrices();
    ArrayList<String> cargoItems = com.gitschwifty.cs2340.gatech.space_trader.ViewModel.BuyItemAdapter.getCargoItems();
    ArrayList<Integer> cargoItemsPrice = com.gitschwifty.cs2340.gatech.space_trader.ViewModel.BuyItemAdapter.getCargoItemPrice();


    private void initItems() {
        for (int i = 0;i<cargoItems.size();i++) {

            temp.add(cargoItems.get(i).toString());
            temp1.add(cargoItemsPrice.get(i));

        }

        initRecyclerView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_item);
        Log.i("piggy",Arrays.toString(cargoItems.toArray()) );
        Log.i("poilliop",Arrays.toString(itemPrices.toArray()) );
        initItems();
    }


    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.sell_item_recycler_view);
        SellItemAdapter adapter = new SellItemAdapter(temp, temp1, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
