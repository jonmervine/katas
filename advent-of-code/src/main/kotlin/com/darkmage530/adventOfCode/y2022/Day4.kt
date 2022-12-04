package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines
import kotlin.math.exp
import kotlin.streams.asSequence

class Day4 : AocBase {

    fun buildRange(pair: String) = run {
        val explodedRange = mutableSetOf<Int>()
        pair.split('-').let { (a, b) ->
            for (i in a.toInt()..b.toInt()) {
                explodedRange.add(i)
            }
        }
        explodedRange
    }

    override fun part1(input: List<String>): String {
        var fullyContainedPairs = 0
        for (pairs in input) {
            val (pair1, pair2) = pairs.split(',')
            val range1 = buildRange(pair1)
            val range2 = buildRange(pair2)
            val union = range1.union(range2)

            if (union == range1)
                fullyContainedPairs++
            else if (union == range2)
                fullyContainedPairs++
        }

        return fullyContainedPairs.toString()
    }

    override fun part2(input: List<String>): String {
        var fullyContainedPairs = 0
        for (pairs in input) {
            val (pair1, pair2) = pairs.split(',')
            val range1 = buildRange(pair1)
            val range2 = buildRange(pair2)

            val intersect = range1.union(range2)
            if (intersect.size < (range1.size + range2.size))
                fullyContainedPairs++
        }

        return fullyContainedPairs.toString()
    }
}

fun main() {
    Day4().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}