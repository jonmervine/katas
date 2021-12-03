package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import java.util.stream.Collectors

class Day3 {
    private fun inverseBinary(bitString: String) = bitString.toCharArray().map { if (it == '1') "0" else "1" }.stream().collect(Collectors.joining())

    fun part1(inputLines: List<String>) {
        val cutOff = inputLines.size / 2
        val counter = List(inputLines.first().length) { 0 }.toMutableList()

        inputLines.stream().forEach {
            var i = 0;
            it.toCharArray().forEach {
                c -> counter[i++] += Character.getNumericValue(c)
            }
        }

        val bitString = counter.stream().map { if (it > cutOff) "1" else "0" }.collect(Collectors.joining())
        val reverseBitString = inverseBinary(bitString)

        val firstDecimal = bitString.toInt(2)
        val secondDecimal = reverseBitString.toInt(2)
        println("$bitString = $firstDecimal and $reverseBitString = $secondDecimal multiplied = ${firstDecimal * secondDecimal}")
    }

    fun part2(inputLines: List<String>) {

        val allInputLines = inputLines.stream().map { it.toCharArray().toList() }.collect(Collectors.toList())

        val co2Scrubber = allInputLines.toMutableList().filterDiagnosticReport(Co2Scrubber)
        val oxygenGenerator = allInputLines.toMutableList().filterDiagnosticReport(OxygenGenerator)

        println(oxygenGenerator * co2Scrubber)
    }

    private val OxygenGenerator = { ones: Int, zeroes: Int -> if (ones < zeroes) '0' else '1' }
    private val Co2Scrubber = { ones: Int, zeroes: Int -> if (ones < zeroes) '1' else '0' }

    private fun MutableList<List<Char>>.countOnes(index: Int): Int {
        return this.stream().collect(Collectors.summingInt{ Character.getNumericValue(it[index])})
    }

    private fun MutableList<List<Char>>.filterDiagnosticReport(DiagnosticReportFilter: (Int, Int) -> Char): Int {
        var copyMutableList = this
        var index = 0
        do {
            val ones = copyMutableList.countOnes(index)
            val zeroes = copyMutableList.size - ones
            copyMutableList = copyMutableList.stream().filter{ it[index] == DiagnosticReportFilter(ones, zeroes) }.collect(Collectors.toList())
            index++
        } while(copyMutableList.size > 1)
        return copyMutableList[0].stream().map{it.toString()}.collect(Collectors.joining()).toInt(2)
    }
}

fun main() {
//    val testInput = getTestInputLines(testInput)
    val testInput = getTestFileLines("Day3.txt")
    Day3().part1(testInput)
    Day3().part2(testInput)
}

private const val testInput = "00100\n" +
        "11110\n" +
        "10110\n" +
        "10111\n" +
        "10101\n" +
        "01111\n" +
        "00111\n" +
        "11100\n" +
        "10000\n" +
        "11001\n" +
        "00010\n" +
        "01010"
