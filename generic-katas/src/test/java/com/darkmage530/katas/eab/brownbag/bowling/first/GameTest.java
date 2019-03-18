package com.darkmage530.katas.eab.brownbag.bowling.first;

import com.darkmage530.katas.eab.brownbag.bowling.first.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;

    @Before
    public void setup() {
        this.game = new Game();
    }

    @Test
    public void noRollScore() {
        assertEquals(0, game.score());
    }

    @Test
    public void rollOneScore() {
        game.roll(1);
        Assert.assertEquals(1, game.score());
    }

    @Test
    public void rollTwice() {
        game.roll(3);
        game.roll(2);
        assertEquals(5, game.score());
    }

    @Test
    public void knockdownTooManyPins() {
        game.roll(12);
        assertEquals(0, game.score());
    }

    @Test
    public void rollASpare() {
        game.roll(5);
        game.roll(5);
        assertEquals(0, game.score());
        game.roll(5);
        assertEquals(20, game.score());
    }

}