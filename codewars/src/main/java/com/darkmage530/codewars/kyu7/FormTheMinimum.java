package com.darkmage530.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class FormTheMinimum {

    public static int minValue(int[] values) {
        return Integer.parseInt(Arrays.stream(values)
                .distinct()
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }
}
