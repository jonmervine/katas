package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestFileLines

class Day1 {

    /**
     * List of Calories is broken with nulls indicating a new elf
     * Using a 'Stack' we want to pop, add, and re-push calories to sum for a single elf
     * Each new elf gets 0 pushed to it to start a new sum
     */
    private fun List<Int?>.sumElfCalories(): List<Int> =
        this.fold(ArrayDeque()) { acc, next ->
            if (next == null) acc.addLast(0) else {
                if (acc.isEmpty())
                    acc.addLast(next)
                else {
                    acc.addLast(
                        acc.removeLast().plus(next)
                    )
                }
            }
            acc
        }

    fun part1(inputLines: List<String>) =
        inputLines
            .map { line -> line.toIntOrNull() }
            .sumElfCalories()
            .maxOrNull()!!

    fun part2(inputLines: List<String>) =
        inputLines
            .map { line -> line.toIntOrNull() }
            .sumElfCalories()
            .sorted()
            .takeLast(3)
            .sum()
}

const val y2022Day1 = "2022/Day1.txt"
fun main() {
    Day1().apply {
        println(part1(getTestFileLines(y2022Day1)))
        println(part2(getTestFileLines(y2022Day1)))
    }
}

