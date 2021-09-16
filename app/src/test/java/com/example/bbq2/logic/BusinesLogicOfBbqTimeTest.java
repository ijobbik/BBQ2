package com.example.bbq2.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BusinesLogicOfBbqTimeTest {
    BusinesLogicOfBbqTime logic = new BusinesLogicOfBbqTime();
    @Test
    public void isItBbqTimeResultTrue() {
        assertTrue(logic.isItBbqTime(20,1.99));
    }
    @Test
    public void isItBbqTimeResultFalseBylowTemp() {
        assertFalse(logic.isItBbqTime(19.99,1.99));
    }
    @Test
    public void isItBbqTimeResultFalseByRainTemp() {
        assertFalse(logic.isItBbqTime(20,2));
    }
    @Test
    public void messageisCorrect() {
        assertEquals("You can do a barbeque!", logic.getBbqMessage());
    }
}
