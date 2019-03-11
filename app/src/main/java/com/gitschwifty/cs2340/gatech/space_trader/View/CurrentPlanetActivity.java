package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.SolarSystem;
import com.gitschwifty.cs2340.gatech.space_trader.R;

public class CurrentPlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_planet);

        CurrentPlanet currentPlanet = new CurrentPlanet(0);

        ImageView imageView = findViewById(R.id.currPlanetIV);
        imageView.setImageResource(currentPlanet.imagePath);

        TextView nameTV = findViewById(R.id.planetName);
        nameTV.setText("Welcome to " + currentPlanet.name);

        TextView infoTV = findViewById(R.id.planetInfo);
        infoTV.setText(SolarSystem.values()[currentPlanet.ordinal].toString());
    }
    public void universe1(View v) {
        Intent intent = new Intent(CurrentPlanetActivity.this, SolarSystemActivity.class);
        startActivity(intent);
    }
}
