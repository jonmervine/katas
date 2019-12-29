package com.darkmage530.codewars.kyu5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BirdMountainTest {

    private void printMountain(int[][] mountain) {
        for (int[] row : mountain) {
            StringBuilder sb = new StringBuilder();
            for (int x : row){
                sb.append(x);
            }
            System.out.println(sb.toString());
        }
    }

    @Test
    public void baseCaseFindEdge() {
        char[][] mountain = {
                "^^".toCharArray(),
                "^^".toCharArray()
        };
        int[][] mountainHeight = {
                {1, 1},
                {1, 1}
        };
        int[][] result = BirdMountain.zeroOut(mountain);
        printMountain(result);
        assertTrue(Arrays.deepEquals(mountainHeight, result));
    }

    @Test
    public void baseCaseFindEdgeWithMissingPieces() {
        char[][] mountain = {
                "^^^".toCharArray(),
                "^ ^".toCharArray(),
                "  ^".toCharArray()
        };
        int[][] mountainHeight = {
                {1,1,1},
                {1,0,1},
                {0,0,1}
        };
        int[][] result = BirdMountain.zeroOut(mountain);
        printMountain(result);
        assertTrue(Arrays.deepEquals(mountainHeight, result));
    }

    @Test
    public void allZeroes() {
        char[][] mountain = {
                "      ".toCharArray(),
                "      ".toCharArray(),
                "      ".toCharArray(),
        };
        assertEquals(0, BirdMountain.peakHeight(mountain));
    }

    @Test
    public void providedExample() {
        char[][] mountain = {
                "^^^^^^        ".toCharArray(),
                " ^^^^^^^^     ".toCharArray(),
                "  ^^^^^^^     ".toCharArray(),
                "  ^^^^^       ".toCharArray(),
                "  ^^^^^^^^^^^ ".toCharArray(),
                "  ^^^^^^      ".toCharArray(),
                "  ^^^^        ".toCharArray()
        };
        assertEquals(3, BirdMountain.peakHeight(mountain));
    }

}