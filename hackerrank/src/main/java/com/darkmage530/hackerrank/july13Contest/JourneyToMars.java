package com.darkmage530.hackerrank.july13Contest;

import java.util.Scanner;

/**
 * User: Jon
 * Date: 7/13/13
 * Time: 2:05 AM
 */
public class JourneyToMars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loops = sc.nextInt();
        for (int i = 0; i < loops; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            String num = String.valueOf((long)Math.pow(2, n-1));
            String first = num.substring(0, k);
            String last = num.substring(num.length()-k, num.length());
            System.out.println(Integer.parseInt(first) + Integer.parseInt(last));
//            System.out.println("num: " + num + " First: " + first + " Last: " + last);
        }
    }
}
