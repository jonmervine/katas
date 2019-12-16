package com.darkmage530.codewars.kyu7;

public class TvRemote {

    Cursor cursor = new Cursor();
    private static final char[][] remoteLayout = {
            {'a','b','c','d','e','1','2','3'},
            {'f','g','h','i','j','4','5','6'},
            {'k','l','m','n','o','7','8','9'},
            {'p','q','r','s','t','.','@','0'},
            {'u','v','w','x','y','z','_','/'}
    };

    public static void main(String[] args) {
        TvRemote.tvRemote("hello");
    }

    public static int tvRemote(final String word) {
        TvRemote tvRemote = new TvRemote();

        return 1;
    }

    char select() {
        return cursor.select();
    }

    void findNextCharacter() {

    }


    class Cursor {
        //Starts at character 'a' at 0,0
        private int horizontalPosition = 0;
        private int verticalPosition = 0;

        char select() {
            return remoteLayout[verticalPosition][horizontalPosition];
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
