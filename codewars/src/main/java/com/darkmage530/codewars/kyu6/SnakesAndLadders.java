package com.darkmage530.codewars.kyu6;

/**
    https://www.codewars.com/kata/5821cd4770ca285b1f0001d5
 */
public class SnakesAndLadders {

    public static void main(String[] args) {
        snakesAndLadders(new int[]{0, 0, 3, 0, 0, 0, 0, -2, 0, 0, 0}, new int[]{});
    }

    public static int snakesAndLadders(final int[] board, final int[] dice) {
        int playerIndex = 0;
        int diceIndex = 0;
        while(playerIndex < board.length-1 && diceIndex <= dice.length-1) {
            int roll = dice[diceIndex++];
            System.out.println("roll: " + roll);
            int newPlayerIndex = playerIndex + roll;

            if (!(newPlayerIndex >= board.length)) {
                int boardResult = board[newPlayerIndex];
                playerIndex = newPlayerIndex + boardResult;
            }
            System.out.println("playerindex: " + playerIndex + " diceIndex: " + diceIndex);
        }
        return playerIndex;
    }
}
