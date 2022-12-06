package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines
import kotlin.streams.toList

class Day6 : AocBase {

    fun findMarker(input: String, markerSize: Int): String {
        ArrayDeque<Int>().let { queue ->
            input.chars().toList().forEachIndexed { index, c ->
                queue.add(c)
                if (queue.size == markerSize) {
                    if (queue.distinct().size == markerSize) {
                        return (index + 1).toString()
                    }
                    queue.removeFirst()
                }
            }
        }
        return "uh failed"
    }

    override fun part1(input: List<String>): String = findMarker(input.first(), 4)

    override fun part2(input: List<String>): String = findMarker(input.first(), 14)

}

fun main() {
    Day6().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}