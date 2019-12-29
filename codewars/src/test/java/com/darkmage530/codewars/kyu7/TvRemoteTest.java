package com.darkmage530.codewars.kyu7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TvRemoteTest {

    private TvRemote tvRemote;

    @Before
    public void setUp() {
        tvRemote = new TvRemote();
    }

    @Test
    public void canSelect() {
        assertEquals('a', tvRemote.select());
    }

    @Test
    public void testMoveDown() {
        tvRemote.cursor.moveDown();
        assertEquals('f', tvRemote.select());

        tvRemote.cursor.moveDown();
        tvRemote.cursor.moveDown();
        assertEquals('p', tvRemote.select());

        tvRemote.cursor.moveDown();
        tvRemote.cursor.moveDown();
        assertEquals('u', tvRemote.select());
    }

    @Test
    public void testMoveUp() {
        tvRemote.cursor.moveUp();
        assertEquals('a', tvRemote.select());
    }

    @Test
    public void testMoveRight() {
        tvRemote.cursor.moveRight();
        assertEquals('b', tvRemote.select());

        tvRemote.cursor.moveRight();
        tvRemote.cursor.moveRight();
        tvRemote.cursor.moveRight();
        assertEquals('e', tvRemote.select());

        tvRemote.cursor.moveRight();
        tvRemote.cursor.moveRight();
        tvRemote.cursor.moveRight();
        tvRemote.cursor.moveRight();
        assertEquals('3', tvRemote.select());
    }

    @Test
    public void testMoveLeft() {
        tvRemote.cursor.moveLeft();
        assertEquals('a', tvRemote.select());
    }

    @Test
    public void testXRowMoves() {
        int moves = tvRemote.getCursorMoves("c");
        assertEquals(3, moves);
    }

    @Test
    public void testYColumnMoves() {
        int moves = tvRemote.getCursorMoves("p");
        assertEquals(4, moves);
    }

    @Test
    public void testMultipleMoves() {
        int moves = tvRemote.getCursorMoves("t");
        assertEquals(8, moves);
    }

    @Test
    public void testTwoLetters() {
        int moves = tvRemote.getCursorMoves("ag");
        assertEquals(4, moves);
    }

    @Test
    public void example() {
        assertEquals(36, tvRemote.tvRemote("codewars"));
    }

    @Test
    public void misc() {
        assertEquals(16, tvRemote.tvRemote("does"));
        assertEquals(23, tvRemote.tvRemote("your"));
        assertEquals(33, tvRemote.tvRemote("solution"));
        assertEquals(20, tvRemote.tvRemote("work"));
        assertEquals(12, tvRemote.tvRemote("for"));
        assertEquals(27, tvRemote.tvRemote("these"));
        assertEquals(25, tvRemote.tvRemote("words"));
    }

}