package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.Difficulty;
import com.gitschwifty.cs2340.gatech.space_trader.R;

import java.util.ArrayList;
import java.util.List;

public class

LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            // Spinner Drop down elements
            List<String> categories = new ArrayList<String>();
            categories.add("Beginner");
            categories.add("Easy");
            categories.add("Normal");
            categories.add("Hard");
            categories.add("Impossible");
        setContentView(R.layout.activity_login);
        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.difficulty);
        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        String item = "Beginner";
        Toast.makeText(arg0.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
}