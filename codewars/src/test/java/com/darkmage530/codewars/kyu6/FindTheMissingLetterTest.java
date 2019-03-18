package com.darkmage530.codewars.kyu6;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheMissingLetterTest {

    @Test
    public void simplestTest() {
        new FindTheMissingLetter();
        char missing = FindTheMissingLetter.findMissingLetter(new char[]{'a', 'c'});
        assertEquals('b', missing);
    }

    @Test
    public void testDifferentLetter() {
        char missing = FindTheMissingLetter.findMissingLetter(new char[]{'b', 'd'});
        assertEquals('c', missing);
    }

    @Test
    public void testCapital() {
        char missing = FindTheMissingLetter.findMissingLetter(new char[]{'W', 'X', 'Z'});
        assertEquals('Y', missing);
    }

    @Test
    public void kataExampleTest1() {
        char missing = FindTheMissingLetter.findMissingLetter(new char[]{'a', 'b', 'c', 'd', 'f'});
        assertEquals('e', missing);
    }

    @Test
    public void kataExampleTest2() {
        char missing = FindTheMissingLetter.findMissingLetter(new char[]{'O', 'Q', 'R', 'S'});
        assertEquals('P', missing);
    }
}