package com.darkmage530.codewars.kyu5;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeightForWeightTest {

    private WeightForWeight weightForWeight = new WeightForWeight();

    @Test
    public void convertWeightToWeight() {
        assertEquals("18", weightForWeight.convertWeightToWeight("99"));
        assertEquals("1", weightForWeight.convertWeightToWeight("100"));
    }
}