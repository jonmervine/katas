package com.darkmage530.codewars.kyu6;

/**
 * https://www.codewars.com/kata/5839edaa6754d6fec10000a2
 */
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
