package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines

class Day1 : AocBase {
//    override val testInputFile: String = ""
    //
//    private fun createInputFile =

//    init {
//        val filename =
//        println(filename)

//        println(this::class.qualifiedName)
//
//        println(this::class.java.`package`)
//        println(this::class.java.packageName)
//    }

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

    override fun part1(input: List<String>) =
        input
            .map { line -> line.toIntOrNull() }
            .sumElfCalories()
            .maxOrNull()!!
            .toString()

    override fun part2(input: List<String>): String =
        input
            .map { line -> line.toIntOrNull() }
            .sumElfCalories()
            .sorted()
            .takeLast(3)
            .sum()
            .toString()
}

fun main() {
    Day1().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}

