package com.darkmage530.katas.argo.wrapper;

/**
 * User: Jon
 * Date: 7/25/13
 * Time: 7:36 PM
 */
public class Wrapper {
/*    public static String wrap(String s, int col) {
        if(s.length() <= col)
            return s;
        int space = (s.substring(0, col).lastIndexOf(' '));
        if(space != -1)
            return (s.substring(0, space) + "\n" + wrap(s.substring(space+1), col));
        else
            return (s.substring(0, col) + "\n" + wrap(s.substring(col), col));
    }*/

    public static String wrap(String s, int col) {
        Wrapper wrapper = new Wrapper(col);
        return wrapper.wrap(s);
    }

    private Wrapper(int col) {
        this.col = col;
    }

    private int col;

    private String wrap(String s) {
        if(s.length() <= col)
            return s;
        int space = (s.substring(0, col).lastIndexOf(' '));
        if(space != -1)
            return breakLine(s, space, 1);
        else if(s.charAt(col) == ' ')
            return breakLine(s, col, 1);
        else
            return breakLine(s, col, 0);
    }

    private String breakLine(String s, int pos, int gap) {
        return s.substring(0, pos) + "\n" + wrap(s.substring(pos + gap));
    }
}
