package com.darkmage530.codewars.kyu7;

import org.junit.Test;

import static org.junit.Assert.*;

public class SumOfArraySinglesTest {

    @Test
    public void basicTest() {
        assertEquals(15, SumOfArraySingles.repeats(new int[]{4, 5, 7, 5, 4, 8}));
        assertEquals(19, SumOfArraySingles.repeats(new int[]{9, 10, 19, 13, 19, 13}));
        assertEquals(12, SumOfArraySingles.repeats(new int[]{16, 0, 11, 4, 8, 16, 0, 11}));
    }
}