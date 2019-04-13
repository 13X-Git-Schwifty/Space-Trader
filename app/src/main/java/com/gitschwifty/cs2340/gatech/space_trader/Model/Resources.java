package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.annotation.NonNull;

/**
 * Resources
 */
public enum Resources {
    MINERALRICH("Mineral-Rich"),
    MINERALPOOR("Mineral-Poor"),
    DESERT("Desert"),
    LOTSOFWATER("Lots-of-Water"),
    RICHSOIL("Rich-Soil"),
    POORSOIL("Poor-Soil"),
    RICHFAUNA("Rich-Fauna"),
    LIFELESS("Lifeless"),
    WEIRDMUSHROOMS("Weird-Mushrooms"),
    LOTSOFHERBS("Lots-of-Herbs"),
    ARTISTIC("Artistic"),
    WARLIKE("Warlike");

    final String name;
    Resources(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
