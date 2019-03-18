package com.darkmage530.katas.argo.bowling;

/**
 * User: Jon
 * Date: 3/14/13
 * Time: 8:44 PM
 */
public class Bowling {

    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int scoring() {
        int score = 0;
        int frameIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (rolls[frameIndex] == 10 ) { //strike
                score += 10 + rolls[frameIndex+1] + rolls[frameIndex+2];
                frameIndex++;
            }
            else if(isSpare(frameIndex)) {
                score += 10 + rolls[frameIndex + 2];
                frameIndex +=2;
            } else {
                score += rolls[frameIndex] + rolls[frameIndex+1];
                frameIndex+=2;
            }
        }
        return score;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex+1] == 10;
    }
}
