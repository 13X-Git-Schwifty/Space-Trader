package com.gitschwifty.cs2340.gatech.space_trader.Model;

public enum Spaceship {
    FLEA("Flea"),
    GNAT("Gnat"),
    FIREFLY("Firefly"),
    MOSQUITO("Mosquito"),
    BUMBLEBEE("Bumblebee"),
    BEETLE("Beetle"),
    HORNET("Hornet"),
    GRASSHOPPER("Grasshopper"),
    TERMITE("Termite"),
    WASP("Wasp");

    Spaceship(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}
