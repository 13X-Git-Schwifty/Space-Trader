package com.gitschwifty.cs2340.gatech.space_trader.Model;

public enum SolarSystem {
    ACAMAR("Acamar",0, 0, TechLevel.Agriculture, Resources.LIFELESS),
    BRETEL("Bretel",10, 10, TechLevel.Medieval, Resources.DESERT),
    LAVE("Lave", 50, 50, TechLevel.Renaissance, Resources.MINERALRICH),
    TAMUS("Tamus", 100, 64, TechLevel.PreAgriculture, Resources.WEIRDMUSHROOMS),
    CORON("Coron", 45, 32, TechLevel.HiTech, Resources.POORSOIL),
    UTOPIA("Utopia", 92, 87, TechLevel.PostIndustrial, Resources.ARTISTIC),
    TITAN("Titan", 74, 47, TechLevel.Industrial, Resources.LOTSOFWATER),
    UMBERLEE("Umberlee", 103, 120, TechLevel.HiTech, Resources.RICHFAUNA),
    VAGRA("Vagra", 134, 21, TechLevel.Renaissance, Resources.LOTSOFHERBS),
    VENTAX("Ventax", 96, 11, TechLevel.Agriculture, Resources.WARLIKE);

    String name;
    TechLevel techLevel;
    Resources res;
    int x, y;

    SolarSystem(String name, int x, int y, TechLevel techLevel, Resources res) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.techLevel = techLevel;
        this.res = res;
    }

    @Override
    public String toString() {
        String s = String.format("Name: %s\nx: %d, y: %d\nTechlevel: %s\nResources: %s\n", name, x, y, techLevel.toString(), res.toString());
        return s;
    }
}