package com.darkmage530.codewars.kyu7;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.codewars.com/kata/tv-remote
 */
public class TvRemote {

    public static void main(String[] args) {
        TvRemote.tvRemote("hello");
    }

    Cursor cursor = new Cursor();

    private static final char[][] remoteLayout = {
            {'a','b','c','d','e','1','2','3'},
            {'f','g','h','i','j','4','5','6'},
            {'k','l','m','n','o','7','8','9'},
            {'p','q','r','s','t','.','@','0'},
            {'u','v','w','x','y','z','_','/'}
    };

    TvRemote() {
        int y = 0;
        for (char[] row : remoteLayout) {
            int x = 0;
            for (char character : row) {
                coordinateLookup.put(character, new Point(x,y));
                x++;
            }
            y++;
        }
    }

    private Map<Character, Point> coordinateLookup = new HashMap<>();

    public static int tvRemote(final String word) {
        TvRemote tvRemote = new TvRemote();

        return tvRemote.getCursorMoves(word);
    }

    int getCursorMoves(String word) {
        int moves = 0;
        for (char character : word.toCharArray()) {
            Point point = findNextCharacter(character);
            Point currentPoint = cursor.getCursor();
            while (!currentPoint.equals(point)) {
                cursor.moveCursor(point);
                currentPoint = cursor.getCursor();
                moves++;
            }
            select();
            moves++;
        }
        return moves;
    }

    char select() {
        return cursor.select();
    }

    Point findNextCharacter(char character) {
        return coordinateLookup.get(character);
    }


    class Cursor {
        //Starts at character 'a' at 0,0
        private int horizontalPosition = 0;
        private int verticalPosition = 0;

        char select() {
            return remoteLayout[verticalPosition][horizontalPosition];
        }

        Point getCursor() {
            return new Point(horizontalPosition, verticalPosition);
        }

        void moveCursor(Point point) {
            if (point.x > horizontalPosition) {
                moveRight();
            } else if (point.x < horizontalPosition) {
                moveLeft();
            } else if (point.y > verticalPosition) {
                moveDown();
            } else if (point.y < verticalPosition) {
                moveUp();
            }
        }

        void moveUp() {
            if (verticalPosition != 0) {
                verticalPosition--;
            }
        }

        void moveDown() {
            if (verticalPosition != remoteLayout.length-1) {
                verticalPosition++;
            }
        }

        void moveLeft() {
            if (horizontalPosition != 0) {
                horizontalPosition--;
            }
        }

        void moveRight() {
            if (horizontalPosition != remoteLayout[0].length-1) {
                horizontalPosition++;
            }
        }
    }
}
