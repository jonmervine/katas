package com.darkmage530.codewars.kyu5;

import java.awt.*;

public class BirdMountain {

    private static final char BASE_CHARACTER = '^';

    private static int peak = 0;

    public static int peakHeight(char[][] mountain) {
        peak = 0;
        if (mountain == null || mountain.length == 0) {
            return 0;
        }
        int[][] intMountain = zeroOut(mountain);

        printMountain(intMountain);
        int currentTier = 0;
        int upgradeTier = 1;
        boolean keepGoing = true;

        while (keepGoing) {
            currentTier++;
            upgradeTier++;

            keepGoing = false;
            for (int x = 0; x < intMountain.length; x++) {
                int[] row = intMountain[x];
                for (int y = 0; y < row.length; y++) {
                    if (intMountain[x][y] != 0 && canUpgradePosition(intMountain, new Point(x, y), currentTier)) {
                        intMountain[x][y] = upgradeTier;
                        keepGoing = true;
                        peak = upgradeTier;
                    }
                }
            }
        }

        printMountain(intMountain);

        return peak;
    }

    private static void printMountain(int[][] mountain) {
        for (int[] row : mountain) {
            StringBuilder sb = new StringBuilder();
            for (int x : row){
                sb.append(x);
            }
            System.out.println(sb.toString());
        }

        System.out.println("");
    }

    static int[][] zeroOut(char[][] mountain) {
        int[][] intMountain = new int[mountain.length][mountain[0].length];
        for (int x = 0; x < mountain.length; x++) {
            char[] row = mountain[x];
            for (int y = 0; y < row.length; y++) {
                if (row[y] == BASE_CHARACTER) {
                    intMountain[x][y] = 1;
                    peak = 1;
                } else {
                    intMountain[x][y] = 0;
                }
            }
        }
        return intMountain;
    }

    public static boolean canUpgradePosition(int[][] mountain, Point currentPosition, int currentTier) {
        int xMax = mountain.length - 1;
        int yMax = mountain[0].length - 1;
        int EAST = currentPosition.x + 1;
        int WEST = currentPosition.x - 1;
        int NORTH = currentPosition.y + 1;
        int SOUTH = currentPosition.y - 1;

        if (EAST > xMax) {
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

        EAST = mountain[currentPosition.x+1][currentPosition.y];
        WEST = mountain[currentPosition.x-1][currentPosition.y];
        NORTH = mountain[currentPosition.x][currentPosition.y+1];
        SOUTH = mountain[currentPosition.x][currentPosition.y-1];

        if (EAST >= currentTier && WEST >= currentTier && NORTH >= currentTier && SOUTH >= currentTier) {
            return true;
        }
        return false;
    }


}
