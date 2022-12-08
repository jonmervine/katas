package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines

class Day8 : AocBase {

    override fun part1(input: List<String>): String {
        val my2DGrid = input.map { line ->
            line.toCharArray().toList().map { ch -> ch.toString().toInt() }
        }

        val visibleTreeCoords: MutableSet<Pair<Int, Int>> = mutableSetOf()

        var highestInColumns = Array(my2DGrid.size) { -1 }
        var highestInColumnReversed = Array(my2DGrid.size) { -1 }

        my2DGrid.forEachIndexed { verticalPos, horizontalRows ->
            var highestInRow = -1

            horizontalRows.forEachIndexed { horizontalPos, treeHeight ->

                if (verticalPos == 0 || verticalPos == my2DGrid.size - 1 ||
                    horizontalPos == 0 || horizontalPos == horizontalRows.size - 1
                ) {
                    visibleTreeCoords.add(Pair(verticalPos, horizontalPos))
                }

                if (highestInRow < treeHeight) {
                    visibleTreeCoords.add(Pair(verticalPos, horizontalPos))
                    highestInRow = treeHeight
                }

                if (highestInColumns[horizontalPos] < treeHeight) {
                    visibleTreeCoords.add(Pair(verticalPos, horizontalPos))
                    highestInColumns[horizontalPos] = treeHeight
                }
            }

            highestInRow = -1
            horizontalRows.asReversed().forEachIndexed { horizontalPos, treeHeight ->
                if (highestInRow < treeHeight) {
                    visibleTreeCoords.add(Pair(verticalPos, horizontalRows.size - horizontalPos - 1))
                    highestInRow = treeHeight
                }
            }
        }
        my2DGrid.asReversed().forEachIndexed { verticalPos, horizontalRows ->
            horizontalRows.forEachIndexed { horizontalPos, treeHeight ->
                if (highestInColumnReversed[horizontalPos] < treeHeight) {
                    visibleTreeCoords.add(Pair(my2DGrid.size - verticalPos - 1, horizontalPos))
                    highestInColumnReversed[horizontalPos] = treeHeight
                }
            }
        }

        return visibleTreeCoords.size.toString()
    }

    override fun part2(input: List<String>): String {
        val my2DGrid = input.map { line ->
            line.toCharArray().toList().map { ch -> ch.toString().toInt() }
        }
        var mostTrees = 0

        my2DGrid.forEachIndexed { verticalPos, horizontalRow ->
            horizontalRow.forEachIndexed { horizontalPos, treeHeight ->
                var left = 0
                var right = 0
                var up = 0
                var down = 0

                //look left
                if (horizontalPos == 0) {
                    left = 0
                } else {
                    var vision = horizontalPos
                    while (vision - 1 > -1) {
                        vision--
                        left++
                        if (horizontalRow[vision] >= treeHeight)
                            vision = -1
                    }
                }

                //look right
                if (horizontalPos == horizontalRow.size - 1) {
                    right = 0
                } else {
                    var vision = horizontalPos
                    while (vision + 1 < horizontalRow.size) {
                        vision++
                        right++
                        if (horizontalRow[vision] >= treeHeight)
                            vision = horizontalRow.size + 1
                    }
                }

                //look up
                if (verticalPos == 0) {
                    up = 0
                } else {
                    var vision = verticalPos
                    while (vision - 1 > -1) {
                        vision--
                        up++
                        if (my2DGrid[vision][horizontalPos] >= treeHeight)
                            vision = -1
                    }
                }

                //look down
                if (verticalPos == my2DGrid.size - 1) {
                    down = 0
                } else {
                    var vision = verticalPos
                    while (vision + 1 < my2DGrid.size) {
                        vision++
                        down++
                        if (my2DGrid[vision][horizontalPos] >= treeHeight)
                            vision = my2DGrid.size + 1
                    }
                }

                val currentTrees = listOf(left, right, up, down).filter { it > 0 }
                    .reduce { acc, num -> acc * num}
                if (mostTrees < currentTrees)
                    mostTrees = currentTrees
            }
        }
        return mostTrees.toString()
    }
}

fun main() {
    Day8().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}