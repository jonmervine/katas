package com.darkmage530.codewars.kyu4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class HowManyNumbers {

    public static List<Long> findAll(int sumDigits, int numDigits) {
        List<Long> results = new ArrayList<>();
        long initialSeed = getInitialSeed(numDigits);

        long max = initialSeed * 10;
        while (initialSeed < max) {
            if (getDigitSum(initialSeed) == sumDigits && digitsEverIncreasing(initialSeed)) {
                results.add((long) initialSeed);
            }

            initialSeed++;
        }

        if (results.isEmpty()) {
            return new ArrayList<>();
        }

        List<Long> returnResults = new ArrayList<>();

        returnResults.add((long) results.size());
        returnResults.add(results.stream().mapToLong(Long::longValue).min().getAsLong());
        returnResults.add(results.stream().mapToLong(Long::longValue).max().getAsLong());
        return returnResults;
    }

    public static long getInitialSeed(int digitWidth) {
        StringBuilder initialSeed = new StringBuilder("1");
        for (int i = 0; i < digitWidth - 1; i++) {
            initialSeed.append("0");
        }
        return Long.parseLong(initialSeed.toString());
    }

    public static int getDigitSum(long num) {
        return decomposeToListOfDigits(num).stream().mapToInt(Integer::intValue).sum();
    }

    public static boolean digitsEverIncreasing(long num) {
        LinkedList<Integer> digits = decomposeToListOfDigits(num);
        String minimum = digits.stream().sorted().map(String::valueOf).collect(Collectors.joining());
        return Integer.parseInt(minimum) == num;
    }

    public static LinkedList<Integer> decomposeToListOfDigits(long num) {
        LinkedList<Integer> digits = new LinkedList<>();
        while (num >= 1) {
            int digit = (int) (num % 10);
            digits.addFirst(digit);
            num = num / 10;
        }
        return digits;
    }
}
