package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines
import java.util.regex.Pattern

class Day5 : AocBase {
    private val stackNumbers = " 1"
    override fun part1(input: List<String>): String {
        var stacks: List<String> = emptyList()
        var commands: List<String> = emptyList()
        var numberOfStacks = 0
            for (i in input) {
            if (i.startsWith(stackNumbers)) {
                stacks = input.subList(0, input.indexOf(i))
                commands = input.subList(input.indexOf(i) + 2, input.size)
                numberOfStacks = i.trim().split(' ').last().toInt()
                break
            }
        }

        val allStacks: Array<ArrayDeque<String>> = Array(numberOfStacks) {
            ArrayDeque()
        }

        stacks.map { line -> line.split(
            Pattern.compile("(?<=\\G.{4})"))
        }.map { splitLine ->
            for (i in splitLine.indices) {
                if (splitLine[i].isNotBlank()) {
                    allStacks[i].addLast(
                        splitLine[i].replace(
                            Pattern.compile("\\W").toRegex(), ""
                        ).trim()
                    )
                }
            }
        }

        allStacks.forEach { println(it.toList()) }

        for (command in commands) {
            val (howMany, start, finish) = command.replace(Pattern.compile("[a-zA-Z]").toRegex(), "").trim().split("  ").map { it.toInt() }
            val tempHolder = mutableListOf<String>()
            allStacks[start-1].let { stack ->
                for (i in 1..howMany) {
                    tempHolder.add(stack.removeFirst())
                }
            }

            allStacks[finish-1].let { stack ->
                for (i in 1..howMany) {
                    stack.addFirst(tempHolder[i-1])
                }
            }
        }

        val result = allStacks.map { stack -> stack.removeFirst() }.joinToString("")

        return result
    }

    override fun part2(input: List<String>): String {
        var stacks: List<String> = emptyList()
        var commands: List<String> = emptyList()
        var numberOfStacks = 0
        for (i in input) {
            if (i.startsWith(stackNumbers)) {
                stacks = input.subList(0, input.indexOf(i))
                commands = input.subList(input.indexOf(i) + 2, input.size)
                numberOfStacks = i.trim().split(' ').last().toInt()
                break
            }
        }

        val allStacks: Array<ArrayDeque<String>> = Array(numberOfStacks) {
            ArrayDeque()
        }

        stacks.map { line -> line.split(
            Pattern.compile("(?<=\\G.{4})"))
        }.map { splitLine ->
            for (i in splitLine.indices) {
                if (splitLine[i].isNotBlank()) {
                    allStacks[i].addLast(
                        splitLine[i].replace(
                            Pattern.compile("\\W").toRegex(), ""
                        ).trim()
                    )
                }
            }
        }

        for (command in commands) {
            val (howMany, start, finish) = command.replace(Pattern.compile("[a-zA-Z]").toRegex(), "").trim().split("  ").map { it.toInt() }
            val tempHolder = mutableListOf<String>()
            allStacks[start-1].let { stack ->
                for (i in 1..howMany) {
                    tempHolder.add(stack.removeFirst())
                }
            }

            allStacks[finish-1].addAll(0, tempHolder)
        }

        val result = allStacks.map { stack -> stack.removeFirst() }.joinToString("")

        return result
    }
}

fun main() {
    Day5().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}