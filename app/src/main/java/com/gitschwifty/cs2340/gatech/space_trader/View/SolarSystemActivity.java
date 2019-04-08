package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.SolarSystem;
import com.gitschwifty.cs2340.gatech.space_trader.R;
import com.gitschwifty.cs2340.gatech.space_trader.ViewModel.MyAdapter;

import java.util.List;

public class SolarSystemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solar_system);
//        for (int i = 0; i < 10; i ++) {
//            TextView et = null;
//            switch (i) {
//                case 0: et = (TextView) findViewById(R.id.p1); break;
//                case 1: et = (TextView) findViewById(R.id.p2); break;
//                case 2: et = (TextView) findViewById(R.id.p3); break;
//                case 3: et = (TextView) findViewById(R.id.p4); break;
//                case 4: et = (TextView) findViewById(R.id.p5); break;
//                case 5: et = (TextView) findViewById(R.id.p6); break;
//                case 6: et = (TextView) findViewById(R.id.p7); break;
//                case 7: et = (TextView) findViewById(R.id.p8); break;
//                case 8: et = (TextView) findViewById(R.id.p9); break;
//                case 9: et = (TextView) findViewById(R.id.p10); break;
//            }
//            et.setText(ss[i].toString());
//        }
        RecyclerView rv = (RecyclerView)findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        RecyclerView.Adapter mAdapter = new MyAdapter(LoginActivity.getNewPlayer().currShip.findAccessibleSystems());
        rv.setAdapter(mAdapter);
    }

    public Context getCont() {
        return this;
    }
    public void back(View v) {
        startActivity(new Intent(SolarSystemActivity.this, CurrentPlanetActivity.class));
        finishAndRemoveTask();
    }

    public void makeToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
