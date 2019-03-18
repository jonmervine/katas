package com.darkmage530.hackerrank.botBuilding;


import org.junit.Test;

/**
 * User: Jon
 * Date: 6/18/13
 * Time: 8:22 PM
 */
public class BotCleanPartiallyObservableTest {
    @Test
    public void testSomething() {
        String[] grid = {"bdooo", "-dooo", "ooooo", "ooooo", "ooooo"};//right
        BotCleanPartiallyObservable.next_move(0, 0, grid);
        String[] grid2 = {"-d-oo", "-d-oo", "ooooo", "ooooo", "ooooo"};//clean
        BotCleanPartiallyObservable.next_move(0, 1, grid2);
        String[] grid3 = {"-b-oo", "-d-oo", "ooooo", "ooooo", "ooooo"};//down
        BotCleanPartiallyObservable.next_move(0, 1, grid3);
        String[] grid4 = {"---oo", "-d-oo", "---oo", "ooooo", "ooooo"};//clean
        BotCleanPartiallyObservable.next_move(1, 1, grid4);
        String[] grid5 = {"---oo", "-b-oo", "---oo", "ooooo", "ooooo"};//down
        BotCleanPartiallyObservable.next_move(1, 1, grid5);
        String[] grid6 = {"ooooo", "---oo", "-b-oo", "---oo", "ooooo"};//right
        BotCleanPartiallyObservable.next_move(2, 1, grid6);
        String[] grid7 = {"ooooo", "o---o", "o-bdo", "o--do", "ooooo"};//right
        BotCleanPartiallyObservable.next_move(2, 2, grid7);
        String[] grid8 = {"ooooo", "oo---", "oo-d-", "oo-d-", "ooooo"};//clean
        BotCleanPartiallyObservable.next_move(2, 3, grid8);
        String[] grid9 = {"ooooo", "oo---", "oo-b-", "oo-d-", "ooooo"};//down
        BotCleanPartiallyObservable.next_move(2, 3, grid9);
        String[] grid10 = {"ooooo", "ooooo", "oo---", "oo-d-", "ood-d"};//clean
        BotCleanPartiallyObservable.next_move(3, 3, grid10);
        String[] grid11 = {"ooooo", "ooooo", "oo---", "oo-b-", "ood-d"};//down
        BotCleanPartiallyObservable.next_move(3, 3, grid11);
        String[] grid12 = {"ooooo", "ooooo", "ooooo", "oo---", "oodbd"};//left
        BotCleanPartiallyObservable.next_move(4, 3, grid12);
        String[] grid13 = {"ooooo", "ooooo", "ooooo", "o---o", "o-d-o"};//clean
        BotCleanPartiallyObservable.next_move(4, 2, grid13);
        String[] grid14 = {"ooooo", "ooooo", "ooooo", "o---o", "o-b-o"};//up should be right
        BotCleanPartiallyObservable.next_move(4, 2, grid14);
    }
}