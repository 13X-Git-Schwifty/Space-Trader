package com.gitschwifty.cs2340.gatech.space_trader;


import com.gitschwifty.cs2340.gatech.space_trader.Model.CargoHold;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Coordinate;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

//JUnit written by Inan Batra

@SuppressWarnings("ALL")
public class LoginTest {

    Coordinate Coordinate1;
    Coordinate Coordinate2;
    Coordinate Coordinate3;
    Coordinate Coordinate4;
    CargoHold cargoHold;
    Coordinate nullCo;
    Coordinate Coordinate5;
    Coordinate Coordinate6;

    @Before
    public void setUp() {
        //set of coordinates
        int list[] = {1, 0, -2, 12, 14, 594595149};
        Coordinate1 = new Coordinate(list[0], list[1]);
        Coordinate2 = new Coordinate(list[2], list[3]);
        Coordinate3 = new Coordinate(list[4], list[5]);
        //to compare
        Coordinate4 = new Coordinate(list[0], list[1]);
        cargoHold = new CargoHold();
        nullCo = null;
        Coordinate5 = new Coordinate(list[0], list[2]);
        Coordinate6 = new Coordinate(list[1], list[2]);
    }

    @Test
    public void testThisOrInstanceOf() {
        assertEquals(true, Coordinate1.equals(Coordinate1));
        assertEquals(false, Coordinate1.equals(cargoHold));
    }


}
