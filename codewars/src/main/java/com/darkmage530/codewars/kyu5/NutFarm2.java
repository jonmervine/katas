package com.darkmage530.codewars.kyu5;

/**
 * https://www.codewars.com/kata/59b24a2158ef58966e00005e
 */
public class NutFarm2 {

    private static final char NUT = 'o', // a nut
            RIGHT_BRANCH = '\\', // branch. A nut hitting this branch bounces right
            LEFT_BRANCH = '/', // branch. A nut hitting this branch bounces left
            STUCK_BRANCH = '_', // branch. A nut hitting this branch gets stuck in the tree
            LEAF = '.', // leaves, which have no effect on falling nuts
            TRUNK = '|', // tree trunk, which has no effect on falling nuts
            AIR = ' '; // empty space, which has no effect on falling nuts

    public static void main(String[] args) {
        char[][] tree = {
                {'.', 'o', '.', 'o', 'o', 'o', 'o', 'o', 'o', '.', 'o', '.', 'o', '.', 'o', 'o', 'o', 'o', 'o', 'o', '.'},
                {'.', '.', '\\', '.', '\\', '.', '.', '.', '/', '.', '.', '\\', '.', '.', '.', '/', '.', '.', '\\', '.', '.'}
        };

        int[] finalNuts = NutFarm2.shakeTree(tree);

        int[] solution = new int[]{0, 1, 0, 1, 0, 2, 1, 2, 0, 0, 1, 0, 1, 0, 2, 0, 1, 1, 0, 2, 0};
    }

    public static int[] shakeTree(final char[][] tree) {
        NutFarm2 nutFarm = new NutFarm2();

        int treeHeight = tree.length;
        int treeWidth = tree[0].length;
        int[] nutLocation = new int[treeWidth];

        for (int row = 0; row < treeHeight; row++) {
            if (row < (treeHeight - 1)) { //Assume we aren't on the bottom
                nutLocation = nutFarm.findNewNuts(tree[row], nutLocation);
                char[] nextRow = tree[row + 1];
                for (int column = 0; column < treeWidth; column++) {
                    if (nutLocation[column] > 0) { //we found a nut(s)
                        nutLocation = nutFarm.nutAction(nutLocation, nextRow, column);
                    }
                }
            } else {
                //assume we are on the bottom so don't do anything
            }
        }

        return nutLocation;
    }

    /**
     * Uses Recursion to determine how far a nut may bounce if there are multiple branches next to each other
     * The base cases are that a nut then reaches an area where it will continue falling or gets stuck
     *
     * @param nutLocation
     * @param belowNuts
     * @param columnIndex
     * @return
     */
    int[] nutAction(int[] nutLocation, char[] belowNuts, int columnIndex) {
        char belowNut = belowNuts[columnIndex];
        if ((belowNut == RIGHT_BRANCH &&
                belowNuts[columnIndex + 1] == LEFT_BRANCH)
                || (belowNut == LEFT_BRANCH &&
                belowNuts[columnIndex - 1] == RIGHT_BRANCH)) {
            //A nut will bounce back and forth indefinitely between \ / branches so treat it as a Stuck Nut
            nutStuck(columnIndex, nutLocation);
        } else if (belowNut == RIGHT_BRANCH) {
            nutLocation = moveNutRight(columnIndex, nutLocation);
            nutLocation = nutAction(nutLocation, belowNuts, ++columnIndex);
        } else if (belowNut == LEFT_BRANCH) {
            nutLocation = moveNutLeft(columnIndex, nutLocation);
            nutLocation = nutAction(nutLocation, belowNuts, --columnIndex);
        } else if (belowNut == STUCK_BRANCH) {
            nutLocation = nutStuck(columnIndex, nutLocation);
        }
        return nutLocation;
    }

    private int[] moveNutLeft(int column, int[] nutLocation) {
        int nutsInSpot = nutLocation[column];
        nutLocation[column - 1] += nutsInSpot;
        nutLocation[column] = 0;
        return nutLocation;
    }

    private int[] moveNutRight(int column, int[] nutLocation) {
        int nutsInSpot = nutLocation[column];
        nutLocation[column + 1] += nutsInSpot;
        nutLocation[column] = 0;
        return nutLocation;
    }

    private int[] nutStuck(int column, int[] nutLocation) {
        nutLocation[column] = 0;
        return nutLocation;
    }

    private int[] findNewNuts(char[] currentTreeLevel, int[] nutLocation) {
        int[] newNutLocations = getNutLocations(currentTreeLevel);
        for (int i = 0; i < newNutLocations.length; i++) {
            nutLocation[i] = nutLocation[i] + newNutLocations[i];
        }
        return nutLocation;
    }

    private int[] getNutLocations(char[] currentTreeLevel) {
        int[] nutLocation = new int[currentTreeLevel.length];
        int i = 0;
        for (char obj : currentTreeLevel) {
            nutLocation[i] = 0;
            if (obj == NUT) {
                nutLocation[i] += 1;
            }
            i++;
        }
        return nutLocation;
    }
}
