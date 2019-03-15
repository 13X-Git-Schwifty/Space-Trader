package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.RecyclerViewAdapter;

import java.util.ArrayList;

public class BuyItem extends AppCompatActivity {

    private ArrayList<String> item_name = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item);
        addtoList();
    }

    private void addtoList() {

        item_name.add("Water");
        item_name.add("Pizza");
        item_name.add("Pigs");

        initRecyclerView();
    }


    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(item_name,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void updateItems()
    {


    }

    public void onClick(View v) {


    }



}
