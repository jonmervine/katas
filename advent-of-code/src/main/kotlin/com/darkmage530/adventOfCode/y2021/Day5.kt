package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines
import kotlin.math.abs

class Day5 {

    fun part1(inputText: List<String>) {
        val chart: MutableList<MutableList<Int>> = MutableList(1000){ MutableList(1000){ 0 }.toMutableList() }.toMutableList()

        for (line: String in inputText) {
            val coords = line.split("\\D+".toRegex())
            val origin: Pair<Int, Int> = Pair(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]))
            val target: Pair<Int, Int> = Pair(Integer.parseInt(coords[2]), Integer.parseInt(coords[3]))

            if (origin.first == target.first) {
                for (i in (if (origin.second < target.second) origin.second..target.second else target.second .. origin.second)) {
                    chart[origin.first][i]++
                }
            } else if (origin.second == target.second) {
                for (i in (if (origin.first < target.first) origin.first .. target.first else target.first .. origin.first)) {
                    chart[i][origin.second]++
                }
            }
        }
        var overlaps = 0

        chart.forEach { it.forEach {derp -> if (derp > 1) overlaps++} }
        println(overlaps)
    }

    fun part2(inputText: List<String>) {
        val chart: MutableList<MutableList<Int>> = MutableList(1000){ MutableList(1000){ 0 }.toMutableList() }.toMutableList()

        for (line: String in inputText) {
            val coords = line.split("\\D+".toRegex())
            val origin: Pair<Int, Int> = Pair(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]))
            val target: Pair<Int, Int> = Pair(Integer.parseInt(coords[2]), Integer.parseInt(coords[3]))

            if (origin.first == target.first) {
                for (i in (if (origin.second < target.second) origin.second..target.second else target.second .. origin.second)) {
                    chart[origin.first][i]++
                }
            } else if (origin.second == target.second) {
                for (i in (if (origin.first < target.first) origin.first .. target.first else target.first .. origin.first)) {
                    chart[i][origin.second]++
                }
            } else {
                var x1 = origin.first
                var y1 = origin.second
                var x2 = target.first
                var y2 = target.second

                val xdirection = if (x1 < x2) 1 else -1
                val ydirection = if (y1 < y2) 1 else -1

                for (i in 0 .. abs(x1 - x2)) {
                    chart[x1][y1]++
                    x1 += xdirection
                    y1 += ydirection
                }
            }
        }
        var overlaps = 0

        chart.forEach { it.forEach {derp -> if (derp > 1) overlaps++} }
        println(overlaps)
    }
}

fun main() {
//    val inputText = getTestInputLines(testInput)
    val inputText = getTestFileLines("Day5.txt")
    Day5().part1(inputText)
    Day5().part2(inputText)
}

private const val testInput = "0,9 -> 5,9\n" +
        "8,0 -> 0,8\n" +
        "9,4 -> 3,4\n" +
        "2,2 -> 2,1\n" +
        "7,0 -> 7,4\n" +
        "6,4 -> 2,0\n" +
        "0,9 -> 2,9\n" +
        "3,4 -> 1,4\n" +
        "0,0 -> 8,8\n" +
        "5,5 -> 8,2"

