package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.widget.ImageView;

import com.gitschwifty.cs2340.gatech.space_trader.R;

public class Planets {
    static String[] names;
    static TechLevel[] techLevels;
    static Resources[] ress;
    static int[] xs, ys;
    static int[] imagePaths;

    public Planets() {
        this.names = new String[]{"Acamar", "Bretel", "Lave", "Tamus", "Coron", "Utopia", "Titan","Umberlee", "Vagra", "Venta"};
        this.techLevels = new TechLevel[]{TechLevel.Agriculture, TechLevel.Medieval, TechLevel.Renaissance, TechLevel.PreAgriculture, TechLevel.HiTech, TechLevel.PostIndustrial, TechLevel.Industrial, TechLevel.HiTech, TechLevel.Renaissance,TechLevel.Agriculture};
        this.xs = new int[]{0, 10, 50, 100, 45, 92, 74, 103, 134, 96};
        this.ys = new int[]{0, 10, 50, 64, 32, 87, 47, 120, 21, 11};
        this.ress = new Resources[]{Resources.LIFELESS, Resources.DESERT, Resources.MINERALRICH, Resources.WEIRDMUSHROOMS, Resources.POORSOIL,Resources.LOTSOFWATER,Resources.RICHFAUNA, Resources.LOTSOFHERBS, Resources.WARLIKE};
        this.imagePaths = new int[]{R.drawable.planet1, R.drawable.planet2, R.drawable.planet3, R.drawable.planet4, R.drawable.planet5, R.drawable.planet6, R.drawable.planet7, R.drawable.planet8, R.drawable.planet9, R.drawable.planet10};
    }


}
