package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gitschwifty.cs2340.gatech.space_trader.Model.CurrentPlanet;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Player;
import com.gitschwifty.cs2340.gatech.space_trader.R;

/**
 * CurrentPlanetActivity
 */
public class CurrentPlanetActivity extends AppCompatActivity {
    static CurrentPlanet currentPlanet;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_planet);
        Log.d("mptest", "curr plan started");

//        currentPlanet = new CurrentPlanet(0);
        final Player p = LoginActivity.getNewPlayer();
        ImageView imageView = findViewById(R.id.currPlanetIV);
        int a = p.getCurrPlanet().imagePath;
        imageView.setImageResource(a);

        TextView nameTV = findViewById(R.id.planetName);
        String an = "Welcome to " + p.getCurrPlanet().name;
        nameTV.setText(an);

        TextView infoTV = findViewById(R.id.planetInfo);
        String ban = "X: "+ p.getCurrPlanet().c.getX() + "Y: " + p.getCurrPlanet().c.getY();
        infoTV.setText(ban);

        TextView fuel = findViewById(R.id.fuel);
        fuel.setText("Fuel Left: " + p.getSpaceship().getCurrFuel());

        TextView credit = findViewById(R.id.creditScoreDisplay);
        credit.setText("Credit Points: "+ p.getCreditScore());
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("players");
//        Query reference = ref.child(p.getUID()).orderByChild("goods");
//        reference.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                GoodsList good = dataSnapshot.getValue(GoodsList.class);
//                p.getPlayerGoods().add(good);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//                GoodsList good = dataSnapshot.getValue(GoodsList.class);
//                p.getPlayerGoods().remove(good);
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
    }

    /**
     * @param v tag
     */
    public void universe1(View v) {
        Intent intent = new Intent(CurrentPlanetActivity.this, SolarSystemActivity.class);
        startActivity(intent);
        finishAndRemoveTask();
    }

    /**
     * @param v tag
     */
    public void goToMarket(View v) {
        Intent intent = new Intent(CurrentPlanetActivity.this, MarketPlace.class);
        startActivity(intent);
        finishAndRemoveTask();
    }
}
