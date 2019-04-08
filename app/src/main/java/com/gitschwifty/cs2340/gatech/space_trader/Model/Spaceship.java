package com.gitschwifty.cs2340.gatech.space_trader.Model;

public enum Spaceship {
    FLEA("Flea",100,20,100,8,0,0,0,2000,0),
    GNAT("Gnat",30,14,250,15,1,0,1,5000,0),
    FIREFLY("Firefly",80,17,250,20,1,1,1,7500,0),
    MOSQUITO("Mosquito",100,13,500,15,2,1,1,12000,0),
    BUMBLEBEE("Bumblebee",100,15,250,20,1,2,2,15000,1),
    BEETLE("Beetle",120,14,100,50,0,1,1,15000,3),
    HORNET("Hornet",120,16,500,20,3,2,1,25000,2),
    GRASSHOPPER("Grasshopper",120,15,400,30,2,2,3,30000,3),
    TERMITE("Termite",150,13,800,60,1,3,2,45000,3),
    WASP("Wasp",150,14,800,35,3,2,2,55000,3);


    //name of ship, the total fuel capacity,
    // distance that can be travelled on full tank,
    // max health of ship, max cargo storage of ship, max weapons slot of ship,
    // max shields slot of ship, max gadgets slot of ship, cost of ship
    Spaceship(String name, int fuelcapacity, int fueldist, int health,
              int maxcargo, int maxweaponsslot, int maxshieldslot,
              int maxgadgetslot, int price, int maxcrewquarters) {
        this.name = name;
        this.fuelcapacity = fuelcapacity;
        this.fueldistance = fueldist;
        this.health = health;
        this.maxcargo = maxcargo;
        this.maxweapons = maxweaponsslot;
        this.maxshields = maxshieldslot;
        this.maxgadgets = maxgadgetslot;
        this.price = price;
        this.maxcrew = maxcrewquarters;

    }
    Spaceship() {this.name = name;}

    public String name;
    private int fuelcapacity;
    private int fueldistance;
    private int health;
    private int maxcargo;
    private int maxweapons;
    private int maxshields;
    private int maxgadgets;
    private int price;
    private int maxcrew;

    public int getFuelcapacity() {
        return fuelcapacity;
    }

    public int getFueldistance() {
        return fueldistance;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxcargo() {
        return maxcargo;
    }

    public int getMaxgadgets() {
        return maxgadgets;
    }

    public int getMaxshields() {
        return maxshields;
    }

    public int getMaxweapons() {
        return maxweapons;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxcrew() {
        return maxcrew;
    }

    public String getName() {
        return name;
    }
//name, fuelcapacity, fueldistance, health, maxcargo, maxweapons, maxshields, maxgadgets, price
}