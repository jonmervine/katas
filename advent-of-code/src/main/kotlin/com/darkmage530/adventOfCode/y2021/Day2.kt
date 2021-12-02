package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines

class Day2 {
    fun part1(initialParsedInput: List<String>) {
        val commands: List<Pair<String, Int>> = initialParsedInput.map { it.split(" ") }.map { Pair(it[0], Integer.parseInt(it[1])) }
        var horizontal = 0
        var depth = 0
        for (command in commands) {
            if (command.first == "forward") {
                horizontal += command.second
            } else if (command.first == "down") {
                depth += command.second
            } else if (command.first == "up") {
                depth -= command.second
            }
        }
        println("depth: $depth, horizontal: $horizontal = ${horizontal * depth}")
    }

    fun part2(initialParsedInput: List<String>) {
        val commands: List<Pair<String, Int>> = initialParsedInput.map { it.split(" ") }.map { Pair(it[0], Integer.parseInt(it[1])) }
        var aim = 0
        var horizontal = 0
        var depth = 0

        for (command in commands) {
            if (command.first == "forward") {
                horizontal += command.second
                depth += (aim * command.second)
            } else if (command.first == "down") {
                aim += command.second
            } else if (command.first == "up") {
                aim -= command.second
            }
        }
        println("aim: $aim, depth: $depth, horizontal: $horizontal = ${horizontal * depth}")
    }
}

fun main() {
//    val initialParsedInput = parseTestInput(testInput)
    val initialParsedInput = getTestFileLines("Day2.txt")
    Day2().part1(initialParsedInput)
    Day2().part2(initialParsedInput)
}

private const val testInput = "forward 5\n" +
        "down 5\n" +
        "forward 8\n" +
        "up 3\n" +
        "down 8\n" +
        "forward 2"