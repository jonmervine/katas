package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

class Day8 {
    fun part1(testData: List<String>) {
        var counter = 0
        for (line in testData) {
            line.split("|").last().split(" ").forEach{if (it.length in setOf(2, 3, 4, 7)) counter++}
        }
        println(counter)
    }

    fun part2(testData: List<String>) {
        /*
        a = [02356789] = 8
        b = [045689] = 6
        c = [01234789] = 8
        d = [2345689] = 7
        e = [0268] = 4
        f = [013456789] = 9
        g = [0235689] = 7

        Unique distributions:
        e = 4
        b = 6
        f = 9

        a, c = 8
        d, g = 7

        Unique lengths:
        1 : c f = 2
        4 : b c d f = 4
        7 : a c f = 3
        8 : a b c d e f g = 7

        0 : a b c e f g = 6
        2 : a c d e g = 5
        3 : a c d f g = 5
        5 : a b d f g = 5
        6 : a b d e f g = 6
        9 : a b c d f g = 6

        a is not in 1 and 4
        c is not in 5 and 6

        digit of 2 one is f the other is c

        0 : a g = 6
        2 : a d g = 5
        3 : a d g = 5
        5 : a d g = 5
        6 : a d g = 6
        9 : a d g = 6
         */

        var total = 0
        for (line in testData) {
            var a=' ';var b=' '; var c=' '; var d=' '; var e=' '; var f=' '; var g=' '
            val splitLine = line.split("|").map { it.trim() }
            val lineDigits = splitLine.first().split(" ").map{it.trim()}
            val occurrenceOfChar = lineDigits.joinToString("").groupingBy { it }.eachCount()
            e = occurrenceOfChar.filter { it.value == 4 }.map { it.key }.first()
            b = occurrenceOfChar.filter { it.value == 6 }.map { it.key }.first()
            f = occurrenceOfChar.filter { it.value == 9 }.map { it.key }.first()

            c = lineDigits.first { it.length == 2 }.filterNot { it == f }.first()
            a = lineDigits.first { it.length == 3 }.filterNot { it in setOf(f, c) }.first()
            d = lineDigits.first { it.length == 4 }.filterNot { it in setOf(f, c, b) }.first()
            g = lineDigits.first { it.length == 7 }.filterNot { it in setOf(a, b, c, d, e, f) }.first()

            val ZERO = setOf(a, b, c, e, f, g)
            val ONE = setOf(c, f)
            val TWO = setOf(a, c, d, e, g)
            val THREE = setOf(a, c, d, f, g)
            val FOUR = setOf(b, c, d, f)
            val FIVE = setOf(a, b, d, f, g)
            val SIX = setOf(a, b, d, e, f, g)
            val SEVEN = setOf(a, c, f)
            val EIGHT = setOf(a, b, c, d, e, f, g)
            val NINE = setOf(a, b, c, d, f, g)

            var numberAsString = ""
            for (number in splitLine.last().split(" ").map{it.trim()}) {
                if (number.toSet() == ZERO) {numberAsString += "0"}
                else if (number.toSet() == ONE) {numberAsString += "1"}
                else if (number.toSet() == TWO) {numberAsString += "2"}
                else if (number.toSet() == THREE) {numberAsString += "3"}
                else if (number.toSet() == FOUR) {numberAsString += "4"}
                else if (number.toSet() == FIVE) {numberAsString += "5"}
                else if (number.toSet() == SIX) {numberAsString += "6"}
                else if (number.toSet() == SEVEN) {numberAsString += "7"}
                else if (number.toSet() == EIGHT) {numberAsString += "8"}
                else if (number.toSet() == NINE) {numberAsString += "9"}
            }
            total+=numberAsString.toInt()

        }
        println(total)

    }
    /*
        var a = ' '
    var b = ' '
    var c = ' '
    var d = ' '
    var e = ' '
    var f = ' '
    var g = ' '

    enum class Derp(value: Int, includedLines: Set<Char>) {
        ZERO(0,setOf(a, b, c, e, f, g)),
        ONE(1,setOf(c, f)),
        TWO(2,setOf(a, c, d, e, g)),
        THREE(3,setOf(a, c, d, f, g),
        FOUR(4, setOf(b, c, d, f)),
        FIVE(5,setOf(a, b, d, f, g),
        SIX(6,setOf(a, b, d, e, f, g),
        SEVEN(7,setOf(a, c, f)),
        EIGHT(8,setOf(a, b, c, d, e, f, g)),
        NINE(9,setOf(a, b, c, d, f, g))
    }
     */
}

fun main() {
//    val testData = getTestInputLines(testInput)
    val testData = getTestFileLines("2021/Day8.txt")
    Day8().part1(testData)
    Day8().part2(testData)
}

private const val testInput = //"acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab | cdfeb fcadb cdfeb cdbaf"
        "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe\n" +
        "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc\n" +
        "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg\n" +
        "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb\n" +
        "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea\n" +
        "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb\n" +
        "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe\n" +
        "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef\n" +
        "egadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb\n" +
        "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce"
