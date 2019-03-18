package com.darkmage530.codewars.kyu4;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class HowManyNumbersTest {

    @Test
    public void readfromFile() throws IOException {
        File dev = new File("C:\\Users\\jmervine\\dev ad_24.csv");
        File prod = new File("C:\\Users\\jmervine\\prod ad_24.csv");
        FileInputStream devInputStream = null;
        FileInputStream prodInputStream = null;
        Scanner devScanner = null;
        Scanner prodScanner = null;
        try {
            devInputStream = new FileInputStream(dev);
            prodInputStream = new FileInputStream(prod);
            devScanner = new Scanner(devInputStream, "UTF-8");
            prodScanner = new Scanner(prodInputStream, "UTF-8");

            boolean notDone = true;
            while (notDone) {
                if (devScanner.hasNextLine()) {

                }
                String line = devScanner.nextLine();
                System.out.println(line);
            }
            // note that Scanner suppresses exceptions
            if (devScanner.ioException() != null) {
                throw devScanner.ioException();
            }
        } finally {
            if (prodInputStream != null) {
                prodInputStream.close();
            }
            if (devScanner != null) {
                devScanner.close();
            }
        }
    }

    @Test
    public void derpderp() {
        List<String> derp = Lists.newArrayList();
        derp.add("hello");
        derp.add("poi");
        derp.add("akko");

        List<String> derp2 = derp.subList(0, derp.size());
        derp2.remove(1);
        assertEquals(2, derp2.size());
        assertEquals(3, derp.size());
    }

    @Test
    public void singleDigitExamples() {
        List<Long> solution = HowManyNumbers.findAll(5, 1);
        assertEquals(Lists.newArrayList(1L, 5L, 5L), solution);
    }

    @Test
    public void kataExampleTest1() {
        List<Long> solution = HowManyNumbers.findAll(10, 3);
        assertEquals(Lists.newArrayList(8L, 118L, 334L), solution);
    }

    @Test
    public void kataExampleTest2() {
        List<Long> solution = HowManyNumbers.findAll(27, 3);
        assertEquals(Lists.newArrayList(1L, 999L, 999L), solution);
    }

    @Test
    public void kataExampleTest3() {
        List<Long> solution = HowManyNumbers.findAll(84, 4);
        assertEquals(Collections.emptyList(), solution);
    }

    @Test
    public void kataExampleTest4() {
        List<Long> solution = HowManyNumbers.findAll(35, 6);
        assertEquals(Lists.newArrayList(123L, 116999L, 566666L), solution);
    }


    /*
    Testing GetInitialSee
     */
    @Test
    public void testInitialSeeds() {
        long initialSeed = HowManyNumbers.getInitialSeed(1);
        assertEquals(1, initialSeed);

        initialSeed = HowManyNumbers.getInitialSeed(2);
        assertEquals(10, initialSeed);

        initialSeed = HowManyNumbers.getInitialSeed(3);
        assertEquals(100, initialSeed);

        initialSeed = HowManyNumbers.getInitialSeed(4);
        assertEquals(1000, initialSeed);

        initialSeed = HowManyNumbers.getInitialSeed(10);
        assertEquals(1000000000, initialSeed);
    }

    /*
    Testing GetDigitSum
     */
    @Test
    public void testDigitSum() {
        int sum = HowManyNumbers.getDigitSum(5);
        assertEquals(5, sum);

        sum = HowManyNumbers.getDigitSum(10);
        assertEquals(1, sum);

        sum = HowManyNumbers.getDigitSum(954173);
        assertEquals(29, sum);
    }

    /*
    Testing Digits are always increasing
     */
    @Test
    public void testEverIncreasingDigits() {
        assertTrue(HowManyNumbers.digitsEverIncreasing(1234));
        assertTrue(HowManyNumbers.digitsEverIncreasing(1));
        assertTrue(HowManyNumbers.digitsEverIncreasing(111115));
        assertFalse(HowManyNumbers.digitsEverIncreasing(4321));
        assertFalse(HowManyNumbers.digitsEverIncreasing(98));
        assertFalse(HowManyNumbers.digitsEverIncreasing(123450));
    }
}