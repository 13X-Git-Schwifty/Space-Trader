package com.gitschwifty.cs2340.gatech.space_trader.Model;

/**
 * Spaceship
 */
@SuppressWarnings("ALL")
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
    Spaceship(String name, int fuelCapacity, int fuelDist, int health,
              int maxCargo, int maxWeaponsSlot, int maxShieldSlot,
              int maxGadgetSlot, int price, int maxCrewQuarters) {
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.fuelDistance = fuelDist;
        this.health = health;
        this.maxCargo = maxCargo;
        this.maxShields = maxShieldSlot;
        this.maxGadgets = maxGadgetSlot;
        this.price = price;
        this.maxCrew = maxCrewQuarters;

    }
    Spaceship() {this.name = name;}

    private String name;
    private int fuelCapacity;
    private int fuelDistance;
    private int health;
    private int maxCargo;
    private int maxWeapons;
    private int maxShields;
    private int maxGadgets;
    private int price;
    private int maxCrew;

    /**
     * @return getFuelCapacity
     */
    public int getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * @return getFuelDistance
     */
    public int getFuelDistance() {
        return fuelDistance;
    }

    /**
     * @return getHealth
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return getMaxCargo
     */
    public int getMaxCargo() {
        return maxCargo;
    }

    /**
     * @return getMaxGadgets
     */
    public int getMaxGadgets() {
        return maxGadgets;
    }

    /**
     * @return getMaxShields
     */
    public int getMaxShields() {
        return maxShields;
    }

    /**
     * @return getMaxWeapons
     */
    public int getMaxWeapons() {
        return maxWeapons;
    }

    /**
     * @return getPrice
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price tag
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return maxCrew
     */
    public int getMaxCrew() {
        return maxCrew;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }
//name, fuelcapacity, fueldistance, health, maxcargo, maxweapons, maxshields, maxgadgets, price
}