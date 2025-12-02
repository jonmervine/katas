package com.darkmage530.adventOfCode.y2025

import com.darkmage530.adventOfCode.getSingleTestFileLine
import com.darkmage530.adventOfCode.getSingleTestInputLines

fun main() {
    Day2().apply {
//        part1()
        part2()
    }
}

class Day2 {
    val testInput = "11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659," +
            "824824821-824824827,2121212118-2121212124"

    fun part1() {
//        val ranges = getSingleTestInputLines(testInput, ",")
        val ranges = getSingleTestFileLine("y2025/Day2.txt", ",")
        var count = 0L
        ranges.forEach { unparsedRange ->
            val range = parseRange(unparsedRange)
            for (i in range) {
                i.toString().let {
                    val len = it.length
//                    println("${it.substring(len/2, len)} == ${it.substring(0, len/2)}")
                    if (it.substring(len/2, len) == it.substring(0, len/2)) {
//                        println(i)
                        count += i
                    }
                }
            }
        }
        println(count)
    }

    fun part2() {
//        val ranges = getSingleTestInputLines(testInput, ",")
        val ranges = getSingleTestFileLine("y2025/Day2.txt", ",")
        var count = 0L
        ranges.forEach { unparsedRange ->
            val range = parseRange(unparsedRange)
            for (i in range) {
                i.toString().let {
                    for (j in 0..(it.length-1)/2) {
                        val comp = it.substring(0..j)
//                        println("$comp ($it)")
                        var indexCheck = comp.length
//                        print(" $indexCheck")
                        var badId = false
                        while(it.length >= indexCheck + comp.length) {
                            badId = true
                            if (comp != it.substring(indexCheck..indexCheck+j)) {
                                badId = false
                                break
                            }
                            indexCheck += comp.length
                            if (it.length > indexCheck && it.length < indexCheck + comp.length) {
                                badId = false
                                break
                            }
                        }
                        if (badId) {
//                            println(i)
                            count += i
                            break
                        }
                    }
                }
            }
        }
        println(count)
    }

    fun parseRange(strRange: String): LongRange {
        strRange.split("-").let {
            return LongRange(it[0].toLong(), it[1].toLong())
        }
    }
}