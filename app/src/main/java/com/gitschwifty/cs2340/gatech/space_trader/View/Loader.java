package com.gitschwifty.cs2340.gatech.space_trader.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gitschwifty.cs2340.gatech.space_trader.R;

/**
 * Loader
 */
@SuppressWarnings("ALL")
public class Loader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        Thread sleep=new Thread(){
            @Override
            @SuppressWarnings("MagicNumber")
            public void run()
            {
                try{
                    Thread.sleep(7050);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent=new Intent(Loader.this, CurrentPlanetActivity.class);
                    intent.putExtra("extra", getIntent().getStringExtra("extra"));
                    startActivity(intent);
                    finish();
                }
            }
        };
        sleep.start();
    }
}

