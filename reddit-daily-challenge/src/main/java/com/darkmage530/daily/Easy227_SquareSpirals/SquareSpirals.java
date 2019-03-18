package com.darkmage530.daily.Easy227_SquareSpirals;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Mervine on 8/18/2015.
 */

/*
Take a square grid, and put a cross on the center point, like this:

+ + + + +

+ + + + +

+ + X + +

+ + + + +

+ + + + +
The grid is 5-by-5, and the cross indicates point 1. Let's call the top-left corner location (1,1), so the center point is at location
(3,3). Now place another cross to the right, and trace the path:

+ + + + +

+ + + + +

+ + X-X +

+ + + + +

+ + + + +

This second point (point 2) is now at location (4,3). If you continually move around anticlockwise as much as you can
from this point, you will form a square spiral, as this diagram shows the beginning of:

+ + + + +

+ X-X-X .
  |   | .
+ X-X-X .
  |     |
+ X-X-X-X

+ + + + +

your challenge today is to do two things: convert a point number to its location on the spiral and vice versa.

Formal Inputs and Outputs
Input specification
On the first line you'll be given a number S. This is the size of the spiral. If S equals 5, then the grid is a 5-by-5 grid,
as shown in the demonstration above. S will always be an odd number.
You will then be given one of two inpts on the next line:
- You'll be given a single number N - this is the point number of a point on the spiral.
- You'll be given two numbers X and Y (on the smae line separate by a space) - this is the location of a point on the spiral.

Output description
If you're given the point number of a point, work out its location. if you're given a location, find out its point number.

EXAMPLE1:
Where is 8 on this spiral?
5-4-3
|   |
6 1-2
|
7-8-9

Input
3
8

Output (2,3)

Example 2
This corresponds to the top-left point (1,1) in this 7-by-7 grid
Input
7
1 1
Output
37

Example 3
Input
11
50

Output
(10,9)

Example 4
Input
9
6 8

Output
47

Example 5
Input
1024716039
557614022

Output
(512353188, 512346213)

Example 6
Input
234653477
11777272 289722

Output
54790653381545607

 */
public class SquareSpirals {
    private final String inputFile = "C:/Me/C/git/DailyChallenge/src/Easy227_SquareSpirals/Easy227Input.txt";

    public List<String> readInput() {
        List<String> input = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(inputFile)));
            Iterator it = br.lines().iterator();
            while (it.hasNext()) {
                input.add(it.next().toString());
            }
            return input;
        } catch (FileNotFoundException ex) {
            return input;
        }
    }

    public static void main(String[] args) {
        SquareSpirals service = new SquareSpirals();
//        List<String> input = service.readInput();
//        for(String line : input) {
            service.findCoordinate(3, 8);
//        }
    }

    public void findCoordinate(long size, long numToFind) {
        long center = (size/2)+1;
        long bottomRight = size * size;


    }
}
