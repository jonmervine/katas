package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines

/**
 * Don't look, it's hideous! I should make this uh more programmatic later instead of just
 * "how many of xyz is there?"
 */
class Day2 : AocBase {

    override fun part1(input: List<String>): String {
        /*
        A Rock
        B Paper
        C Scissors
        X Rock
        Y Paper
        Z Scissors

        Wins
        A Y
        B Z
        C X

        Losses
        A Z
        B X
        C Y

        Draws
        A X
        B Y
        C Z
         */
        val wins = listOf("A Y", "B Z", "C X")
        val loses = listOf("A Z", "B X", "C Y")
        val draws = listOf("A X", "B Y", "C Z")

        var total = 0
        for (line in input) {
            when (line.last()) {
                'X' -> total++
                'Y' -> total += 2
                'Z' -> total += 3
            }

            if (wins.contains(line)) total += 6
            else if (loses.contains(line)) total += 0
            else if (draws.contains(line)) total += 3
            else println("line not recognized $line")
        }

        return total.toString()
    }

    override fun part2(input: List<String>): String {
        /*
A Rock
B Paper
C Scissors
X Rock
Y Paper
Z Scissors

Rock
A Y
B X
C Z

Paper
C X
A Z
B Y

Scissors
B Z
C Y
A X
 */

        val rock = listOf("A Y", "B X", "C Z")
        val paper = listOf("C X", "A Z", "B Y")
        val scissors = listOf("B Z", "C Y", "A X")

        var total = 0
        for (line in input) {
            when (line.last()) {
                'X' -> total += 0
                'Y' -> total += 3
                'Z' -> total += 6
            }

            if (rock.contains(line)) total += 1
            else if (paper.contains(line)) total += 2
            else if (scissors.contains(line)) total += 3
            else println("line not recognized $line")
        }

        return total.toString()
    }
}

fun main() {
    Day2().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}