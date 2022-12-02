package com.darkmage530.adventOfCode.y2021

import java.io.File

class Day1 {

    fun day1() {
        var previous = Int.MAX_VALUE
        var totalGreater = 0
        File("advent-of-code/src/main/resources/y2021/Day1.txt").forEachLine {
            if (Integer.parseInt(it) > previous)
                totalGreater++
            previous = Integer.parseInt(it)
        }
        println(totalGreater)
    }

    fun part2() {

//        val depths: List<Int> = input.split("\n").map { Integer.parseInt(it) }
        val depths: List<Int> = File("advent-of-code/src/main/resources/y2021/Day1.txt").readLines().map { Integer.parseInt(it) }
        var total = 0
        var prevSum = Int.MAX_VALUE
        for (i in 0..(depths.size - 3)) {
            val currentSum = depths[i] + depths[i +1] + depths[i + 2]
            if (currentSum > prevSum) {
                total++
            }
            prevSum = currentSum
        }
        println(total)
    }
}

fun main() {
    Day1().day1()
    Day1().part2()
}

private const val input = "199\n" +
        "200\n" +
        "208\n" +
        "210\n" +
        "200\n" +
        "207\n" +
        "240\n" +
        "269\n" +
        "260\n" +
        "263"

private const val input2 = "199  A      \n" +
        "200  A B    \n" +
        "208  A B C  \n" +
        "210    B C D\n" +
        "200  E   C D\n" +
        "207  E F   D\n" +
        "240  E F G  \n" +
        "269    F G H\n" +
        "260      G H\n" +
        "263        H"