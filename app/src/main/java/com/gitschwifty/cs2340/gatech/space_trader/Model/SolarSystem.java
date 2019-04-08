package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.widget.ImageView;

import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.Locale;

public enum SolarSystem {
    ACAMAR("Acamar", new Coordinate(0,0), TechLevel.AGRICULTURE, Resources.LIFELESS, R.drawable.planet1),
    BRETEL("Bretel", new Coordinate(10,10), TechLevel.MEDIEVAL, Resources.DESERT, R.drawable.planet2),
    LAVE("Lave", new Coordinate(50,50), TechLevel.RENAISSANCE, Resources.MINERALRICH, R.drawable.planet3),
    TAMUS("Tamus", new Coordinate(100, 64), TechLevel.PRE_AGRICULTURE, Resources.WEIRDMUSHROOMS, R.drawable.planet4),
    CORON("Coron", new Coordinate(45,32), TechLevel.HI_TECH, Resources.POORSOIL, R.drawable.planet5),
    UTOPIA("Utopia", new Coordinate(92, 87), TechLevel.POST_INDUSTRIAL, Resources.ARTISTIC, R.drawable.planet6),
    TITAN("Titan", new Coordinate(74, 47), TechLevel.INDUSTRIAL, Resources.LOTSOFWATER, R.drawable.planet7),
    UMBERLEE("Umberlee", new Coordinate(103, 120), TechLevel.HI_TECH, Resources.RICHFAUNA, R.drawable.planet8),
    VAGRA("Vagra", new Coordinate(134, 21), TechLevel.RENAISSANCE, Resources.LOTSOFHERBS, R.drawable.planet9),
    VENTAX("Ventax", new Coordinate(96, 11), TechLevel.AGRICULTURE, Resources.WARLIKE, R.drawable.planet10);

    public String name;
    public TechLevel techLevel;
    public Resources res;
    public Coordinate location;
    public ImageView imageView;
    public int imagePath;

    SolarSystem(String name, Coordinate location, TechLevel techLevel, Resources res, int imagePath) {
        this.name = name;
        this.location = location;
        this.techLevel = techLevel;
        this.res = res;
        this.imagePath = imagePath;
    }
    SolarSystem(String name) {
        this.name = name;
    }
    SolarSystem() {
    }
    @Override
    public String toString() {
        String s = String.format(Locale.getDefault(),"Name: %s\nLocation: %s\nTech Level: %s\nResources: %s\n", name, location.toString() ,techLevel.toString(), res.toString());
        return s;
    }

}