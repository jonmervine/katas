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
        var fishTimers: MutableList<BigInteger> = MutableList(9){ BigInteger.ZERO}
        for(fish in testData) {
            fishTimers[Integer.parseInt(fish)]++
        }

        var tempHolderFishTable: MutableList<BigInteger> = MutableList(9){ BigInteger.ZERO}
        for (i in 1..256) {
            for (y in 1..8) {
                tempHolderFishTable[y-1] = fishTimers[y]
            }
            val spawningFish = fishTimers[0]
            tempHolderFishTable[6] += spawningFish
            tempHolderFishTable[8] = spawningFish
            fishTimers = tempHolderFishTable.toMutableList()
            tempHolderFishTable = MutableList(9){ BigInteger.ZERO}
        }
        val totalFish = fishTimers.sumOf { it }
        println("totalFish: $totalFish")
    }

    fun altPart2(testData: List<String>) {
        var fishTimers: MutableList<BigInteger> = MutableList(9){ BigInteger.ZERO}
        for(fish in testData) {
            fishTimers[Integer.parseInt(fish)]++
        }

        var spawningIndex = 0
        for (i in 1..256) {
            if (spawningIndex == 7) spawningIndex = 0
            val fishToSpawn = fishTimers[spawningIndex]
            fishTimers[(spawningIndex + 7) % 7] += fishTimers[7]
            fishTimers[7] = fishTimers[8]
            fishTimers[8] = fishToSpawn

            spawningIndex++
        }
        val totalFish = fishTimers.sumOf { it }
        println("totalFish: $totalFish")
    }

    private data class FishTimer(var numberOfFish: BigInteger, var next: FishTimer?, var prev: FishTimer?)
}

fun main() {
//    val testData = getSingleTestInputLines(testInput, ",")
    val testData = getSingleTestFileLine("Day6.txt", ",")
    Day6().part1(testData)
    Day6().part2(testData)
    Day6().altPart2(testData)
}

private const val testInput = "3,4,3,1,2"