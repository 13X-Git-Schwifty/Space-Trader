package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.Difficulty;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD

public class

LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
=======
//implements AdapterView.OnItemSelectedListener
public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
>>>>>>> 12c54b566a2e666799ce053f2565c28c7916c4fb

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//             Spinner Drop down elements
        List<Object> categories = new ArrayList<Object>();
        categories.add(Difficulty.BEGINNER);
        categories.add(Difficulty.EASY);
        categories.add(Difficulty.NORMAL);
        categories.add(Difficulty.HARD);
        categories.add(Difficulty.IMPOSSIBLE);
        setContentView(R.layout.activity_login);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.difficulty);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Creating adapter for spinner
        ArrayAdapter<Object> dataAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        String item = "Beginner";
    }
    public void start(View v) {
        EditText contactName = (EditText) findViewById(R.id.input_name);
        String name = contactName.getText().toString();
        if (isEmpty(contactName)) {
            Toast.makeText(LoginActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();

        } else {
            EditText et = (EditText) findViewById(R.id.pilot);
            EditText et1 = (EditText) findViewById(R.id.fighter);
            EditText et2 = (EditText) findViewById(R.id.trader);
            EditText et3 = (EditText) findViewById(R.id.engineer);
            Spinner spinner = (Spinner) findViewById(R.id.difficulty);
            Difficulty diffLevel = Difficulty.valueOf(spinner.getSelectedItem().toString());
            String p = et.getText().toString();
            String f = et1.getText().toString();
            String t = et2.getText().toString();
            String e = et3.getText().toString();
            if (isEmpty(et) || isEmpty(et1) || isEmpty(et2) || isEmpty(et3)) {
                Toast.makeText(LoginActivity.this, "Fields Not Complete", Toast.LENGTH_SHORT).show();
            } else {
                int pilot = Integer.parseInt(p);
                int fighter = Integer.parseInt(f);
                int trader = Integer.parseInt(t);
                int engineer = Integer.parseInt(e);

                if (pilot + fighter + trader + engineer != 16) {
                    Toast.makeText(LoginActivity.this, "Skill Distribution Error!", Toast.LENGTH_SHORT).show();
                } else {
                    Player newPlayer = new Player(name, pilot, fighter, trader, engineer, diffLevel);
                    Toast.makeText(LoginActivity.this, newPlayer.toString(), Toast.LENGTH_LONG).show();
                    finishAndRemoveTask();
                }

            }

        }

    }
    private boolean isEmpty(EditText etText) {
        if (etText.getText().toString().trim().length() > 0)
            return false;

        return true;
    }
}