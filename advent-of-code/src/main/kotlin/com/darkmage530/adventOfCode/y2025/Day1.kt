package com.darkmage530.adventOfCode.y2025

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

fun main() {
    Day1().apply {
        password2()
    }
}

class Day1 {

    val testInput = """L68
L30
R48
L5
R60
L55
L1
L99
R14
L82"""
    fun password() {
        var dial = 50
        var countZeros = 0

//        for (line in getTestInputLines(testInput)) {
        for (line in getTestFileLines("y2025/Day1.txt")) {
            val (direction, amount) = parseLine(line)
            dial = if (direction == "L") {
                dial - amount
            } else {
                dial + amount
            }

            print("$line ($dial)")

            while (dial > 99  || dial < 0) {
                dial = if (dial > 99) {
                    dial - 100
                } else {
                    dial + 100
                }
            }

            println(" -> $dial")

            if (dial == 0) {
                countZeros++
            }
        }
        println(countZeros)
    }

    fun password2() {
        var dial = 50
        var countZeros = 0

        for (line in getTestInputLines(testInput)) {
//        for (line in getTestFileLines("y2025/Day1.txt")) {
            val (direction, amount) = parseLine(line)
            dial = if (direction == "L") {
                dial - amount
            } else {
                dial + amount
            }

            print("$line ($dial)")

            while (dial > 99  || dial < 0) {
                dial = if (dial > 99) {
                    countZeros++
                    dial - 100
                } else {
                    countZeros++
                    dial + 100
                }
            }

            print(" -> $dial")

            if (dial == 0) {
                countZeros++
            }
            println(" = $countZeros")
        }
        println(countZeros)
    }

    private fun parseLine(line: String): Pair<String, Int> {
        return Pair(line[0].toString(), line.drop(1).toInt())
    }
}