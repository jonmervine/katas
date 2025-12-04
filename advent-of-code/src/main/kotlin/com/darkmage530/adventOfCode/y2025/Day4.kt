package com.darkmage530.adventOfCode.y2025

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

fun main() {
    Day4().apply {
//        part1()
        part2()
    }
}

typealias Grid = MutableList<MutableList<Char>>

class Day4 {

    val testInput = """..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@."""

    fun part1() {
//        val grid = buildGrid(getTestInputLines(testInput))
        val grid = buildGrid(getTestFileLines("y2025/Day4.txt"))
        var countMovable = 0
        for (y in grid.indices) {
            for (x in grid[y].indices) {
                if (grid[x][y] == '@') {
                    val adjacentRolls = checkAdjacentPos(grid, x, y)
//                    println("pos($x, $y) $adjacentRolls")
                    if (adjacentRolls < 4) {
                        countMovable++
                    }
                }
            }
        }
        println(countMovable)
    }

    fun part2() {
//        val grid = buildGrid(getTestInputLines(testInput))
        val grid = buildGrid(getTestFileLines("y2025/Day4.txt"))

        var countRemoved = 0
        var didMove: Boolean
        do {
            didMove = false
            for (y in grid.indices) {
                for (x in grid[y].indices) {
                    if (grid[x][y] == '@') {
                        val adjacentRolls = checkAdjacentPos(grid, x, y)
//                        println("pos($x, $y) $adjacentRolls")
                        if (adjacentRolls < 4) {
                            didMove = true
                            countRemoved++
                            grid[x][y] = 'x'
                        }
                    }
                }
            }
        } while (didMove)
        println(countRemoved)
    }

    fun buildGrid(lines: List<String>): Grid {
        val grid = MutableList(lines.size) { MutableList(lines[0].length) { ' ' } }
        for (y in lines.indices) {
            val line = lines[y]
            for (x in line.indices) {
                grid[x][y] = line[x]
            }
        }
        return grid
    }

    fun checkAdjacentPos(grid: Grid, xPos: Int, yPos: Int): Int {
        var countRolls = 0
        val maxX = grid[0].size-1
        val maxY = grid.size-1
        // Check Above Row
        if (yPos != 0) {
            // Above
            if (grid[xPos][yPos-1] == '@') {
                countRolls++
            }
            // Diagonal Left
            if (xPos != 0) {
                if (grid[xPos-1][yPos-1] == '@') {
                    countRolls++
                }
            }
            // Diagonal Right
            if (xPos != maxX) {
                if (grid[xPos+1][yPos-1] == '@') {
                    countRolls++
                }
            }
        }
        // Check Below Row
        if (yPos != maxY) {
            // Below
            if (grid[xPos][yPos+1] == '@') {
                countRolls++
            }
            // Diagonal Left
            if (xPos != 0) {
                if (grid[xPos - 1][yPos+1] == '@') {
                    countRolls++
                }
            }
            // Diagonal Right
            if (xPos != maxX) {
                if (grid[xPos+1][yPos+1] == '@') {
                    countRolls++
                }
            }
        }
        // Check Left Column
        if (xPos != 0) {
            // Left
            if (grid[xPos-1][yPos] == '@') {
                countRolls++
            }
        }
        // Check Right Column
        if (xPos != maxX) {
            // Below
            if (grid[xPos+1][yPos] == '@') {
                countRolls++
            }
        }

        return countRolls
    }
}