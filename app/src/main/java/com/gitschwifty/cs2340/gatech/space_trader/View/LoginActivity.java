package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Difficulty;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Ship;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

/**
 * LoginActivity
 */
//implements AdapterView.OnItemSelectedListener
@SuppressWarnings("ALL")
public class LoginActivity extends AppCompatActivity {
    private static Player newPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }

    /**
     * @param v tag
     */
    public void start(View v) {
        EditText contactName = findViewById(R.id.input_name);
        final String name = contactName.getText().toString();
        EditText password = findViewById(R.id.password);
        final String pass = password.getText().toString();
        if (isEmpty(contactName) || isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();

        } else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
//            Query playerName = ref.orderByChild("playerName");
            final boolean[] flag = {false};
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // dataSnapshot is the "issue" node with all children with id 0
                        for (DataSnapshot issue : dataSnapshot.getChildren()) {
//                            try {
//                                Player player = issue.getValue(Player.class);
//
//                                if (player.password.equals(pass)) {
//                                    newPlayer = player;
//                 Toast.makeText(LoginActivity.this, "EXISTS", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, Loader.class);
//                                    startActivity(intent);
//                                } else {
//                Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, login2.class);
//                                    intent.putExtra("Name", name);
//                                    intent.putExtra("Password", pass);
//                                    startActivity(intent);
//                                }
//                            } catch (NullPointerException e) {
//          Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(LoginActivity.this, login2.class);
//                                intent.putExtra("Name", name);
//                                intent.putExtra("Password", pass);
//                                startActivity(intent);
//                            }
                            String childName = Objects.
                                    requireNonNull(issue.child("playerName").getValue()).toString();
                            String childPass = Objects.requireNonNull(issue.child("password")
                                    .getValue()).toString();
                            Player player = issue.getValue(Player.class);
                            int skillP = Integer.parseInt(Objects.requireNonNull
                                    (issue.child("skillPilot").getValue()).toString());
                            int skillF = Integer.parseInt(Objects.requireNonNull
                                    (issue.child("skillFighter").getValue()).toString());
                            int skillT= Integer.parseInt(Objects.requireNonNull
                                    (issue.child("skillTrader").getValue()).toString());
                            int skillE = Integer.parseInt(Objects.requireNonNull
                                    (issue.child("skillEngineer").getValue()).toString());
                            if (childName.equals(name) && childPass.equals(pass)) {
                                flag[0] = true;
                                newPlayer = new Player(Objects.requireNonNull
                                        (issue.child("uid").getValue()).toString(), name, skillP,
                                        skillF, skillT, skillE, Difficulty.valueOf(Objects.requireNonNull(issue.child("diffLevel").getValue()).toString()),pass, issue.child("currentPlanet").getValue(CurrentPlanet.class), issue.child("currShip").getValue(Ship.class));
                                Toast.makeText(LoginActivity.this, "EXISTS",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, Loader.class);
                                startActivity(intent);
                            }
                        }
                        if (!flag[0]) {
                            Toast.makeText(LoginActivity.this, "DOES NOT EXIST",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, login2.class);
                            intent.putExtra("Name", name);
                            intent.putExtra("Password", pass);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "DOES NOT EXIST",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, login2.class);
                        intent.putExtra("Name", name);
                        intent.putExtra("Password", pass);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                }
            });

        }
    }

    /**
     * @return newPlayer
     */
    public static Player getNewPlayer() {
        return newPlayer;
    }

    /**
     * @param newPlayer tag
     */
    public static void setNewPlayer(Player newPlayer) {
        LoginActivity.newPlayer = newPlayer;
    }

    /**
     * @param v tag
     */
    public void end(View v) {
        finishAndRemoveTask();
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }
}