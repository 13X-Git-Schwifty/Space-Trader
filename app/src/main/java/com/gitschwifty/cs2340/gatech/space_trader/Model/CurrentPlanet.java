package com.gitschwifty.cs2340.gatech.space_trader.Model;


import android.widget.ImageView;

import com.gitschwifty.cs2340.gatech.space_trader.R;

public class CurrentPlanet {
        public String name;
        public int x;
        public int y;
        public TechLevel techLevel;
        public Resources res;
        public int imagePath;
        public int ordinal;
        Planets p = new Planets();

        public CurrentPlanet(int ordinal) {

            this.name = p.names[ordinal];
            this.x = p.xs[ordinal];
            this.y = p.ys[ordinal];
            this.techLevel = p.techLevels[ordinal];
            this.res = p.ress[ordinal];
            this.imagePath = p.imagePaths[ordinal];

        }
}
