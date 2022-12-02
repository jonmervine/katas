package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getSingleTestFileLine
import kotlin.math.absoluteValue
import kotlin.math.roundToInt

class Day7 {
    fun getPivot(sorted: List<Int>): Int {
        return if (sorted.size %2 == 1) sorted[(sorted.size - 1) / 2] else ((sorted[(sorted.size/2)-1] + sorted[sorted.size/2])/2.0).roundToInt()
    }

    fun calculateFuel(sorted: List<Int>, pivot: Int, calculationFormula: (Int, Int) -> Int): Int {
        var countFuel = 0
        sorted.forEach { countFuel += calculationFormula(pivot, it) }
        return countFuel
    }

    val simpleIteratingFunction: (Int, Int) -> Int = { pivot: Int, n: Int -> (pivot - n).absoluteValue }
    val complexIteratingFunction: (Int, Int) -> Int = { pivot: Int, iter: Int ->  val n = (pivot - iter).absoluteValue
        ((n * n + n) / 2) }

    fun part1(testData: List<String>) {
        val sorted = testData.map { it.toInt() }.sorted()
        var pivot = getPivot(sorted)

        val countFuel = calculateFuel(sorted, pivot, simpleIteratingFunction)

        println(countFuel)
    }

    fun part2(testData: List<String>) {
        val sorted = testData.map { it.toInt() }.sorted()
        var pivot = getPivot(sorted)

        val pivotPlus1 = pivot + 1
        val pivotMinus1 = pivot - 1

        val countFuelPlus = calculateFuel(sorted, pivotPlus1, complexIteratingFunction)
        val countFuel = calculateFuel(sorted, pivot, complexIteratingFunction)
        val countFuelMinus = calculateFuel(sorted, pivotMinus1, complexIteratingFunction)

//        println("pivot $pivot plus1: $countFuelPlus pivot $countFuel minus1 $countFuelMinus")

        var mostLeastFuel = countFuel
        var direction = if (countFuelMinus < countFuelPlus) -1 else 1
        println(direction)

        while (calculateFuel(sorted, pivot + direction, complexIteratingFunction) < mostLeastFuel) {
            mostLeastFuel = calculateFuel(sorted, pivot + direction, complexIteratingFunction)
            pivot += direction
//            println("$mostLeastFuel and new pivot $pivot")
        }
        println(mostLeastFuel)
    }
}

fun main() {
//    val testData = getSingleTestInputLines(testInput, ",")
    val testData = getSingleTestFileLine("y2022/Day7.txt", ",")
    Day7().part1(testData)
    Day7().part2(testData)
}

private const val testInput: String = "16,1,2,0,4,2,7,1,2,14"
