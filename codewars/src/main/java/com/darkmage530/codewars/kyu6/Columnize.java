package com.darkmage530.codewars.kyu6;

import java.util.Arrays;

public class Columnize {

    public static void main(String[] args) {
        String result = columnize(new String[] { "", "", "", "" }, 2);
//        String result = columnize(new String[] { "1", "12", "123", "1234", "12345", "123456" }, 6);
        System.out.println(result);
//        System.out.println("1 | 12 | 123 | 1234 | 12345 | 123456");
//        System.out.println(result.equals("1 | 12 | 123 | 1234 | 12345 | 123456"));
    }

    public static String columnize(String[] input, int numberOfColumns) {
        int[] columnSizes = new int[numberOfColumns];
        Arrays.fill(columnSizes, 0);
        int columnCounter = 0;
        for (String str : input) {
            if (str.length() > columnSizes[columnCounter % numberOfColumns]) {
                columnSizes[columnCounter % numberOfColumns] = str.length();
            }
            columnCounter++;
        }

        StringBuilder sb = new StringBuilder();

        int inputCount = 0;
        for (String str : input) {
            sb.append(str);
            int columnSize = columnSizes[inputCount % numberOfColumns];

            for (int i = str.length(); i < columnSize; i++) {
                sb.append(" ");
            }

            inputCount++;
            if (inputCount >= input.length) {
                break;
            }
            if (inputCount % numberOfColumns == 0) {
                sb.append("\n");
            }
            else {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}