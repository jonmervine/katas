package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

class Board(var sumOfBoard: Int = 0) {
    private val rows: MutableList<String> = mutableListOf()
    private val winningSets: MutableList<List<Int>> = mutableListOf()
    private val drawnNumbers: MutableSet<Int> = mutableSetOf()
    private val allNumbersOnBoard: MutableSet<Int> = mutableSetOf()
//    private var sumOfBoard: Int = 0

    fun addLine(newLine: String) {
        rows.add(newLine)
    }

    fun newDrawnNumber(newNumber: Int): Boolean {
        drawnNumbers.add(newNumber)
        for (sets: List<Int> in winningSets) {
            if (drawnNumbers.containsAll(sets)) return true
        }
        return false
    }

    fun getUnmarkedNumbers(): Int {
        val copiedBoard = allNumbersOnBoard.toMutableList()
        copiedBoard.removeAll(drawnNumbers)
        return copiedBoard.sum()
    }

    fun finalizeBoard() {
        val columns: MutableList<MutableList<Int>> = mutableListOf()
        val column1: MutableList<Int> = mutableListOf()
        val column2: MutableList<Int> = mutableListOf()
        val column3: MutableList<Int> = mutableListOf()
        val column4: MutableList<Int> = mutableListOf()
        val column5: MutableList<Int> = mutableListOf()
        for (row: String in rows) {

            val winningRow: MutableList<Int> = mutableListOf()
            winningRow.addAll(row.trim().split("\\s+".toRegex()).map { Integer.parseInt(it) })
            sumOfBoard += winningRow.sum()
            winningSets.add(winningRow)
            allNumbersOnBoard.addAll(winningRow)

            column1.add(winningRow[0])
            column2.add(winningRow[1])
            column3.add(winningRow[2])
            column4.add(winningRow[3])
            column5.add(winningRow[4])
        }
        columns.add(column1)
        columns.add(column2)
        columns.add(column3)
        columns.add(column4)
        columns.add(column5)
        winningSets.addAll(columns)
    }

    fun printBoard() {
        println(rows)
        println(winningSets)
    }
}

class Day4 {
    fun part1(testInput: List<String>) {
        val numbersDrawn = testInput.first().split(",").map { Integer.parseInt(it) }.toList()
        val boards: MutableList<Board> = mutableListOf()

        var currentBoard = Board()
        var addedRows = false
        testInput.forEach { line ->
            if (line.length in 6..24) {
                currentBoard.addLine(line)
                addedRows = true
            } else if (addedRows && line.length < 5) {
                currentBoard.finalizeBoard()
                addedRows = false
                boards.add(currentBoard)
                currentBoard = Board()
            }
        }
        currentBoard.finalizeBoard()
        boards.add(currentBoard)

        var done = false
        for (drawn: Int in numbersDrawn) {
            for (board: Board in boards) {
                if (board.newDrawnNumber(drawn)) {
                    val sumOfRemainingBoard = board.getUnmarkedNumbers()
                    println("sumOfBoard: $sumOfRemainingBoard drawn: $drawn multiplied= ${sumOfRemainingBoard * drawn}")
                    done = true
                    break
                }
            }
            if (done) break
        }
    }

    fun part2(testInput: List<String>) {
        val numbersDrawn = testInput.first().split(",").map { Integer.parseInt(it) }.toList()
        val boards: MutableList<Board> = mutableListOf()

        var currentBoard = Board()
        var addedRows = false
        testInput.forEach { line ->
            if (line.length in 6..24) {
                currentBoard.addLine(line)
                addedRows = true
            } else if (addedRows && line.length < 5) {
                currentBoard.finalizeBoard()
                addedRows = false
                boards.add(currentBoard)
                currentBoard = Board()
            }
        }
        currentBoard.finalizeBoard()
        boards.add(currentBoard)

        var lastBoardsToWin: MutableList<Board> = mutableListOf()
        for (drawn: Int in numbersDrawn) {
            for (board: Board in boards) {
                if (board.newDrawnNumber(drawn)) {
                    lastBoardsToWin.add(board)
                }
            }
            if (lastBoardsToWin.isNotEmpty()) {
                boards.removeAll(lastBoardsToWin)
                lastBoardsToWin.forEach {
                    val sumOfRemainingBoard = it.getUnmarkedNumbers()
                    println("sumOfBoard: $sumOfRemainingBoard drawn: $drawn multiplied= ${sumOfRemainingBoard * drawn}")
                }
                lastBoardsToWin = mutableListOf()
            }
        }
    }
}

fun main() {
//    val testInput = getTestInputLines(testInput)
    val testInput = getTestFileLines("Day4.txt")
    Day4().part1(testInput)
    Day4().part2(testInput)
}

private const val testInput = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n" +
        "\n" +
        "22 13 17 11  0\n" +
        " 8  2 23  4 24\n" +
        "21  9 14 16  7\n" +
        " 6 10  3 18  5\n" +
        " 1 12 20 15 19\n" +
        "\n" +
        " 3 15  0  2 22\n" +
        " 9 18 13 17  5\n" +
        "19  8  7 25 23\n" +
        "20 11 10 24  4\n" +
        "14 21 16 12  6\n" +
        "\n" +
        "14 21 17 24  4\n" +
        "10 16 15  9 19\n" +
        "18  8 23 26 20\n" +
        "22 11 13  6  5\n" +
        " 2  0 12  3  7"