package com.darkmage530.hackerrank.botBuilding;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BotSavesPrincess {
    /* Head ends here */
    public static class Location {
        private int x;
        private int y;

        public Location(int n) {
            this(n, n);
        }

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

    /* Head ends here */
    static void displayPathtoPrincess(int n, String [] grid){
        Location startingLocation = new Location(n/2);
        Location princessLocation = findPrincess(n, grid);
        printDirections(startingLocation, princessLocation);
    }

    private static void printDirections(Location startingLocation, Location princessLocation) {
        while(startingLocation.getX() > princessLocation.getX()) {
            startingLocation.up();
        }
        while(startingLocation.getX() < princessLocation.getX()) {
            startingLocation.down();
        }
        while(startingLocation.getY() > princessLocation.getY()) {
            startingLocation.left();
        }
        while(startingLocation.getY() < princessLocation.getY()) {
            startingLocation.right();
        }
    }

    private static Location findPrincess(int n, String[] grid) {
        if(grid[0].contains("p")) {
            if(grid[0].startsWith("p")) {
                return new Location(0,0);
            }
            return new Location(0, n-1);
        }
        else {
            if(grid[grid.length-1].startsWith("p")) {
                return new Location(n-1, 0);
            }
            return new Location(n-1, n-1);
        }
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        String grid[] = new String[m];
        for(int i = 0; i < m; i++) {
            grid[i] = in.next();
        }

        displayPathtoPrincess(m,grid);
    }
}