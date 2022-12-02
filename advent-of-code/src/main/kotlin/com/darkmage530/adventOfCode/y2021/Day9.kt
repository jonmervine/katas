package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import java.util.LinkedList
import kotlin.streams.toList

class Day9 {
    fun part1(inputData: List<String>) {
        val graph: List<List<Int>> = inputData.stream().map { it.toList() }.map { it.map { it.digitToInt() } }.toList()
        val lows = mutableListOf<Int>()
        for (y in graph.indices) {
            for (x in 0 until graph[y].size) {
                val left = graph[y].getOrElse(x - 1) { 9 }
                val right = graph[y].getOrElse(x + 1) { 9 }
                val above = graph.getOrElse(y - 1) { emptyList() }.getOrElse(x) { 9 }
                val below = graph.getOrElse(y + 1) { emptyList() }.getOrElse(x) { 9 }
                if (graph[y][x] < setOf(left, right, above, below).minOf { it }) {
                    lows.add(graph[y][x])
                }
            }
        }
        println(lows.sum() + lows.size)
    }

    fun part2(inputData: List<String>) {
        val graph: List<MutableList<Int>> = inputData.stream().map { it.toMutableList() }.map { charArray -> charArray.map { it.digitToInt() } }.toList() as List<MutableList<Int>>
        val basins: MutableList<List<Int>> = mutableListOf()
        for (y in graph.indices) {
            for (x in 0 until graph[y].size) {
                if (graph[y][x] != 9) {
                    val basin = roughNodeSearch(graph, y, x)
                    basins.add(basin)
                }
            }
        }
//        println(basins)
//        println(basins.map { it.size } .sorted())
        val total = basins.map { it.size } .sorted().reversed().slice( IntRange(0, 2) ).reduce{acc, b -> acc * b}
        println(total)
    }

    private fun roughNodeSearch(graph: List<MutableList<Int>>, startingY: Int, startingX: Int): List<Int> {
        val buildBasin = mutableListOf<Int>()

        val queue: LinkedList<Pair<Int, Int>> = LinkedList()
        queue.add(Pair(startingY, startingX))
        while(queue.isNotEmpty()) {
//            println(queue)
            val coord = queue.pop()
            val y = coord.first
            val x = coord.second
//            println("$coord and ${graph[y][x]}")
            if (graph[y][x] != 9) {
                buildBasin.add(graph[y][x])
                graph[y][x] = 9
            }
            val left = graph[y].getOrElse(x - 1) { 9 }
            if (left != 9) {
//                println("add left $left")
                queue.add(Pair(y, x-1))
            }
            val right = graph[y].getOrElse(x + 1) { 9 }
            if (right != 9) {
//                println("add right $right")
                queue.add(Pair(y, x+1))
            }
            val above = graph.getOrElse(y - 1) { emptyList() }.getOrElse(x) { 9 }
            if (above != 9) {
//                println("add above $above")
                queue.add(Pair(y-1, x))
            }
            val below = graph.getOrElse(y + 1) { emptyList() }.getOrElse(x) { 9 }
            if (below != 9) {
//                println("add below $below")
                queue.add(Pair(y+1, x))
            }
        }
//        println("done add $buildBasin")
        return buildBasin
    }
}

fun main() {
//    val inputData = getTestInputLines(testData)
    val inputData = getTestFileLines("y2021/Day9.txt")
    Day9().part1(inputData)
    Day9().part2(inputData)
}

private const val testData = "2199943210\n" +
        "3987894921\n" +
        "9856789892\n" +
        "8767896789\n" +
        "9899965678"