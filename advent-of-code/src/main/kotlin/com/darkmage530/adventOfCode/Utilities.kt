package com.darkmage530.adventOfCode

import java.io.File

fun getTestInputLines(testInput: String) =
    run { testInput.split("\n") }

fun getTestFileLines(filename: String) =
    run { File("advent-of-code/src/main/resources/$filename").readLines() }

fun getSingleTestInputLines(inputString: String, delimiter: String) =
    run { inputString.split(delimiter) }

fun getSingleTestFileLine(filename: String, delimiter: String) =
    run {
        File("advent-of-code/src/main/resources/$filename")
            .readLines()
            .first()
            .split(delimiter)
    }