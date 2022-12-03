package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines
import kotlin.streams.asSequence


private const val BETWEEN_CHAR_CASES = 93
private const val DIFFERENCE_OF_CHAR_FOR_UPPERCASE = 38
private const val DIFFERENCE_OF_CHAR_FOR_LOWERCASE = 96

class Day3 : AocBase {
    override fun part1(input: List<String>) = input.fold(0) { acc, next ->
        next.substring(0, next.length / 2)
            .chars().asSequence().toSet()
            .intersect(
                next.substring(next.length / 2)
                    .chars().asSequence().toSet()
            ).first()
            .let { ascii ->
                if (ascii < BETWEEN_CHAR_CASES)
                    ascii - DIFFERENCE_OF_CHAR_FOR_UPPERCASE
                else
                    ascii - DIFFERENCE_OF_CHAR_FOR_LOWERCASE
            }.plus(acc)
    }.toString()

    override fun part2(input: List<String>): String {
        TODO("Not yet implemented")
    }
}

fun main() {
    Day3().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}