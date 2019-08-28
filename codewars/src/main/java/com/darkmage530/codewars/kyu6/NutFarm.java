package com.darkmage530.codewars.kyu6;

public class NutFarm {

    private static final char NUT = 'o', // a nut
    RIGHT_BRANCH = '\\', // branch. A nut hitting this branch bounces right
    LEFT_BRANCH = '/', // branch. A nut hitting this branch bounces left
    STUCK_BRANCH = '_', // branch. A nut hitting this branch gets stuck in the tree
    LEAF = '.', // leaves, which have no effect on falling nuts
    TRUNK = '|', // tree trunk, which has no effect on falling nuts
    AIR = ' '; // empty space, which has no effect on falling nuts

    public static void main(String[] args) {
        NutFarm nutFarm = new NutFarm();
        char[][] tree = {
                {'.','o','.','o','o','o','o','o','o','.','o','.','o','.','o','o','o','o','o','o','.'}, 
                {'.','.','\\','.','\\','.','.','.','/','.','.','\\','.','.','.','/','.','.','\\','.','.'}
        };

        int[] finalNuts = NutFarm.shakeTree(tree);

        int[] solution = new int[] {0,1,0,1,0,2,1,2,0,0,1,0,1,0,2,0,1,1,0,2,0};
    }

    public static int[] shakeTree(final char[][] tree) {
        NutFarm nutFarm = new NutFarm();

        int treeHeight = tree.length;
        int treeWidth = tree[0].length;
        int[] nutLocation = nutFarm.getNutLocations(tree[0]);

        for (int row = 0; row < treeHeight; row++) {
            if (row < (treeHeight-1)) { //Assume we aren't on the bottom
                char[] nextRow = tree[row+1];
                for (int column = 0; column < treeWidth; column++) {
                    if (nutLocation[column] > 0) { //we found a nut(s)
                          char belowNut = nextRow[column];
                          if (belowNut == RIGHT_BRANCH) {
                              nutLocation = nutFarm.moveNutRight(column, nutLocation);
                          } else if (belowNut == LEFT_BRANCH) {
                              nutLocation = nutFarm.moveNutLeft(column, nutLocation);
                          } else if (belowNut == STUCK_BRANCH) {
                              nutLocation = nutFarm.nutStuck(column, nutLocation);
                          }
                    }
                }
            }
            else {
                //assume we are on the bottom so don't do anything
            }
        }

        return nutLocation;
    }

    private int[] moveNutLeft(int column, int[] nutLocation) {
        int nutsInSpot = nutLocation[column];
        nutLocation[column-1] += nutsInSpot;
        nutLocation[column] = 0;
        return nutLocation;
    }

    private int[] moveNutRight(int column, int[] nutLocation) {
        int nutsInSpot = nutLocation[column];
        nutLocation[column+1] += nutsInSpot;
        nutLocation[column] = 0;
        return nutLocation;
    }

    private int[] nutStuck(int column, int[] nutLocation) {
        nutLocation[column] = 0;
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
