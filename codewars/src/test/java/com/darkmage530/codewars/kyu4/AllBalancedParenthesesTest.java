package com.darkmage530.codewars.kyu4;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AllBalancedParenthesesTest {
    @Test
    public void testExample() {
        List<String> warriorsList;
        //test for n = 0
        warriorsList = AllBalancedParentheses.balancedParens(0);
        assertEquals(Lists.newArrayList(""), warriorsList);

        //test for n = 1
        warriorsList = AllBalancedParentheses.balancedParens(1);
        assertEquals(Lists.newArrayList("()"), warriorsList);

        //test for n =2
        warriorsList = AllBalancedParentheses.balancedParens(2);
        Collections.sort(warriorsList);
        assertEquals(Lists.newArrayList("(())", "()()"), warriorsList);

        //test for n = 3
        warriorsList = AllBalancedParentheses.balancedParens(3);
        Collections.sort(warriorsList);
        assertEquals(Lists.newArrayList("((()))", "(()())", "(())()", "()(())", "()()()"), warriorsList);

        //test for n = 4
        warriorsList = AllBalancedParentheses.balancedParens(4);
        Collections.sort(warriorsList);
        assertEquals(Lists.newArrayList("(((())))", "((()()))", "((())())", "((()))()", "(()(()))", "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()", "()()(())", "()()()()"), warriorsList);
    }
}