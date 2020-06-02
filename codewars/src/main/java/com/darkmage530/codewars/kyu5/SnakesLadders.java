package com.darkmage530.codewars.kyu5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://www.codewars.com/kata/587136ba2eefcb92a9000027
 */
public class SnakesLadders {

    private Map<Integer, Integer> coordinates = new HashMap<Integer, Integer>() {{
        put(2, 38);
        put(7, 14);
        put(8, 31);
        put(15, 26);
        put(16, 6);
        put(21, 42);
        put(28, 84);
        put(36, 44);
        put(46, 25);
        put(49, 11);
        put(51, 67);
        put(62, 19);
        put(64, 60);
        put(71, 91);
        put(74, 53);
        put(78, 98);
        put(87, 94);
        put(89, 68);
        put(92, 88);
        put(95, 75);
        put(99, 80);
    }};

    private int player1, player2;
    private boolean player1Roll = true;
    private boolean gameOver = false;
    private LinkedList<String> gameLog = new LinkedList<>();

    public SnakesLadders() {
    }

    public String play(int die1, int die2) {
        if (gameOver) {
            return "Game over!";
        }

        int move = die1 + die2;
        if (player1Roll) {
            player1 = handleRoll(player1, move);
        } else {
            player2 = handleRoll(player2, move);
        }

        if (die1 != die2) {
            player1Roll = !player1Roll;
        }

        return gameLog.getLast();
    }

    private int handleRoll(int position, int move) {
        int newPosition = position + move;

        if (newPosition > 100) {
            newPosition = 100 - (newPosition - 100);
        }

        if (coordinates.containsKey(newPosition)) {
            newPosition = coordinates.get(newPosition);
        }

        updateGameLog(newPosition);

        return newPosition;
    }

    private void updateGameLog(int newPosition) {
        int playerNumber = player1Roll ? 1 : 2;
        if (newPosition == 100) {
            gameLog.add("Player " + playerNumber + " Wins!");
            gameOver = true;
        } else {
            gameLog.add("Player " + playerNumber + " is on square " + newPosition);
        }
    }
}
