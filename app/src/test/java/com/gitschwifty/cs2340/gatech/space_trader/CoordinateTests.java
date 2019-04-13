package com.gitschwifty.cs2340.gatech.space_trader;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import com.gitschwifty.cs2340.gatech.space_trader.Model.CargoHold;
import com.gitschwifty.cs2340.gatech.space_trader.Model.Coordinate;

import static org.junit.Assert.assertEquals;


//JUnit written by Riya Agrawal
@SuppressWarnings("ALL")
public class CoordinateTests {
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
        List<Integer> list = Arrays.asList(1, 0, -2, 12, 14, 594595149);
        Coordinate1 = new Coordinate(list.get(0), list.get(1));
        Coordinate2 = new Coordinate(list.get(2), list.get(3));
        Coordinate3 = new Coordinate(list.get(4), list.get(5));
        //to compare
        Coordinate4 = new Coordinate(list.get(0), list.get(1));
        cargoHold = new CargoHold();
        nullCo = null;
        Coordinate5 = new Coordinate(list.get(0), list.get(2));
        Coordinate6 = new Coordinate(list.get(1), list.get(2));
    }


    @Test
    public void testThisOrInstanceOf() {
        assertEquals(true, Coordinate1.equals(Coordinate1));
        assertEquals(false, Coordinate1.equals(cargoHold));
    }

    @Test
    public void testOther() {
        assertEquals(true, Coordinate1.equals(Coordinate4));
        assertEquals(false, Coordinate1.equals(Coordinate5));
        assertEquals(false, Coordinate1.equals(Coordinate6));
    }

    @Test
    public void testEqualsFalse() {
        assertEquals(false, Coordinate1.equals(Coordinate2));
        assertEquals(false, Coordinate1.equals(Coordinate3));
        assertEquals(false, Coordinate1.equals(nullCo));

    }


}
