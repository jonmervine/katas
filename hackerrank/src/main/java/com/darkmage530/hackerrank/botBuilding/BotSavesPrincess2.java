package com.darkmage530.hackerrank.botBuilding;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * User: Jon
 * Date: 6/14/13
 * Time: 8:28 PM
 */
public class BotSavesPrincess2 {

    public static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void up() {
            System.out.println("UP");
            x--;
        }

        public void down(){
            System.out.println("DOWN");
            x++;
        }

        public void left(){
            System.out.println("LEFT");
            y--;
        }

        public void right() {
            System.out.println("RIGHT");
            y++;
        }
        @Override
        public String toString() {
            return "("+getX() + "," + getY()+")";
        }
    }

    private static void printDirections(Location startingLocation, Location princessLocation) {
        if(startingLocation.getX() > princessLocation.getX()) {
            startingLocation.up();
        }
        else if(startingLocation.getX() < princessLocation.getX()) {
            startingLocation.down();
        }
        else if(startingLocation.getY() > princessLocation.getY()) {
            startingLocation.left();
        }
        else if(startingLocation.getY() < princessLocation.getY()) {
            startingLocation.right();
        }
    }

    private static Location findPrincess(String[] grid) {
        int i = 0;
        while(i < grid.length) {
            if(grid[i].contains("p")) {
                return new Location(i, grid[i].indexOf("p"));
            }
            i++;
        }
        return new Location(-1, -1);
    }

    static void nextMove(int n, int x, int y, String [] board){
        Location startingLocation = new Location(x, y);
        Location princessLocation = findPrincess(board);
        printDirections(startingLocation, princessLocation);
    }
    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,x,y;
        n = in.nextInt();
        x = in.nextInt();
        y = in.nextInt();
        in.useDelimiter("\n");
        String board[] = new String[n];


        for(int i = 0; i < n; i++) {
            board[i] = in.next();
        }

        nextMove(n,x,y,board);

    }
}
