package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.annotation.SuppressLint;
import android.util.Log;

import java.util.Random;

/**
 * Player
 */
@SuppressWarnings("ALL")
public class Player {
    private String playerName;
    private int skillPilot;
    private int skillFighter;
    private int skillEngineer;
    private int skillTrader;
    private Difficulty diffLevel;
    private static int creditScore;
    public Ship currShip;
    public int totalPoints;
    public CurrentPlanet currentPlanet;
    private String password;
    private String uid;

    /**
     * @param uid
     * @param name
     * @param skillPilot
     * @param skillFighter
     * @param skillTrader
     * @param skillEngineer
     * @param diffLevel
     * @param password
     */
    public Player(String uid, String name, int skillPilot, int skillFighter, int skillTrader, int skillEngineer, Difficulty diffLevel, String password) {
        this.playerName = name;
        this.skillPilot = skillPilot;
        this.skillEngineer = skillEngineer;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.diffLevel = diffLevel;
        this.creditScore = 1000;
        this.currentPlanet = new CurrentPlanet(new Random().nextInt(10));
        this.currShip = new Ship(Spaceship.GNAT, currentPlanet.s);
        Log.i("Player created", this.toString());
        this.password = password;
        this.uid = uid;
    }

    /**
     * @param uid
     * @param name
     * @param skillPilot
     * @param skillFighter
     * @param skillTrader
     * @param skillEngineer
     * @param diffLevel
     * @param password
     * @param planet
     * @param currShip
     */
    public Player(String uid, String name, int skillPilot, int skillFighter, int skillTrader, int skillEngineer, Difficulty diffLevel, String password, CurrentPlanet planet, Ship currShip) {
        this.playerName = name;
        this.skillPilot = skillPilot;
        this.skillEngineer = skillEngineer;
        this.skillFighter = skillFighter;
        this.skillTrader = skillTrader;
        this.diffLevel = diffLevel;
        this.creditScore = 1000;
        this.currentPlanet = planet;
        this.currShip = new Ship(Spaceship.GNAT, currentPlanet.s);
        Log.i("Player created", this.toString());
        this.password = password;
        this.uid = uid;
        this.currShip = currShip;
    }
    Player() {

    }
    @SuppressLint("DefaultLocale")
    @Override
    public String toString() {
        return String.format("Player %s has been created! Your skills are:\n" +
                        "Pilot: %d\nFighter: %d \nTrader: %d\nEngineer: %d\n" +
                        "Difficulty Level:  %s\nCredits: %d\nShip: %s", this.getName(),
                this.getSkillPilot(), this.getSkillFighter(), this.getSkillTrader(), this.getSkillEngineer(),
                this.getDiffLevel().getReturnDifficulty(), this.getCreditScore(), this.getSpaceship().getShipType().getName());

    }

    /**
     * @return currentPlanet
     */
    public CurrentPlanet getCurrPlanet() {
        return currentPlanet;
    }

    /**
     * @param currPlanet
     */
    public void setCurrPlanet(CurrentPlanet currPlanet) {
        this.currentPlanet = currPlanet;
    }
    private int getSkillPilot() {
        return skillPilot;
    }

    private int getSkillFighter() {
        return skillFighter;
    }

    private int getSkillTrader() {
        return skillTrader;
    }

    private int getSkillEngineer() {
        return skillEngineer;
    }

    private String getName() {
        return playerName;
    }

    private Difficulty getDiffLevel() {
        return diffLevel;
    }

    /**
     * @return creditScore
     */
    public int getCreditScore() {
        return creditScore;
    }

    /**
     * @return getSpaceship
     */
    public Ship getSpaceship() {
        return currShip;
    }

    /**
     * @return getUID
     */
    //    public void setCargoSpace(int cargoSpace) {
//        this.cargoSpace = cargoSpace;
//    }
    public String getUID() {
        return uid;
    }

    /**
     * @param creditScore
     */
    public void setCreditScore(final int creditScore) {
        this.creditScore = creditScore;
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
//        Query credit = ref.orderByChild("creditScore");
//        credit.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                dataSnapshot.child(LoginActivity.getNewPlayer().getUID()).child("creditScore").getRef().setValue(creditScore);
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
}
