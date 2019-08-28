package com.darkmage530.codewars.kyu6;

import org.junit.Test;

import static org.junit.Assert.*;

public class NutFarmTest {

    private NutFarm nutFarm = new NutFarm();

    public static char[][] makeTree(String[] a) {

        char[][] array = new char[a.length][];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i].toCharArray();
        }

        return array;

    }

    @Test
    public void bounceLeft() {
        final char tree[][] = makeTree(new String[] {
                " o o o  ",
                " /    / ",
                "   /    ",
                "  /  /  ",
                "   ||   ",
                "   ||   ",
                "   ||   "
        });
        final int[] got = nutFarm.shakeTree(tree);
        assertArrayEquals(new int[]{1,1,0,0,1,0,0,0}, got);
    }

    @Test
    public void bounceRight() {
        final char tree[][] = makeTree(new String[] {
                " o o o  ",
                " \\    \\ ",
                "   \\    ",
                "  \\  \\  ",
                "   ||   ",
                "   ||   ",
                "   ||   ",

        });
        final int[] got = nutFarm.shakeTree(tree);
        assertArrayEquals(new int[]{0,0,0,1,1,0,1,0}, got);
    }

    @Test
    public void getStuck() {
        final char tree[][] = makeTree(new String[] {
                " o o o  ",
                " _      ",
                "   _ _  ",
                "   ||   ",
                "   ||   ",
                "   ||   ",
        });
        final int[] got = nutFarm.shakeTree(tree);
        assertArrayEquals(new int[]{0,0,0,0,0,0,0,0}, got);
    }


}