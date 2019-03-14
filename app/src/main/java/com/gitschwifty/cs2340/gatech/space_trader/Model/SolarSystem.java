package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.widget.ImageView;

import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.Locale;

public enum SolarSystem {
    ACAMAR("Acamar", 0, 0, TechLevel.Agriculture, Resources.LIFELESS, R.drawable.planet1),
    BRETEL("Bretel", 10, 10, TechLevel.Medieval, Resources.DESERT, R.drawable.planet2),
    LAVE("Lave", 50, 50, TechLevel.Renaissance, Resources.MINERALRICH, R.drawable.planet3),
    TAMUS("Tamus", 100, 64, TechLevel.PreAgriculture, Resources.WEIRDMUSHROOMS, R.drawable.planet4),
    CORON("Coron", 45, 32, TechLevel.HiTech, Resources.POORSOIL, R.drawable.planet5),
    UTOPIA("Utopia", 92, 87, TechLevel.PostIndustrial, Resources.ARTISTIC, R.drawable.planet6),
    TITAN("Titan", 74, 47, TechLevel.Industrial, Resources.LOTSOFWATER, R.drawable.planet7),
    UMBERLEE("Umberlee", 103, 120, TechLevel.HiTech, Resources.RICHFAUNA, R.drawable.planet8),
    VAGRA("Vagra", 134, 21, TechLevel.Renaissance, Resources.LOTSOFHERBS, R.drawable.planet9),
    VENTAX("Ventax", 96, 11, TechLevel.Agriculture, Resources.WARLIKE, R.drawable.planet10);

    String name;
    TechLevel techLevel;
    Resources res;
    int x, y;
    ImageView imageView;
    int imagePath;

    SolarSystem(String name, int x, int y, TechLevel techLevel, Resources res, int imagePath) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.res = res;
    }
    SolarSystem(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = String.format(Locale.getDefault(),"Name: %s\nx: %d, y: %d\nTech Level: %s\nResources: %s\n", name, x, y, techLevel.toString(), res.toString());
        return s;
    }
}