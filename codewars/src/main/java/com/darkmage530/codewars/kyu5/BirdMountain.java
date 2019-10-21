package com.darkmage530.codewars.kyu5;

import java.awt.*;
import java.lang.reflect.Array;

public class BirdMountain {

    private static final char BASE_CHARACTER = '^';

    public static int peakHeight(char[][] mountain) {
        if (mountain == null || mountain.length == 0) {
            return 0;
        }
        int[][] intMountain = zeroOut(mountain);
        return 1;
    }

    static int[][] zeroOut(char[][] mountain) {
        int[][] intMountain = new int[mountain.length][mountain[0].length];
        for(int x = 0; x < mountain.length; x++) {
            char[] row = mountain[x];
            for (int y = 0; y < row.length; y++) {
                if (row[y] == BASE_CHARACTER) {
                    row[y] = '0';
                }
            }
        }
        return intMountain;
    }

    public boolean canUpgradePosition(char[][] mountain, Point currentPosition, char currentTier, char upgradeTier) {
        int xMax = mountain.length -1;
        int yMax = mountain[0].length -1;
        int EAST = currentPosition.x + 1;
        int WEST = currentPosition.x - 1;
        int NORTH = currentPosition.y + 1;
        int SOUTH = currentPosition.y - 1;

        boolean canUpgrade = true;
        if (EAST > xMax ) {
            return false;
        }
        if (WEST < 0) {
            return false;
        }
        if (NORTH > yMax) {
            return false;
        }
        if (SOUTH < 0) {
            return false;
        }

        if (EAST == currentTier )
    }


}
