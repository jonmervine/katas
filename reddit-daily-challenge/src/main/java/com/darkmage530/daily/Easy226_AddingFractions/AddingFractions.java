package com.darkmage530.daily.Easy226_AddingFractions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mervine on 8/20/2015.
 */

/*
Fractions are the bane of existence for many elementary and middle-schoolers. They're sort-of hard to get your head around
(though thinking of them as pizza slices turned out to be very helpful for me), but even worse is that they're so hard to
calculate with! Even adding them together is no picknick.

Take, for instance, the two fractions 1/6 and 3/10. If they had the same denominator, you could simply add the numerators
together, but since they have different denominators, you can't do that. First, you have to make the denominators equal.
The easiest way to do that is to use cross-multiplication to make both denominators 60 (i.e. the original denominators
multiplied together, 6 * 10). Then the two fractions becomes 10/60 and 18/60, and you can then add those two together to get 28/60.

(if you were a bit more clever, you might have noticed that the lowest common denominator of those fractions is actually
30, not 60, but it doesn't really make much difference).

You might think you're done here, but you're not! 28/60 has not been reduced yet, those two numbers have factors in common!
The greatest common divisor of both is 4, so we divide both numerator and denominator with 4 to get 7/15, which is the real answer.

For today's challenge, you will get a list of fractions which you will add together and produce the resulting fraction,
reduced as far as possible.

NOTE: Many languages have libraries for rational arithmetic that would make this challenge really easy (for instance,
Python's fractions module does exactly this). You are allowed to use these if you wish, but the spirit of this challenge
is to try and implement the logic yourself. I highly encourage you to only use libraries like that if you can't figure out
how to do it any other way.
Formal inputs & outputs
Inputs

The input will start with a single number N, specifying how many fractions there are to be added.

After that, there will follow N rows, each one containing a fraction that you are supposed to add into the sum. Each fraction comes in the form "X/Y", so like "1/6" or "3/10", for instance.
Output

The output will be a single line, containing the resulting fraction reduced so that the numerator and denominator has no factors in common.
Sample inputs & outputs
Input 1

2
1/6
3/10

Output 1

7/15

Input 2

3
1/3
1/4
1/12

Output 2

2/3

Challenge inputs
Input 1

5
2/9
4/35
7/34
1/2
16/33

Input 2

10
1/7
35/192
61/124
90/31
5/168
31/51
69/179
32/5
15/188
10/17

 */
public class AddingFractions {

    private final String inputFile = "C:/Me/C/git/DailyChallenge/src/Easy226_AddingFractions/Easy226Input.txt";

    public List<List<Fraction>> readInput() {
        List<List<Fraction>> input = new ArrayList<List<Fraction>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
            Iterator it = br.lines().iterator();
            while (it.hasNext()) {
                List<Fraction> fractions = new ArrayList<Fraction>();
                String numOfFractionsString = it.next().toString();
                int numOfFractions = Integer.parseInt(numOfFractionsString);
                for (int i = 0; i < numOfFractions; i++) {
                    String[] fraction = it.next().toString().split("/");
                    Fraction f = new Fraction(Integer.parseInt(fraction[0]), Integer.parseInt(fraction[1]));
                    fractions.add(f);
                }
                input.add(fractions);
            }
            return input;
        } catch (FileNotFoundException ex) {
            return input;
        } catch (Exception ex) {
            return input;
        }
    }

    public static void main(String[] args) {
        AddingFractions service = new AddingFractions();
        List<List<Fraction>> input = service.readInput();
        for (List<Fraction> fractions : input) {
            service.addFractions(fractions);
        }
    }

    public void addFractions(List<Fraction> fractions) {
        Fraction current = fractions.get(0);
        for (int i = 1; i < fractions.size(); i++) {
            Fraction next = fractions.get(i);
            long nextDenom = next.denominator;
            long curDenom = current.denominator;
            current.commonDenominator(nextDenom);
            next.commonDenominator(curDenom);

            if(current.denominator == next.denominator) {
                current.numerator = next.numerator + current.numerator;
            }
            else {
                System.out.println("fuck");
            }
        }

        long divisor = gcd(current);
        System.out.println(current.numerator / divisor + "/" + current.denominator / divisor);
    }

    public long gcd(Fraction current) {
        if (current.denominator == 0) {
            return current.numerator;
        }
        else {
            return gcd(new Fraction(current.denominator, current.numerator % current.denominator));
        }
    }

    private class Fraction {
        private long numerator;
        private long denominator;

        private Fraction(long top, long bottom) {
            this.numerator = top;
            this.denominator = bottom;
        }

        public void commonDenominator(long denom) {
            this.numerator = denom * numerator;
            this.denominator = denom * denominator;
        }
    }
}
