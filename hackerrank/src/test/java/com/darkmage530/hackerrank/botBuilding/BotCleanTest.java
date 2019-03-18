package com.darkmage530.hackerrank.botBuilding;

import org.junit.Test;

/**
 * User: Jon
 * Date: 6/15/13
 * Time: 1:31 AM
 */
public class BotCleanTest {

    @Test
    public void testSomething() {
        String[] grid = {"-----", "-----", "-----", "-----", "--b-d"};
        BotClean.next_move(4, 2, grid);
    }
}
