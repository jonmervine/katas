package com.darkmage530.hackerrank.botBuilding;

import java.math.BigDecimal;
import java.util.*;

/**
 * User: Jon
 * Date: 6/14/13
 * Time: 8:27 PM
 */
public class BotClean {
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

    /* Head ends here */
    static void next_move(int posx, int posy, String[] board) {
        Location roomba = new Location(posx, posy);
        roomba.move(findNearestDust(board, roomba));
    }

    private static Location findNearestDust(String[] board, Location roomba) {
        if (checkIfOnDust(board, roomba)) {
            return roomba;
        }
        Location immediate = checkImmediate(board, roomba);
        if (immediate != null) {
            return immediate;
        }
        Location diagnol = checkDiagnol(board, roomba);
        if (diagnol != null) {
            return diagnol;
        }
        return mapDust(board, roomba);
    }

    private static Location mapDust(String[] board, Location roomba) {
        SortedMap<BigDecimal, Location> distance = new TreeMap<BigDecimal, Location>();
        List<Location> locations = new ArrayList<Location>();
        int i = 0;
        for (String row : board) {
            if (row.contains("d")) {
                for (int k = 0; k < board.length; k++) {
                    if (row.charAt(k) == 'd') {
                        locations.add(new Location(i, k));
                    }
                }
            }
            i++;
        }

        for (Location location : locations) {
            BigDecimal dist = measureDistance(location, roomba);
            if(!distance.containsKey(dist)) {
                distance.put(dist, location);
            }
        }
        return distance.get(distance.firstKey());
    }

    private static BigDecimal measureDistance(Location location, Location roomba) {
        BigDecimal x = BigDecimal.valueOf(Math.pow((location.getX() - roomba.getX()), 2));
        BigDecimal y = BigDecimal.valueOf(Math.pow((location.getY() - roomba.getY()), 2));

        return BigDecimal.valueOf(Math.sqrt(x.doubleValue()+y.doubleValue()));
    }

    private static Location checkDiagnol(String[] board, Location roomba) {
        int x = roomba.getX();
        int y = roomba.getY();
        int length = board.length - 1;
        if (y > 0 && x > 0) {
            if (board[x].charAt(y - 1) == 'd') { //check upperleft
                return new Location(x - 1, y - 1);
            }
        }
        if (x > 0 && y < length) {
            if (board[x - 1].charAt(y) == 'd') { //check upperright
                return new Location(x - 1, y + 1);
            }
        }
        if (x < length && y < length) {
            if (board[x].charAt(y + 1) == 'd') { //check lowerright
                return new Location(x + 1, y + 1);
            }
        }
        if (x < length && y > 0) {
            if (board[x + 1].charAt(y) == 'd') { //check lowerleft
                return new Location(x + 1, y - 1);
            }
        }
        return null;
    }

    private static Location checkImmediate(String[] board, Location roomba) {
        int x = roomba.getX();
        int y = roomba.getY();
        int length = board.length - 1;
        if (y > 0) {
            if (board[x].charAt(y - 1) == 'd') { //check left
                return new Location(x, y - 1);
            }
        }
        if (x > 0) {
            if (board[x - 1].charAt(y) == 'd') { //check up
                return new Location(x - 1, y);
            }
        }
        if (y < length) {
            if (board[x].charAt(y + 1) == 'd') { //check right
                return new Location(x, y + 1);
            }
        }
        if (x < length) {
            if (board[x + 1].charAt(y) == 'd') { //check down
                return new Location(x + 1, y);
            }
        }
        return null;
    }

    private static boolean checkIfOnDust(String[] board, Location roomba) {
        return board[roomba.getX()].charAt(roomba.getY()) == 'd';
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
