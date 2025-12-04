package com.darkmage530.adventOfCode.y2025

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

fun main() {
    Day3().apply {
//        part1()
        part2()
    }
}

class Day3 {

    val testInput = """987654321111111
811111111111119
234234234234278
818181911112111"""

    //17281
    fun part1() {
        var sum = 0
//        for (line in getTestInputLines(testInput)) {
        for (line in getTestFileLines("y2025/Day3.txt")) {
            val (firstDigit, firstDigitIndex) = findNextLargest(line, 0, 2)
            var secondDigit = 0
            for (i in firstDigitIndex+1..line.length-1) {
                if (line[i].digitToInt() > secondDigit) {
                    secondDigit = line[i].digitToInt()
                }
            }
            val lineBattery = (firstDigit * 10) + secondDigit
            println(lineBattery)
            sum += lineBattery
        }
        println(sum)
    }

    fun part2() {
        var sum = 0L
//        for (line in getTestInputLines(testInput)) {
        for (line in getTestFileLines("y2025/Day3.txt")) {
            var nextDigitIndex = 0
            var digitsStr = ""
            for (i in 12 downTo 2) {
                val (firstDigit, firstDigitIndex) = findNextLargest(line, nextDigitIndex, i)
                nextDigitIndex = firstDigitIndex+1
                digitsStr += firstDigit.toString()
            }

            var lastDigit = 0
            for (i in nextDigitIndex..line.length-1) {
                if (line[i].digitToInt() > lastDigit) {
                    lastDigit = line[i].digitToInt()
                }
            }
            val lineBattery = (digitsStr + lastDigit.toString()).toLong()
            println(lineBattery)
            sum += lineBattery
        }
        println(sum)
    }

    fun findNextLargest(line: String, startingIndex: Int, limit: Int): Pair<Int, Int> {
//        println("$line <- start: $startingIndex limit: $limit ")
        var highestDigit = 0
        var highestDigitIndex = 0
        for (i in startingIndex..line.length-limit) {
            if (line[i].digitToInt() > highestDigit) {
                highestDigit = line[i].digitToInt()
                highestDigitIndex = i
            }
        }
//        println("highest: $highestDigit highestIndex: $highestDigitIndex")
        return highestDigit to highestDigitIndex
    }
}