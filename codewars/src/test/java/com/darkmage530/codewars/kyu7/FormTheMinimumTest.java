package com.darkmage530.codewars.kyu7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormTheMinimumTest {

    @Test
    public void simpleTest() {
        assertEquals(13, FormTheMinimum.minValue(new int[]{1, 3, 1}));
        assertEquals(457, FormTheMinimum.minValue(new int[]{4, 7, 5, 7}));
        assertEquals(148, FormTheMinimum.minValue(new int[]{4, 8, 1, 4}));
        assertEquals(579, FormTheMinimum.minValue(new int[]{5, 7, 9, 5, 7}));
        assertEquals(678, FormTheMinimum.minValue(new int[]{6, 7, 8, 7, 6, 6}));
    }
}