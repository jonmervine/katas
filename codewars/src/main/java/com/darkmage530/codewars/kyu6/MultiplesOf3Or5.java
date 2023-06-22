package com.darkmage530.codewars.kyu6;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class MultiplesOf3Or5 {

    public static void main(String[] args) {
        MultiplesOf3Or5 application = new MultiplesOf3Or5();
        int resultSum = application.findSumBelow(10);
        System.out.println(resultSum);
    }

    public int findSumBelow(int naturalLimit) {
        Set<Integer> foundMultiples = findsMultiplesBelowLimit(naturalLimit);

        int sumOfMultiples = foundMultiples.stream().flatMapToInt(IntStream::of).sum();
        return sumOfMultiples;
    }

    public Set<Integer> findsMultiplesBelowLimit(int naturalLimit) {
        int counter = naturalLimit;
        Set<Integer> foundMultiples = new HashSet<>();
        while (counter-- > 0) {
            if (counter % 3 == 0 || counter % 5 == 0) {
                foundMultiples.add(counter);
            }
        }
        return foundMultiples;
    }
}
