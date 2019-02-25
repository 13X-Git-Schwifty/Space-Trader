package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.util.Log;

public class Player {
    private String name;
    private int skillPilot;
    private int skillFighter;
    private int skillEngineer;
    private int skillTrader;
    private Difficulty diffLevel;
    private int creditScore;
    private Spaceship currShip;


    public int getSkillPilot() {
        return skillPilot;
    }

    public int getSkillFighter() {
        return skillFighter;
    }

    public int getSkillTrader() {
        return skillTrader;
    }

    public int getSkillEngineer() {
        return skillEngineer;
    }

    public String getName() {
        return name;
    }

    public Difficulty getDiffLevel() {
        return diffLevel;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public Spaceship getSpaceship() {
        return currShip;
    }

    public Player(String name, int skillPilot, int skillFighter, int skillTrader, int skillEngineer, Difficulty diffLevel) {
        this.name = name;
        this.skillPilot = skillPilot;
        this.skillEngineer = skillEngineer;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.diffLevel = diffLevel;
        this.creditScore = 1000;
        this.currShip = Spaceship.GNAT;
<<<<<<< HEAD
        Log.i(this.toString(), "Player created");
=======
        Log.i("Player created", this.toString());
>>>>>>> 12c54b566a2e666799ce053f2565c28c7916c4fb
    }

    @Override
    public String toString() {
<<<<<<< HEAD
    return String.format("Player %s has been created! Your skills are: \n" +
                "Pilot: %d\n Fighter: %d \n Trader: %d\n Engineer: %d\n" +
                "Your difficulty level is %s and you have %d credits.", this.getName(),
=======
        return String.format("Player %s has been created! Your skills are: \n" +
                        "Pilot: %d\n Fighter: %d \n Trader: %d\n Engineer: %d\n" +
                        "Your difficulty level is %s and you have %d credits.", this.getName(),
>>>>>>> 12c54b566a2e666799ce053f2565c28c7916c4fb
                this.getSkillPilot(), this.getSkillFighter(), this.getSkillTrader(), this.getSkillEngineer(),
                this.getDiffLevel().getReturnDifficulty(), this.getCreditScore(), this.getSpaceship().getName());

    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 12c54b566a2e666799ce053f2565c28c7916c4fb
