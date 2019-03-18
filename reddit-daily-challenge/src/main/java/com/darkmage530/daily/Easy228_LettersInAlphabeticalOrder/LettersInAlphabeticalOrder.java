package com.darkmage530.daily.Easy228_LettersInAlphabeticalOrder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mervine on 8/17/2015.
 */

/* A handful of words have their letters in alphabetical order, that is nowhere in the word do you change direction in the word if you were to scan along the English alphabet.
        An example is the word "almost", which has its letters in alphabetical order.

    Your challenge today is to write a program that can determine if the letters in a word are alphabetical order. As a bonus, see if you can find words spelled in reverse alphabetical order.

    Input: One word per line in Eglish

    Output:  the example word followed by either IN ORDER or NOT IN ORDER

    Example:
    Input: almost
    Output: almost IN ORDER

    Input: cereal
    Output: cereal NOT IN ORDER

    Challange Input:
    billowy
    biopsy
    chinos
    defaced
    chintz
    sponged
    bijoux
    abhors
    fiddle
    begins
    chimps
    wronged

    Challenge Output:
    billowy IN ORDER
    biopsy IN ORDER
    chinos IN ORDER
    defaced NOT IN ORDER
    chintz IN ORDER
    sponged REVERSE ORDER
    bijoux IN ORDER
    abhors IN ORDER
    fiddle NOT IN ORDER
    begins IN ORDER
    chimps IN ORDER
    wronged REVERSE ORDER
  */

public class LettersInAlphabeticalOrder {

    private final String inputFile = "C:/Me/C/git/DailyChallenge/src/Easy228_LettersinAlphabeticalOrder/Easy228Input.txt";

    public List<String> readInput() {
        List<String> input = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
            Iterator it = br.lines().iterator();
            while (it.hasNext()) {
                input.add(it.next().toString());
            }
            return input;
        } catch (FileNotFoundException ex) {
            return input;
        }
    }

    public static void main(String[] args) {
        LettersInAlphabeticalOrder service = new LettersInAlphabeticalOrder();
        List<String> input = service.readInput();
        for(String line : input) {
            service.determineAlphabetical(line);
        }
    }

    public void determineAlphabetical(String line) {
        if(line.length() <= 0) {
            return;
        }
        char lastChar = line.charAt(0);
        boolean reverse = true;
        boolean inOrder = true;
        for (int i = 1; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c < lastChar) {
                inOrder = false;
            }
            else if (c > lastChar) {
                reverse = false;
            }
            lastChar = c;
        }

        if (reverse) {
            System.out.println(line + " REVERSE ORDER");
        }
        else if(inOrder) {
            System.out.println(line + " IN ORDER");
        }
        else {
            System.out.println(line + " NOT IN ORDER");
        }
        return;
    }
}
