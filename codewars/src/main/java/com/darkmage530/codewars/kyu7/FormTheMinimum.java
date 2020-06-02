package com.darkmage530.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/5ac6932b2f317b96980000ca
 */
public class FormTheMinimum {

    public static int minValue(int[] values) {
        return Integer.parseInt(Arrays.stream(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
}
