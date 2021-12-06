package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getSingleTestFileLine
import com.darkmage530.adventOfCode.getSingleTestInputLines
import java.math.BigInteger

class Day6 {
    fun part1(testData: List<String>) {
        var radixBasedTable: MutableList<Int> = MutableList(9){0}
        for(fish in testData) {
            radixBasedTable[Integer.parseInt(fish)]++
        }

        var altRadixTable: MutableList<Int> = MutableList(9){0}
        for (i in 1..80) {
            for (y in 1..8) {
                altRadixTable[y-1] = radixBasedTable[y]
            }
            val spawningFish = radixBasedTable[0]
            altRadixTable[6] += spawningFish
            altRadixTable[8] = spawningFish
            radixBasedTable = altRadixTable.toMutableList()
            altRadixTable = MutableList(9){0}
        }
        val totalFish = radixBasedTable.sum()
        println("totalFish: $totalFish")
    }

    fun part2(testData: List<String>) {
        var radixBasedTable: MutableList<BigInteger> = MutableList(9){ BigInteger.ZERO}
        for(fish in testData) {
            radixBasedTable[Integer.parseInt(fish)]++
        }

        var altRadixTable: MutableList<BigInteger> = MutableList(9){ BigInteger.ZERO}
        for (i in 1..256) {
            for (y in 1..8) {
                altRadixTable[y-1] = radixBasedTable[y]
            }
            val spawningFish = radixBasedTable[0]
            altRadixTable[6] += spawningFish
            altRadixTable[8] = spawningFish
            radixBasedTable = altRadixTable.toMutableList()
            altRadixTable = MutableList(9){ BigInteger.ZERO}
        }
        val totalFish = radixBasedTable.sumOf { it }
        println("totalFish: $totalFish")
    }
}

fun main() {
//    val testData = getSingleTestInputLines(testInput, ",")
    val testData = getSingleTestFileLine("Day6.txt", ",")
    Day6().part1(testData)
    Day6().part2(testData)
}

private const val testInput = "3,4,3,1,2"