package com.gitschwifty.cs2340.gatech.space_trader.Model;


import android.widget.ImageView;

import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CurrentPlanet {
        public String name;
        public Coordinate c;
        public TechLevel techLevel;
        public Resources res;
        public int imagePath;
        public int ordinal;
        public List<SolarSystem> planets = Arrays.asList(SolarSystem.values());
        public SolarSystem s;
        public CurrentPlanet(int ordinal) {
            this.s = planets.get(ordinal);
            this.name = planets.get(ordinal).name;
            this.c = planets.get(ordinal).location;
            this.techLevel = planets.get(ordinal).techLevel;
            this.res = planets.get(ordinal).res;
            this.imagePath = planets.get(ordinal).imagePath;
        }
        CurrentPlanet() {
            this(new Random().nextInt(10));
        }
    public int getOrdinal() {
        return ordinal;
    }

    public SolarSystem getS() {
        return s;
    }

    @Override
    public String toString() {
        return name;
    }
}
