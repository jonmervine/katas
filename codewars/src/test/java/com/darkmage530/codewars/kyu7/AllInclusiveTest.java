package com.darkmage530.codewars.kyu7;

import com.google.common.collect.Lists;
import org.junit.Test;

import static com.darkmage530.codewars.kyu7.AllInclusive.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AllInclusiveTest {

    @Test
    public void correctRotations() {
        boolean correctRotations = containsAllRotations("abc", Lists.newArrayList("abc", "cab", "bca"));
        assertTrue(correctRotations);
    }

    @Test
    public void incorrectRotation() {
        boolean missingRotation = containsAllRotations("abcd", Lists.newArrayList("abcd", "bcda", "dcba", "cdab"));
        assertFalse(missingRotation);
    }

    @Test
    public void missingRotation() {
        boolean missingRotation = containsAllRotations("abcd", Lists.newArrayList("abcd", "bcda", "cdab", "abcd"));
        assertFalse(missingRotation);
    }

    @Test
    public void empty() {
        boolean valid = containsAllRotations("", Lists.newArrayList());
        assertTrue(valid);
    }

    @Test
    public void testCase1() {
        assertTrue(containsAllRotations("bsjq", Lists.newArrayList("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")));
    }

    @Test
    public void testCase2() {
        assertFalse(containsAllRotations("Ajylvpy", Lists.newArrayList("Ajylvpy", "ylvpyAj", "jylvpyA", "lvpyAjy", "pyAjylv", "vpyAjyl", "ipywee")));
    }
}