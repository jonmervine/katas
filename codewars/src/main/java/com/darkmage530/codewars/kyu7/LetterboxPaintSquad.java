package com.darkmage530.codewars.kyu7;


public class LetterboxPaintSquad {

    public static void main(String[] args) {

    }

    public static int[] paintLetterboxes(final int start, final int end) {
        int[] counts = new int[]{0,0,0,0,0,0,0,0,0,0};
        for(int i = start; i <= end; i++) {
            int[] digits = Integer.toString(i).chars().map(c -> c-'0').toArray();
            for (int j : digits) {
                counts[j]++;
            }
        }
        return counts;
    }
}
