package com.gitschwifty.cs2340.gatech.space_trader.Model

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class NewUser {
    private lateinit var database: DatabaseReference

    public fun writeNewUser(name: String, pilot: Int, fighter: Int, trader: Int, engineer: Int, difficulty: Difficulty) {
        database = FirebaseDatabase.getInstance().reference
        val user = Player(name, pilot, fighter, trader, engineer, difficulty)
        database.child("players").setValue(user)
    }

}
