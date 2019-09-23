package com.darkmage530.codewars.kyu5;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NutFarm2Test {

    public static char[][] makeTree(String[] a) {

        char[][] array = new char[a.length][];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i].toCharArray();
        }

        return array;
    }

    @Test
    public void bounceLeft() {
        final char tree[][] = makeTree(new String[]{
                " o o o  ",
                " /    / ",
                "   /    ",
                "  /  /  ",
                "   ||   ",
                "   ||   ",
                "   ||   "
        });
        final int[] got = NutFarm2.shakeTree(tree);
        assertArrayEquals(new int[]{1, 1, 0, 0, 1, 0, 0, 0}, got);
    }

    @Test
    public void rollLeft() {
        final char tree[][] = makeTree(new String[]{
                " o      ",
                " / o o/ ",
                " ///    ",
                "   ///  ",
                "   ||   ",
                "   ||   ",
                "   ||   "
        });
        final int[] got = NutFarm2.shakeTree(tree);
        assertArrayEquals(new int[]{2, 0, 1, 0, 0, 0, 0, 0}, got);
    }

    @Test
    public void bounceRight() {
        final char tree[][] = makeTree(new String[]{
                " o o o  ",
                " \\    \\ ",
                "   \\    ",
                "  \\  \\  ",
                "   ||   ",
                "   ||   ",
                "   ||   ",

        });
        final int[] got = NutFarm2.shakeTree(tree);
        assertArrayEquals(new int[]{0, 0, 0, 1, 1, 0, 1, 0}, got);
    }

    @Test
    public void rollRight() {
        final char tree[][] = makeTree(new String[]{
                " o o  oo  ",
                " \\\\\\   \\\\ ",
                "  o \\o    ",
                "  \\\\  \\   ",
                "    ||    ",
                "    ||    ",
                "    ||    ",

        });
        final int[] got = NutFarm2.shakeTree(tree);
        assertArrayEquals(new int[]{0, 0, 0, 0, 1, 3, 0, 1, 0, 1}, got);
    }

    @Test
    public void nutActionOneDirection() {
        NutFarm2 nutfarm = new NutFarm2();
        int[] nuts = new int[]{0, 1, 0};
        char[] below = new char[]{'.', '\\', '.'};

        int[] finalPosition = nutfarm.nutAction(nuts, below, 1);
        assertArrayEquals(new int[]{0, 0, 1}, finalPosition);
    }

    @Test
    public void nutActionTwoBouncesRight() {
        NutFarm2 nutfarm = new NutFarm2();
        int[] nuts = new int[]{0, 1, 0, 0};
        char[] below = new char[]{'.', '\\', '\\', '.'};

        int[] finalPosition = nutfarm.nutAction(nuts, below, 1);
        assertArrayEquals(new int[]{0, 0, 0, 1}, finalPosition);
    }

    @Test
    public void nutActionTwoBouncesLeft() {
        NutFarm2 nutfarm = new NutFarm2();
        int[] nuts = new int[]{0, 0, 1, 0};
        char[] below = new char[]{'.', '/', '/', '.'};

        int[] finalPosition = nutfarm.nutAction(nuts, below, 2);
        assertArrayEquals(new int[]{1, 0, 0, 0}, finalPosition);
    }

    @Test
    public void nutActionStuckBounces() {
        NutFarm2 nutfarm = new NutFarm2();
        int[] nuts = new int[]{0, 1, 0, 0};
        char[] below = new char[]{'.', '\\', '/', '.'};

        int[] finalPosition = nutfarm.nutAction(nuts, below, 1);
        assertArrayEquals(new int[]{0, 0, 0, 0}, finalPosition);
    }
}

