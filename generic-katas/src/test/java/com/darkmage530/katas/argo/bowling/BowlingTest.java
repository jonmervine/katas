package com.darkmage530.katas.argo.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: Jon
 * Date: 3/14/13
 * Time: 8:36 PM
 */
public class BowlingTest {

    private Bowling bowling;

    @Before
    public void setup() {
        bowling = new Bowling();
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);
        assertEquals(0, bowling.scoring());
    }

    @Test
    public void rollOne() {
        rollMany(20, 1);
        assertEquals(20, bowling.scoring());
    }

    @Test
    public void oneSpare() {
        rollSpare();
        bowling.roll(3);
        rollMany(17, 0);
        assertEquals(16, bowling.scoring());
    }

    @Test
    public void oneStrike() throws Exception {
        bowling.roll(10);
        bowling.roll(3);
        bowling.roll(4);
        rollMany(16, 0);
        assertEquals(24, bowling.scoring());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12, 10);
        assertEquals(300, bowling.scoring());
    }

    private void rollSpare() {
        bowling.roll(5);
        bowling.roll(5);
    }

    private void rollMany(int n, int pins) {
        for (int i = 0; i < n; i++) {
            bowling.roll(pins);
        }
    }

}