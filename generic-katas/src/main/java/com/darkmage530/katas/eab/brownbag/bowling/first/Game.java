package com.darkmage530.katas.eab.brownbag.bowling.first;

import com.google.common.collect.Lists;

import java.util.List;

public class Game {
    private List<Integer> frameScores = Lists.newArrayListWithCapacity(10);
    private int frameScore = 0;
    private int frame = 0;

    public void roll(int pin) {
        if (pin > 10) {
            return;
        }

        frame++;
        if (frame % 2 == 0 ) {
            frame = 0;
        }
        frameScore = frameScore + pin;
    }

    public int score() {
        int totalScore = 0;
        for (int frame : frameScores) {
            totalScore += frame;
        }
        return totalScore;
    }
}
