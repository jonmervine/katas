package com.darkmage530.katas.eab.brownbag.bowling.first;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private int score = 0;

    public void roll(int pins) {
        if (pins > 10) {
            return;
        }

        score += pins;
    }

    public int score() {
        return score;
    }
}
