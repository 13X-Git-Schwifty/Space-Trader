package com.gitschwifty.cs2340.gatech.space_trader.Model;

public class Coordinate {

    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Coordinate() { }

    public static int distance(Coordinate c1, Coordinate c2) {
        return (int) Math.hypot(c1.getX() - c2.getX(), c1.getY() - c2.getY());
    }

    @Override
    public String toString() {
        String s = String.format("%d, %d", x, y);
        return s;
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
            return other.x == this.x && other.y == this.y;
        }
    }
}
