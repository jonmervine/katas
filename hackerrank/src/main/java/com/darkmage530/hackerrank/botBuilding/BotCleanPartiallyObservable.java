package com.darkmage530.hackerrank.botBuilding;

import java.util.*;
import java.io.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * User: Jon
 * Date: 6/18/13
 * Time: 8:22 PM
 */
public class BotCleanPartiallyObservable {
    /* Head ends here */
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

        private void up() {
            System.out.println("UP");
            x--;
        }

        private void down() {
            System.out.println("DOWN");
            x++;
        }

        private void left() {
            System.out.println("LEFT");
            y--;
        }

        private void right() {
            System.out.println("RIGHT");
            y++;
        }

        private void clean() {
            System.out.println("CLEAN");
        }

        private void move(Location dust) {
            if (getX() > dust.getX()) {
                up();
            } else if (getX() < dust.getX()) {
                down();
            } else if (getY() > dust.getY()) {
                left();
            } else if (getY() < dust.getY()) {
                right();
            } else if (equal(dust)) {
                clean();
            }
        }

        public boolean equal(Location dust) {
            return (getX() == dust.getX() && getY() == dust.getY());
        }

        @Override
        public String toString() {
            return "(" + getX() + "," + getY() + ")";
        }
    }

    private static String[] knownBoard;

    /* Head ends here */
    static void next_move(int posx, int posy, String[] board) {
        readFile();
        updateKnownMap(board);
        writeFile();
        for (String line : knownBoard) {
            System.out.println(line);
        }
        Location roomba = new Location(posx, posy);
        roomba.move(findNearestDust(roomba));
    }

    private static void readFile() {
        File file = new File("board.txt");
        if(file.exists()) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            List<String> list = new ArrayList<String>();
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            knownBoard = list.toArray(new String[list.size()]);
        } catch (IOException e) {
            System.out.println("IO Exception: " + e);
        }
        } else {
            knownBoard = new String[]{"ooooo", "ooooo", "ooooo", "ooooo", "ooooo"};
        }
    }

    private static void writeFile() {
        File fileName = new File("board.txt");
        if (fileName.exists()) {
            fileName.delete();
        }
        try {
            fileName.createNewFile();
            FileWriter fileWrite = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWrite);
            for (String line : knownBoard) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error creating file: " + e);
        }
    }

    private static void updateKnownMap(String[] board) {
        int x = 0;
        for (String boardRow : board) {
            char[] newRow = boardRow.toCharArray();
            char[] knownRow = knownBoard[x].toCharArray();

            int y = 0;
            for (char newChar : newRow) {
                char knownChar = knownRow[y];

                if (newChar != 'o') {
                    if (knownChar != newChar) {
                        knownRow[y] = newChar;
                    }
                }
                y++;
            }
            knownBoard[x] = new String(knownRow);
            x++;
        }
    }

    private static Location findNearestDust(Location roomba) {
        if (checkIfOnDust(roomba)) {
            return roomba;
        }
        Location immediate = checkImmediate(roomba);
        if (immediate != null) {
            return immediate;
        }
        Location diagnol = checkDiagnol(roomba);
        if (diagnol != null) {
            return diagnol;
        }
        return mapDust(roomba);
    }

    private static Location mapDust(Location roomba) {
        SortedMap<BigDecimal, Location> distance = new TreeMap<BigDecimal, Location>();
        List<Location> locations = new ArrayList<Location>();
        int i = 0;
        for (String row : knownBoard) {
            if (row.contains("d")) {
                for (int k = 0; k < knownBoard.length; k++) {
                    if (row.charAt(k) == 'd') {
                        locations.add(new Location(i, k));
                    }
                }
            }
            i++;
        }

        for (Location location : locations) {
            BigDecimal dist = measureDistance(location, roomba);
            if (!distance.containsKey(dist)) {
                distance.put(dist, location);
            }
        }

        if (distance.size() == 0) {
            return moveTowardsFog(roomba);
        } else {
            return distance.get(distance.firstKey());
        }
    }

    private static Location moveTowardsFog(Location roomba) {
        Map<String, Integer> unknowns = new HashMap<String, Integer>();
        int x = 0;
        for (String row : knownBoard) {
            if (row.contains("o")) {
                int y = 0;
                for (char col : row.toCharArray()) {
                    if (col == 'o') {
                        String direction = mapDirection(roomba, x, y);
                        if (unknowns.containsKey(direction)) {
                            unknowns.put(direction, unknowns.get(direction) + 1);
                        } else {
                            unknowns.put(direction, 1);
                        }
                    }
                    y++;
                }
            }
            x++;
        }
        String directionLargest = "";
        int largestDirection = -1;
        for (Map.Entry<String, Integer> entrySet : unknowns.entrySet()) {
            if (entrySet.getValue() > largestDirection) {
                directionLargest = entrySet.getKey();
                largestDirection = entrySet.getValue();
            }
        }
        if (directionLargest.equals("UP")) {
            return new Location(roomba.getX() - 1, roomba.getY());
        } else if (directionLargest.equals("DOWN")) {
            return new Location(roomba.getX() + 1, roomba.getY());
        } else if (directionLargest.equals("LEFT")) {
            return new Location(roomba.getX(), roomba.getY() - 1);
        } else if (directionLargest.equals("RIGHT")) {
            return new Location(roomba.getX(), roomba.getY() + 1);
        } else {
            throw new RuntimeException("Fuck this i broke");
        }
    }

    private static String mapDirection(Location roomba, int posx, int posy) {
        int x = roomba.getX();
        int y = roomba.getY();

        int xCord = x - posx;
        int yCord = y - posy;

        if (Math.abs(xCord) >= Math.abs(yCord)) {
            if (xCord > 0) {
                return "UP";
            } else {
                return "DOWN";
            }
        } else {
            if (yCord > 0) {
                return "LEFT";
            } else {
                return "RIGHT";
            }
        }
    }

    private static BigDecimal measureDistance(Location location, Location roomba) {
        BigDecimal x = BigDecimal.valueOf(Math.pow((location.getX() - roomba.getX()), 2));
        BigDecimal y = BigDecimal.valueOf(Math.pow((location.getY() - roomba.getY()), 2));

        return BigDecimal.valueOf(Math.sqrt(x.doubleValue() + y.doubleValue()));
    }

    private static Location checkDiagnol(Location roomba) {
        int x = roomba.getX();
        int y = roomba.getY();
        int length = knownBoard.length - 1;
        if (y > 0 && x > 0) {
            if (knownBoard[x].charAt(y - 1) == 'd') { //check upperleft
                return new Location(x - 1, y - 1);
            }
        }
        if (x > 0 && y < length) {
            if (knownBoard[x - 1].charAt(y) == 'd') { //check upperright
                return new Location(x - 1, y + 1);
            }
        }
        if (x < length && y < length) {
            if (knownBoard[x].charAt(y + 1) == 'd') { //check lowerright
                return new Location(x + 1, y + 1);
            }
        }
        if (x < length && y > 0) {
            if (knownBoard[x + 1].charAt(y) == 'd') { //check lowerleft
                return new Location(x + 1, y - 1);
            }
        }
        return null;
    }

    private static Location checkImmediate(Location roomba) {
        int x = roomba.getX();
        int y = roomba.getY();
        int length = knownBoard.length - 1;
        if (y > 0) {
            if (knownBoard[x].charAt(y - 1) == 'd') { //check left
                return new Location(x, y - 1);
            }
        }
        if (x > 0) {
            if (knownBoard[x - 1].charAt(y) == 'd') { //check up
                return new Location(x - 1, y);
            }
        }
        if (y < length) {
            if (knownBoard[x].charAt(y + 1) == 'd') { //check right
                return new Location(x, y + 1);
            }
        }
        if (x < length) {
            if (knownBoard[x + 1].charAt(y) == 'd') { //check down
                return new Location(x + 1, y);
            }
        }
        return null;
    }

    private static boolean checkIfOnDust(Location roomba) {
        return knownBoard[roomba.getX()].charAt(roomba.getY()) == 'd';
    }

    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] pos = new int[2];
        String board[] = new String[5];
        for (int i = 0; i < 2; i++) pos[i] = in.nextInt();
        for (int i = 0; i < 5; i++) board[i] = in.next();
        next_move(pos[0], pos[1], board);
    }
}
