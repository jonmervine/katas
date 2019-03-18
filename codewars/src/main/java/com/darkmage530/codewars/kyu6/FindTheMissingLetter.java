package com.darkmage530.codewars.kyu6;

public class FindTheMissingLetter {

    public static char findMissingLetter(char[] array) {
        char missingLetter = ' ';
        char previous = array[0];
        for (char letter : array) {
            if (letter - previous > 1) {
                int i = letter - 1;
                missingLetter = (char) i;
                break;
            }
            previous = letter;
        }
        return missingLetter;
    }
}
