package com.darkmage530.adventOfCode.y2021

import com.darkmage530.adventOfCode.getTestFileLines

class Day12 {

    data class Cave(val name: String, val isSmall: Boolean)
    private val adjacency = HashMap<Cave, MutableList<Cave>>()
    private fun HashMap<Cave, MutableList<Cave>>.appendOrPut(a: Cave, b: Cave) {
        if (this.contains(a))
            this[a]!!.add(b)
        else
            this[a] = mutableListOf(b)
    }
    private fun HashMap<Cave, MutableList<Cave>>.findName(name: String): Cave {
        return this.entries.first { it.key.name == name }.key
    }

    private val allPaths: MutableSet<List<Cave>> = mutableSetOf()

    private fun createAdjacency(testData: List<String>) {
        testData.map { line -> line.split("-") }.forEach { pair ->
            val left = Cave(pair[0], pair[0].first().isLowerCase());
            val right = Cave(pair[1], pair[1].first().isLowerCase())
            adjacency.appendOrPut(left, right)
            adjacency.appendOrPut(right, left)
        }
    }

    fun part1(testData: List<String>) {
        createAdjacency(testData)

        val start = adjacency.findName("start")
        search(start, mutableListOf())
        allPaths.forEach { println(it) }
        println(allPaths.size)
    }

    private fun search(current: Cave, currentPath: MutableList<Cave>) {
//        val current = queue.removeFirst()
        currentPath.add(current)

        if (current.name == "end") {
            allPaths.add(currentPath.toList())
            currentPath.removeLast()
            return
        }

        val edges = adjacency[current]!!.filter { edgeCave -> if (edgeCave.isSmall) !currentPath.contains(edgeCave) else true }

        edges.forEach { nextCave -> search(nextCave, currentPath) }

        currentPath.removeLast()
    }

    fun part2(testData: List<String>) {
        createAdjacency(testData)

            println(adjacency)
            val start = adjacency.findName("start")
            var additionalSmallCave = true
            search2(start, mutableListOf(), additionalSmallCave)
            allPaths.forEach { println(it) }
            println(allPaths.size)
    }

    private fun search2(current: Cave, currentPath: MutableList<Cave>, passedSmallCave: Boolean) {
        var additionalSmallCave = passedSmallCave
        if (currentPath.contains(current) && current.isSmall) {
            additionalSmallCave = false
        }
        currentPath.add(current)

        if (current.name == "end") {
            allPaths.add(currentPath.toList())
            currentPath.removeLast()
            return
        }

        val edges = adjacency[current]!!.filter { edgeCave ->
            if (edgeCave.isSmall)
                if (edgeCave.name == "start") {
                    false
                }
                else if (additionalSmallCave) {
                    true
                }
                else {
                    !currentPath.contains(edgeCave)
                }
            else
                true
        }

        edges.forEach { nextCave -> search2(nextCave, currentPath, additionalSmallCave);  }

        currentPath.removeLast()
    }
}

fun main() {
//    val testData = getTestInputLines(testInput1)
//    val testData = getTestInputLines(testInput2)
//    val testData = getTestInputLines(testInput3)
    val testData = getTestFileLines("y2021/Day12.txt")

//    Day12().part1(testData)
    Day12().part2(testData)
}

private const val testInput1 = "start-A\n" +
        "start-b\n" +
        "A-c\n" +
        "A-b\n" +
        "b-d\n" +
        "A-end\n" +
        "b-end"

private const val testInput2 = "dc-end\n" +
        "HN-start\n" +
        "start-kj\n" +
        "dc-start\n" +
        "dc-HN\n" +
        "LN-dc\n" +
        "HN-end\n" +
        "kj-sa\n" +
        "kj-HN\n" +
        "kj-dc"

private const val testInput3 = "fs-end\n" +
        "he-DX\n" +
        "fs-he\n" +
        "start-DX\n" +
        "pj-DX\n" +
        "end-zg\n" +
        "zg-sl\n" +
        "zg-pj\n" +
        "pj-he\n" +
        "RW-he\n" +
        "fs-DX\n" +
        "pj-RW\n" +
        "zg-RW\n" +
        "start-pj\n" +
        "he-WI\n" +
        "zg-he\n" +
        "pj-fs\n" +
        "start-RW"