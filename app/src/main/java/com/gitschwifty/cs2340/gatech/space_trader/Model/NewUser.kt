package com.gitschwifty.cs2340.gatech.space_trader.Model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class NewUser {
    private lateinit var database: DatabaseReference

    fun writeNewUser(random: String, name: String, pilot: Int, fighter: Int,
                     trader: Int, engineer: Int, difficulty: Difficulty, password: String,
                     currentPlanet: CurrentPlanet, currShip: Ship) {
        database = FirebaseDatabase.getInstance().reference
        val user = Player(random, name, pilot, fighter, trader, engineer, difficulty, password,
                currentPlanet, currShip)
        database.child("players").child(random).setValue(user)
        database.child("players").child(random).child("goods").setValue(null)
    }
}
