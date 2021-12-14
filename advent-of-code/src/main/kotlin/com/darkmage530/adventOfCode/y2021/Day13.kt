package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines
import com.darkmage530.adventOfCode.getTestInputLines

class Day13 {
    fun part1(testData: List<String>) {
        val points: MutableList<Pair<Int, Int>> = mutableListOf()
        val folds: MutableList<Pair<String, Int>> = mutableListOf()
        var maxX: Int = 0
        var maxY: Int = 0
        testData.forEach { line ->
            if (line.contains(",")) {
                val point = line.split(",")
                points.add(Pair(point[0].toInt(), point[1].toInt()))
                if (point[0].toInt() > maxX) maxX = point[0].toInt()
                if (point[1].toInt() > maxY) maxY = point[1].toInt()
            } else if (line.contains("=")) {
                val fold = line.split(" ")[2].split("=")
                folds.add(Pair(fold[0], fold[1].toInt()))
            }
        }

        val updatedPoints: MutableList<Pair<Int, Int>> = mutableListOf()
        val firstFold = folds[0]
        val foldOn = firstFold.second
        if (firstFold.first == "y") {
            points.forEach { point -> var newPoint = point; if (point.second > foldOn) newPoint = Pair(point.first, maxY - point.second); updatedPoints.add(newPoint) }
        } else {
            points.forEach { point -> var newPoint = point; if (point.first > foldOn) newPoint = Pair(maxX - point.first, point.second); updatedPoints.add(newPoint) }
        }

        println("$maxX,$maxY")
        if (firstFold.first == "y") {
            val uniquePoints = updatedPoints.toSet().size
            val totalPoints = maxX * maxY/2
            println("uniquePoints: $uniquePoints, totalPoints: $totalPoints, minus=${totalPoints - uniquePoints}")
        } else {
            val uniquePoints = updatedPoints.toSet().size
            val totalPoints = maxY * maxX/2
            println("uniquePoints: $uniquePoints, totalPoints: $totalPoints, minus=${totalPoints - uniquePoints}")
        }

    }

    fun part2(testData: List<String>) {
        var points: MutableList<Pair<Int, Int>> = mutableListOf()
        val folds: MutableList<Pair<String, Int>> = mutableListOf()
        var maxX: Int = 0
        var maxY: Int = 0
        testData.forEach { line ->
            if (line.contains(",")) {
                val point = line.split(",")
                points.add(Pair(point[0].toInt(), point[1].toInt()))
                if (point[0].toInt() > maxX) maxX = point[0].toInt()
                if (point[1].toInt() > maxY) maxY = point[1].toInt()
            } else if (line.contains("=")) {
                val fold = line.split(" ")[2].split("=")
                folds.add(Pair(fold[0], fold[1].toInt()))
            }
        }

        for(fold in folds) {
            val updatedPoints: MutableList<Pair<Int, Int>> = mutableListOf()
            val foldOn = fold.second
            if (fold.first == "y") {
                points.forEach { point -> var newPoint = point; if (point.second > foldOn) newPoint = Pair(point.first, maxY - point.second); updatedPoints.add(newPoint) }
                maxY /= 2
            } else {
                points.forEach { point -> var newPoint = point; if (point.first > foldOn) newPoint = Pair(maxX - point.first, point.second); updatedPoints.add(newPoint) }
                maxX /= 2
            }
            points = updatedPoints.toList() as MutableList<Pair<Int, Int>>
        }

        val graph: MutableList<MutableList<String>> = MutableList(maxY) { MutableList(maxX) {"."} }
        points.forEach { point ->
            graph[point.second][point.first] = "#"
        }

        graph.forEach { println(it)}

//        println("$maxX,$maxY")
//        if (firstFold.first == "y") {
//            val uniquePoints = updatedPoints.toSet().size
//            val totalPoints = maxX * maxY/2
//            println("uniquePoints: $uniquePoints, totalPoints: $totalPoints, minus=${totalPoints - uniquePoints}")
//        } else {
//            val uniquePoints = updatedPoints.toSet().size
//            val totalPoints = maxY * maxX/2
//            println("uniquePoints: $uniquePoints, totalPoints: $totalPoints, minus=${totalPoints - uniquePoints}")
//        }
    }
}

fun main() {
//    val testData = getTestInputLines(testInput)
    val testData = getTestFileLines("Day13.txt")

    Day13().part1(testData)
    Day13().part2(testData)
}

private const val testInput = "6,10\n" +
        "0,14\n" +
        "9,10\n" +
        "0,3\n" +
        "10,4\n" +
        "4,11\n" +
        "6,0\n" +
        "6,12\n" +
        "4,1\n" +
        "0,13\n" +
        "10,12\n" +
        "3,4\n" +
        "3,0\n" +
        "8,4\n" +
        "1,10\n" +
        "2,14\n" +
        "8,10\n" +
        "9,0\n" +
        "\n" +
        "fold along y=7\n" +
        "fold along x=5"