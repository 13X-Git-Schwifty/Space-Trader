package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Random;

/**
 * RandomEvent
 */
public enum RandomEvent {
PIRATE_ATTACK(0,new Random(), "Pirates attacking!"),
     POLICE_CHECK(1, new Random(), "Police arrives to check cargo"),
     DROUGHT(2, new Random(), "Planet drought! Market has been affected!"),
     RIOTS(3, new Random(), "Riots against government! Market affected"),
    BONUS(4, new Random(), "Bounty found! Gained credit"),
    CARGO_LOST(5, new Random(), "Goods spoilt in cargo."),
    WARPED(6, new Random(), "Ship crashed on different planet");

    private final int id;
    private final Random rand;
    private final String eventName;

    RandomEvent(int id, Random rand, String event) {
        this.id = id;
        this.rand = rand;
        this.eventName = event;

    }

    @NonNull
    @Override
    public String toString() {
        return getEventName();
    }

    /**
     * @return getId
     */
    public int getId() {
        return id;
    }

    /**
     * @return getRand
     */
    public Random getRand() {
        return rand;
    }

    private String getEventName() {
        return eventName;
    }

    /**
     * @return eventGen
     */
    public static RandomEvent eventGen() {
        Random rand = new Random();
        int ordinal = rand.nextInt(5);
        @Nullable RandomEvent re;
        switch(ordinal) {
//            case 0: re = RandomEvent.PIRATE_ATTACK;
//                break;
//            case 1: re = RandomEvent.POLICE_CHECK;
//                break;
//            case 2: re = RandomEvent.DROUGHT;
//                break;
//            case 3: re = RandomEvent.RIOTS;
//                break;
            case 0: re = RandomEvent.BONUS;
                break;
            case 1: re = RandomEvent.WARPED;
                break;
            default: re = null;
                break;
        }
        return re;
    }

}
