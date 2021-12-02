package com.darkmage530.adventOfCode

import java.io.File

fun getTestInputLines(testInput: String) = run { testInput.split("\n") }

fun getTestFileLines(filename: String) = run { File("advent-of-code/src/main/resources/2021/$filename").readLines()}