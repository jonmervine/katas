package com.darkmage530.codewars.kyu5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BirdMountainTest {

    private void printMountain(char[][] mountain) {
        for (char[] row : mountain) {
            StringBuilder sb = new StringBuilder();
            for (char x : row){
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
        char[][] mountainHeight = {
                "00".toCharArray(),
                "00".toCharArray()
        };
        char[][] result = BirdMountain.zeroOut('0', mountain);
        printMountain(result);
        assertTrue(Arrays.deepEquals(mountainHeight, result));
    }

    @Test
    public void baseCaseFindEdgeWithMissingPieces() {
        char[][] mountain = {
                "^^^".toCharArray(),
                "^ ^".toCharArray(),
                "^^^".toCharArray()
        };
        char[][] mountainHeight = {
                "000".toCharArray(),
                "0 0".toCharArray(),
                "000".toCharArray()
        };
        char[][] result = BirdMountain.zeroOut('0', mountain);
        printMountain(result);
        assertTrue(Arrays.deepEquals(mountainHeight, result));
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