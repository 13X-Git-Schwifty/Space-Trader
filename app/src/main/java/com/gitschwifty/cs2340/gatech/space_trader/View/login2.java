package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.Difficulty;
import com.gitschwifty.cs2340.gatech.space_trader.Model.NewUser;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.ArrayList;
import java.util.List;

/**
 * login2
 */
@SuppressWarnings("ALL")
public class login2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static Player newPlayer;
    private String name;
    private String password;
    private int pilot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Intent intent = getIntent();
        name = intent.getStringExtra("Name");
        password = intent.getStringExtra("Password");
        List<Object> categories = new ArrayList<>();
        categories.add(Difficulty.BEGINNER);
        categories.add(Difficulty.EASY);
        categories.add(Difficulty.NORMAL);
        categories.add(Difficulty.HARD);
        categories.add(Difficulty.IMPOSSIBLE);
        // Spinner element
        Spinner spinner = findViewById(R.id.difficulty);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Creating adapter for spinner
        ArrayAdapter<Object> dataAdapter = new ArrayAdapter<>(this, android.R.layout.
                simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    /**
     * @param v tag
     */
    public void signup(View v) {
        EditText et = findViewById(R.id.pilot);
        EditText et1 = findViewById(R.id.fighter);
        EditText et2 = findViewById(R.id.trader);
        EditText et3 = findViewById(R.id.engineer);
        Spinner spinner = findViewById(R.id.difficulty);
        Difficulty diffLevel = Difficulty.valueOf(spinner.getSelectedItem().toString());
        String p = et.getText().toString();
        String f = et1.getText().toString();
        String t = et2.getText().toString();
        String e = et3.getText().toString();
        if (isEmpty(et) || isEmpty(et1) || isEmpty(et2) || isEmpty(et3)) {
            Toast.makeText(login2.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();
        } else {
             pilot = Integer.parseInt(p);
            int fighter = Integer.parseInt(f);
            int trader = Integer.parseInt(t);
            int engineer = Integer.parseInt(e);

            if ((pilot + fighter + trader + engineer) != 16) {
                Toast.makeText(login2.this, "Skill Distribution Error! Skills should" +
                        " add up to 16.", Toast.LENGTH_SHORT).show();
            } else {
                String random = java.util.UUID.randomUUID().toString();
                newPlayer = new Player(random, name, pilot, fighter, trader, engineer, diffLevel,
                        password);
                LoginActivity.setNewPlayer(newPlayer);
                NewUser newUser = new NewUser();
                newUser.writeNewUser(random, name, pilot, fighter, trader, engineer, diffLevel,
                        password, newPlayer.currentPlanet, newPlayer.currShip);
                Intent intent = new Intent(login2.this, Loader.class);
                intent.putExtra("extra", newPlayer.toString());
                startActivity(intent);
            }

        }
    }

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() <= 0;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        String item = "Beginner";
    }
}
