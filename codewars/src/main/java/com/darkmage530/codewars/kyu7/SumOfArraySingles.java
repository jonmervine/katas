package com.darkmage530.codewars.kyu7;

import java.util.HashMap;
import java.util.Map;

public class SumOfArraySingles {

    public static void main(String[] args) {

    }

    public static int repeats(int[] arr) {
        Map<Integer, Boolean> singleNumbers = new HashMap<>();
        for (int i : arr) {
            if (singleNumbers.containsKey(i)) {
                singleNumbers.put(i, false);
            } else {
                singleNumbers.put(i, true);
            }
        }

        return singleNumbers.entrySet().stream()
                .filter(Map.Entry::getValue)
                .mapToInt(Map.Entry::getKey).sum();
    }
}
