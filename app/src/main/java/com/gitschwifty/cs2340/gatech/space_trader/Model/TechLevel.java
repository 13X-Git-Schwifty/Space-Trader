package com.gitschwifty.cs2340.gatech.space_trader.Model;
//import java.util.Random;

public enum TechLevel {
    PRE_AGRICULTURE(0),
    AGRICULTURE(1),
    MEDIEVAL(2),
    RENAISSANCE(3),
    EARLY_INDUSTRIAL(4),
    INDUSTRIAL(5),
    POST_INDUSTRIAL(6),
    HI_TECH(7);

    private int id;
    //private static Random rand = new Random();

    TechLevel(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
