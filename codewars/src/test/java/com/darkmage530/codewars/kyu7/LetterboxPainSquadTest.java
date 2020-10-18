package com.darkmage530.codewars.kyu7;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterboxPainSquadTest {

    @Test
    public void ex() {
        assertArrayEquals(new int[]{1,9,6,3,0,1,1,1,1,1}, LetterboxPaintSquad.paintLetterboxes(125,132));
    }
}