package com.darkmage530.adventOfCode

interface AocBase {
    val testFile: () -> String get() = {
        this::class.qualifiedName!!
            .split('.')
            .takeLast(2)
            .joinToString(separator = "/", postfix = ".txt")
    }

    fun part1(input: List<String>): String
    fun part2(input: List<String>): String
}