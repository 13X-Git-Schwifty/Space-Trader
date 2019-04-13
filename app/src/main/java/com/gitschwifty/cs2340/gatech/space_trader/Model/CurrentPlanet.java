package com.gitschwifty.cs2340.gatech.space_trader.Model;


import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * CurrentPlanet
 */
@SuppressWarnings("ALL")
public class CurrentPlanet {
        public final String name;
        public final Coordinate c;
        public final TechLevel techLevel;
        private final Resources res;
        public final int imagePath;
        private int ordinal;
        private final List<SolarSystem> planets = Arrays.asList(SolarSystem.values());
        public final SolarSystem s;

    /**
     * @param ordinal tag
     */
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

    /**
     * @return ordinal
     */
    public int getOrdinal() {
        return ordinal;
    }

    /**
     * @return s
     */
    public SolarSystem getS() {
        return s;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
