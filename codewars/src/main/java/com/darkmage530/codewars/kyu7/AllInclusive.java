package com.darkmage530.codewars.kyu7;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.codewars.com/kata/5700c9acc1555755be00027e
 */
public class AllInclusive {

    public static boolean containAllRots(String strng, List<String> arr) {
        return containsAllRotations(strng, arr);
    }

    static boolean containsAllRotations(String string, List<String> rotations) {
        LinkedList<Character> stringAsLinkedList = stringToLinkedList(string);
        for (int i = 0; i < string.length(); i++) {
            String rotatedString = linkedListToString(stringAsLinkedList);
            if (!rotations.contains(rotatedString)) {
                return false;
            }
            stringAsLinkedList.addFirst(stringAsLinkedList.removeLast());
        }

        return true;
    }

    static LinkedList<Character> stringToLinkedList(String string) {
        return string.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    static String linkedListToString(LinkedList<Character> stringAsLinkedList) {
        return stringAsLinkedList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
