package com.darkmage530.hackerrank.july13Contest;

import java.util.*;

/**
 * User: Jon
 * Date: 7/8/13
 * Time: 10:36 PM
 */
public class GameOfThrones1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
        Map<Character, Integer> characterCounting = new HashMap<Character, Integer>();

        for(Character c : input.toCharArray()) {
            if(characterCounting.containsKey(c)) {
                characterCounting.put(c, characterCounting.get(c)+1);
            }
            else {
                characterCounting.put(c, 1);
            }
        }
        boolean isPalindrome = true;
        boolean foundAnOddQuantity = false;
        for(Integer i : characterCounting.values()) {
            if(foundAnOddQuantity == true) {
                if(i % 2 == 1) {
                    isPalindrome = false;
                }
            }
            else if(i % 2 == 1) {
                foundAnOddQuantity = true;
            }
        }
        if(isPalindrome)
            System.out.print("YES");
        else
            System.out.print("NO");
    }
    }
}
