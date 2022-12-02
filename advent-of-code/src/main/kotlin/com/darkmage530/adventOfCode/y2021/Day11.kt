package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines
import kotlin.streams.toList

class Day11 {

    var totalFlashes = 0
    data class Tako(var value: Int, var flashed: Boolean = false)
    fun Tako.canFlash(): Boolean { return this.value > 9 && !this.flashed }

    private fun flashTako(takos: List<List<Tako>>, y: Int, x: Int) {
        val currentTako = takos[y][x]
        currentTako.flashed = true
        totalFlashes++

        val topLeft = takos.getOrElse(y-1) {emptyList()}.getOrElse(x-1) {Tako(0, true)}
        topLeft.value++
        if (topLeft.canFlash()) {
            flashTako(takos, y-1, x-1)
        }
        val above = takos.getOrElse(y-1) {emptyList()}.getOrElse(x) {Tako(0, true)}
        above.value++
        if (above.canFlash()) {
            flashTako(takos, y-1, x)
        }
        val topRight = takos.getOrElse(y-1) {emptyList()}.getOrElse(x+1) {Tako(0, true)}
        topRight.value++
        if (topRight.canFlash()) {
            flashTako(takos, y-1, x+1)
        }

        val left = takos.getOrElse(y) {emptyList()}.getOrElse(x-1) {Tako(0, true)}
        left.value++
        if (left.canFlash()) {
            flashTako(takos, y, x-1)
        }
        val right = takos.getOrElse(y) {emptyList()}.getOrElse(x+1) {Tako(0, true)}
        right.value++
        if (right.canFlash()) {
            flashTako(takos, y, x+1)
        }

        val bottomLeft = takos.getOrElse(y+1) {emptyList()}.getOrElse(x-1) {Tako(0, true)}
        bottomLeft.value++
        if (bottomLeft.canFlash()) {
            flashTako(takos, y+1, x-1)
        }
        val below = takos.getOrElse(y+1) {emptyList()}.getOrElse(x) {Tako(0, true)}
        below.value++
        if (below.canFlash()) {
            flashTako(takos, y+1, x)
        }
        val bottomRight = takos.getOrElse(y+1) {emptyList()}.getOrElse(x+1) {Tako(0, true)}
        bottomRight.value++
        if (bottomRight.canFlash()) {
            flashTako(takos, y+1, x+1)
        }
    }
    fun part1(testInput: List<String>) {
        val takos: List<List<Tako>> = testInput.stream().map { it.toList() }.map { charArray -> charArray.map { Tako(it.digitToInt()) } }.toList()

        for (days in 0..99) {
        //incremenet everyone on step
        for (y in 0..9) {
            for (x in 0..9) {
                takos[y][x].value++
            }
        }

        //flash everyone
        for (y in 0..9) {
            for (x in 0..9) {
                if (takos[y][x].canFlash()) {
                    flashTako(takos, y, x)
                }
            }
        }

        //reset
        for (y in 0..9) {
            for (x in 0..9) {
                takos[y][x].flashed = false
                if (takos[y][x].value > 9) takos[y][x].value = 0
            }
            }

//        takos.forEach{ println(it.map{it.value}.joinToString("", "", "") { it.toString() })}
//        println("")
//        println("")
        }
        println(totalFlashes)
    }

    fun part2(testInput: List<String>) {
        val takos: List<List<Tako>> = testInput.stream().map { it.toList() }.map { charArray -> charArray.map { Tako(it.digitToInt()) } }.toList()

        for (days in 0..500) {
            //incremenet everyone on step
            for (y in 0..9) {
                for (x in 0..9) {
                    takos[y][x].value++
                }
            }

            //flash everyone
            for (y in 0..9) {
                for (x in 0..9) {
                    if (takos[y][x].canFlash()) {
                        flashTako(takos, y, x)
                    }
                }
            }

            //reset
            var countResets = 0
            for (y in 0..9) {
                for (x in 0..9) {
                    takos[y][x].flashed = false
                    if (takos[y][x].value > 9) {
                        takos[y][x].value = 0
                        countResets++
                    }

                }
            }
            if (countResets == 100) {
                println(days + 1)
            }

//        takos.forEach{ println(it.map{it.value}.joinToString("", "", "") { it.toString() })}
//        println("")
//        println("")
        }
        println(totalFlashes)
    }
}

fun main() {
    val testInput = getTestInputLines(testData)
//    val testInput = getTestFileLines("y2021/Day11.txt")
    Day11().part1(testInput)
    Day11().part2(testInput)
}

private const val testData = "5483143223\n" +
        "2745854711\n" +
        "5264556173\n" +
        "6141336146\n" +
        "6357385478\n" +
        "4167524645\n" +
        "2176841721\n" +
        "6882881134\n" +
        "4846848554\n" +
        "5283751526"