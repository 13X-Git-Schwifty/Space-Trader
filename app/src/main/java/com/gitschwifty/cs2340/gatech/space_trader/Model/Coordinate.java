package com.gitschwifty.cs2340.gatech.space_trader.Model;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;

/**
 * Coordinate
 */
public class Coordinate {

    private int x;
    private int y;

    /**
     * @return getX
     */
    public int getX() {
        return x;
    }

    /**
     * @return getY
     */
    public int getY() {
        return y;
    }

    /**
     * @param x tag
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y tag
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param x tag
     * @param y tag
     */
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Coordinate
     */
    public Coordinate() { }

    /**
     * @param c1 tag
     * @param c2 tag
     * @return distance
     */
    public static int distance(Coordinate c1, Coordinate c2) {
        return (int) Math.hypot(c1.getX() - c2.getX(), c1.getY() - c2.getY());
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public String toString() {
        return String.format("%d, %d", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Coordinate)) {
            return false;
        } else {
            Coordinate other = (Coordinate) obj;
            return (other.x == this.x) && (other.y == this.y);
        }
    }
}
