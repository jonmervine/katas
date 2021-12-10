package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines
import java.math.BigInteger

class Day10 {

    private val points = mapOf(Pair(")", 3), Pair("]", 57), Pair("}", 1197), Pair(">", 25137))

    val left = setOf("(", "[", "{", "<")
    val right = setOf(")", "]", "}", ">")
    val validPairs = setOf(Pair("(", ")"), Pair("{", "}"), Pair("[", "]"), Pair("<", ">"))
    fun part1(testData: List<String>) {
        var totalPoints = 0
        testData.map { it.toList() }.map { it.map { c -> c.toString() } }.forEach { line ->
            val stack = ArrayDeque<String>()
            line.forEach { s ->
                if (left.contains(s)) stack.addFirst(s);
                if (right.contains(s)) {
                    val popped = stack.removeFirst()
                    if (!validPairs.contains(Pair(popped, s))) {
                        totalPoints += points.getOrDefault(s, 0)
                        return@forEach
                    }
                }
            }
        }
        println(totalPoints)
    }

    private val closingPoints = mapOf(Pair("(", 1), Pair("[", 2), Pair("{", 3), Pair("<", 4))
    fun part2(testData: List<String>) {
        val pointsPerLine = mutableListOf<BigInteger>()
        testData.map { it.toList() }.map { it.map { c -> c.toString() } }.forEach First@{ line ->
            val stack = ArrayDeque<String>()
            line.forEach { s ->
                if (left.contains(s)) stack.addFirst(s);
                if (right.contains(s)) {
                    val popped = stack.removeFirst()
                    if (!validPairs.contains(Pair(popped, s))) {
                        return@First
                    }
                }
            }
            var linePoints = BigInteger.ZERO
            while (stack.isNotEmpty()) {
                val popped = stack.removeFirst()
                BigInteger.ONE * BigInteger.TWO
                linePoints *= 5.toBigInteger()
                linePoints += closingPoints[popped]!!.toBigInteger()
            }

            println(linePoints)
            pointsPerLine.add(linePoints)
        }
        println(pointsPerLine)
        println(pointsPerLine.sorted()[pointsPerLine.size / 2])
    }

}

fun main() {
//    val testData = getTestInputLines(testInput)
    val testData = getTestFileLines("Day10.txt")

    Day10().part1(testData)
    Day10().part2(testData)
}

private const val testInput = "[({(<(())[]>[[{[]{<()<>>\n" +
        "[(()[<>])]({[<{<<[]>>(\n" +
        "{([(<{}[<>[]}>{[]{[(<()>\n" +
        "(((({<>}<{<{<>}{[]{[]{}\n" +
        "[[<[([]))<([[{}[[()]]]\n" +
        "[{[{({}]{}}([{[{{{}}([]\n" +
        "{<[[]]>}<{[{[{[]{()[[[]\n" +
        "[<(<(<(<{}))><([]([]()\n" +
        "<{([([[(<>()){}]>(<<{{\n" +
        "<{([{{}}[<[[[<>{}]]]>[]]"