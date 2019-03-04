package com.gitschwifty.cs2340.gatech.space_trader.Model;

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

    String name;
    Resources(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
