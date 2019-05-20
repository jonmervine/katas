package com.darkmage530.hackerrank.july13Contest;

import java.util.*;
import java.math.*;

/**
 * User: Jon
 * Date: 7/9/13
 * Time: 7:46 PM
 */
public class GameOfThrones2 {
    private static final Map<Integer, BigInteger> cache = new HashMap<Integer, BigInteger>();
    private static final long MAX = 1000000007;
    public static void main(String[] args) {
        cache.put(1, BigInteger.valueOf(1));
        cache.put(2, BigInteger.valueOf(2));
        cache.put(3, BigInteger.valueOf(6));
        cache.put(4, BigInteger.valueOf(24));
        cache.put(5, BigInteger.valueOf(120));
        cache.put(6, BigInteger.valueOf(720));
        cache.put(7, BigInteger.valueOf(5040));
        cache.put(8, BigInteger.valueOf(40320));
        cache.put(9, BigInteger.valueOf(362880));
        cache.put(10, BigInteger.valueOf(3628800));
        cache.put(11, BigInteger.valueOf(39916800));
        cache.put(12, BigInteger.valueOf(479001600));
        cache.put(13, BigInteger.valueOf(6227020800l));
        cache.put(14, BigInteger.valueOf(87178291200l));
        cache.put(15, BigInteger.valueOf(1307674368000l));
        cache.put(16, BigInteger.valueOf(20922789888000l));
        cache.put(17, BigInteger.valueOf(355687428096000l));
        cache.put(18, BigInteger.valueOf(6402373705728000l));
        cache.put(19, BigInteger.valueOf(121645100408832000l));
        cache.put(20, BigInteger.valueOf(2432902008176640000l));
        cache.put(50, factorial(50));
        cache.put(100, factorial(100));

//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()) {
//            String input = sc.nextLine();
        String input = args[0];
        Map<Character, Integer> characterCounting = new HashMap<Character, Integer>();

        for(Character c : input.toCharArray()) {
            if(characterCounting.containsKey(c)) {
                characterCounting.put(c, characterCounting.get(c)+1);
            }
            else {
                characterCounting.put(c, 1);
            }
        }
        int top = 0;
        BigInteger totalBottom = BigInteger.ONE;
        for(int i : characterCounting.values()) {
            top = top + ((int)Math.floor(i/2));
            BigInteger k = factorial((int)Math.floor(i/2));
            totalBottom = k.multiply(totalBottom);
        }
        BigInteger totalTop = factorial(top);
        BigInteger finalAns = (totalTop.divide(totalBottom)).mod(BigInteger.valueOf(MAX));
        System.out.print(finalAns);

//       factorial(BigInteger.valueOf(77));
//    }
    }

    /*public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()) {
//            String input = sc.nextLine();
        String input = args[0];
        Map<Character, Long> characterCounting = new HashMap<Character, Long>();

        for (Character c : input.toCharArray()) {
            if (characterCounting.containsKey(c)) {
                characterCounting.put(c, characterCounting.get(c) + 1);
            } else {
                characterCounting.put(c, 1l);
            }
        }
        long totalTop = 0l;
        long totalBottom = 1l;
        for (Long i : characterCounting.values()) {
            totalTop = totalTop + (long) Math.floor(i / 2);
            long k = factorialWithMod((long) Math.floor(i / 2));
            if (k == 0l) {
                k = 1l;
            }
            totalBottom = (k * totalBottom) % MAX;
        }
        totalTop = factorialWithMod(totalTop);

        long finalAns = (totalTop/totalBottom);
        System.out.println(finalAns);

        // factorial(BigInteger.valueOf(77));
//        }
    }*/

    public static long factorialWithMod(long i) {
        for (long j = i - 1; j > 0; j--) {
            i = (i * j) % MAX;
        }
        return i;
    }


    public static BigInteger factofrial(int n) {
        BigInteger ret;
        if (n == 0) return BigInteger.ONE;
        if (null != (ret = cache.get(n))) return ret;
        ret = BigInteger.valueOf(n).multiply(factorial(n-1));
        return ret;
    }

    public static BigInteger factorial(int n) {
        BigInteger ret = BigInteger.valueOf(n);
        if (n == 0) return BigInteger.ONE;
        for (int i = n-1; i > 0; i--) {
            if (cache.containsKey(i)) {
                ret = ret.multiply(cache.get(i));
                return ret;
            }
            else {
                ret = ret.multiply(BigInteger.valueOf(i));
            }
        }
        return ret;
    }

}
