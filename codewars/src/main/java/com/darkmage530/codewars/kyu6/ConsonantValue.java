package com.darkmage530.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ConsonantValue {

    public static void main(String[] args) {
        solve("zodiacs");
    }

    public static int solve(final String s) {
        String[] consonantSubstrings = s.split("[aeiou]");
        System.out.println(Arrays.stream(consonantSubstrings).collect(Collectors.toList()));

        int maxSubstringValue = 0;
        for(String substring : consonantSubstrings) {
            char[] substringAsArray = substring.toCharArray();
            int substringValue = 0;
            for (int i = 0; i < substringAsArray.length; i++) {
                char currentChar = substringAsArray[i];
                int value = currentChar - 96;
                System.out.println(value + " currentChar: " + currentChar + " value: " + Character.getNumericValue(currentChar));
                substringValue += value;
            }

            if (substringValue > maxSubstringValue) {
                maxSubstringValue = substringValue;
            }
        }

        return maxSubstringValue;
    }
}
