package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Difficulty;
import com.gitschwifty.cs2340.gatech.space_trader.Model.NewUser;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Ship;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
//implements AdapterView.OnItemSelectedListener
public class LoginActivity extends AppCompatActivity {
    public static Player newPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
    public void start(View v) {
        EditText contactName = (EditText) findViewById(R.id.input_name);
        final String name = contactName.getText().toString();
        EditText password = (EditText) findViewById(R.id.password);
        final String pass = password.getText().toString();
        if (isEmpty(contactName) || isEmpty(password)) {
            Toast.makeText(LoginActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();

        } else {
            DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
//            Query playerName = ref.orderByChild("playerName");
            final boolean[] flag = {false};
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        // dataSnapshot is the "issue" node with all children with id 0
                        for (DataSnapshot issue : dataSnapshot.getChildren()) {
//                            try {
//                                Player player = issue.getValue(Player.class);
//
//                                if (player.password.equals(pass)) {
//                                    newPlayer = player;
//                                    Toast.makeText(LoginActivity.this, "EXISTS", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, Loader.class);
//                                    startActivity(intent);
//                                } else {
//                                    Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, login2.class);
//                                    intent.putExtra("Name", name);
//                                    intent.putExtra("Password", pass);
//                                    startActivity(intent);
//                                }
//                            } catch (NullPointerException e) {
//                                Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(LoginActivity.this, login2.class);
//                                intent.putExtra("Name", name);
//                                intent.putExtra("Password", pass);
//                                startActivity(intent);
//                            }
                            String childName = issue.child("playerName").getValue().toString();
                            String childPass = issue.child("password").getValue().toString();
                            Player player = issue.getValue(Player.class);
                            int skillP = Integer.parseInt(issue.child("skillPilot").getValue().toString());
                            int skillF = Integer.parseInt(issue.child("skillFighter").getValue().toString());
                            int skillT= Integer.parseInt(issue.child("skillTrader").getValue().toString());
                            int skillE = Integer.parseInt(issue.child("skillEngineer").getValue().toString());
                            if (childName.equals(name) && childPass.equals(pass)) {
                                flag[0] = true;
                                newPlayer = new Player(issue.child("uid").getValue().toString(), name, skillP, skillF, skillT, skillE, Difficulty.valueOf(issue.child("diffLevel").getValue().toString()),pass, issue.child("currentPlanet").getValue(CurrentPlanet.class), issue.child("currShip").getValue(Ship.class));
                                Toast.makeText(LoginActivity.this, "EXISTS", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, Loader.class);
                                startActivity(intent);
                            }
                        }
                        if (!flag[0]) {
                            Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, login2.class);
                            intent.putExtra("Name", name);
                            intent.putExtra("Password", pass);
                            startActivity(intent);
                        }
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "DOES NOT EXIST", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, login2.class);
                        intent.putExtra("Name", name);
                        intent.putExtra("Password", pass);
                        startActivity(intent);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });

        }
    }

    public static Player getNewPlayer() {
        return newPlayer;
    }

    public static void setNewPlayer(Player newPlayer) {
        LoginActivity.newPlayer = newPlayer;
    }

    public void end(View v) {
        finishAndRemoveTask();
    }

    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}