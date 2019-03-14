package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gitschwifty.cs2340.gatech.space_trader.R;

public class CargoHold extends AppCompatActivity{
    String[] name;
    int[] price;
    TechLevel[] techLevel;
    int[] quantity;

    public CargoHold() {
        this.name = new String[]{"Water", "Fur", "Food", "Ore", "Games", "Firearms", "Medicine", "Machines", "Narcotics", "Robots"};
        this.price = new int[10];
        this.techLevel = new TechLevel[]{TechLevel.PreAgriculture, TechLevel.Agriculture, TechLevel.PreAgriculture, TechLevel.EarlyIndustrial, TechLevel.Renaissance, TechLevel.Industrial, TechLevel.Industrial, TechLevel.Industrial, TechLevel.PostIndustrial, TechLevel.PostIndustrial};
        this.quantity = new int[10];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargo_hold);
    }
}
