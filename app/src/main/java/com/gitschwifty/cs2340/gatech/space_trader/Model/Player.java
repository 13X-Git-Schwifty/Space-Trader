package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.support.annotation.NonNull;
import android.util.Log;

import com.gitschwifty.cs2340.gatech.space_trader.View.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class Player {
    public String playerName;
    public int skillPilot;
    public int skillFighter;
    public int skillEngineer;
    public int skillTrader;
    public Difficulty diffLevel;
    public static int creditScore;
    public Ship currShip;
    public int totalPoints;
    public CurrentPlanet currentPlanet;
    public String password;
    public String uid;

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
    @Override
    public String toString() {
        return String.format("Player %s has been created! Your skills are:\n" +
                        "Pilot: %d\nFighter: %d \nTrader: %d\nEngineer: %d\n" +
                        "Difficulty Level:  %s\nCredits: %d\nShip: %s", this.getName(),
                this.getSkillPilot(), this.getSkillFighter(), this.getSkillTrader(), this.getSkillEngineer(),
                this.getDiffLevel().getReturnDifficulty(), this.getCreditScore(), this.getSpaceship().getShipType().getName());

    }

    public CurrentPlanet getCurrPlanet() {
        return currentPlanet;
    }

    public void setCurrPlanet(CurrentPlanet currPlanet) {
        this.currentPlanet = currPlanet;
    }
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
        return playerName;
    }

    public Difficulty getDiffLevel() {
        return diffLevel;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public Ship getSpaceship() {
        return currShip;
    }

    //    public void setCargoSpace(int cargoSpace) {
//        this.cargoSpace = cargoSpace;
//    }
    public String getUID() {
        return uid;
    }

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

    public void setUid(String uid) {
        this.uid = uid;
    }
}
