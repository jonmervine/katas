package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.AocBase
import com.darkmage530.adventOfCode.getTestFileLines
import com.google.common.graph.GraphBuilder
import com.google.common.graph.MutableGraph

class Day7(var autoIncrementingId: Int = 0) : AocBase {
    interface FileSystemNode {
        val id: Int
        val name: String
    }

    data class File(override val name: String, val size: Int, override val id: Int) : FileSystemNode

    data class Directory(override val name: String, override val id: Int) : FileSystemNode

    enum class Cli { CMD, DIR, FILE }

    private fun String.getType() =
        if (this.startsWith("$"))
            Cli.CMD
        else if (this.startsWith("dir"))
            Cli.DIR
        else Cli.FILE

    fun buildFileSystem(input: List<String>): MutableGraph<FileSystemNode> {
        val graph: MutableGraph<FileSystemNode> = GraphBuilder.directed().build()

        var currentDirectory: FileSystemNode = Directory("/", autoIncrementingId++)
        graph.addNode(currentDirectory)
        input.map { line ->
            val splitLine = line.split(" ")

            when (line.getType()) {
                Cli.CMD -> {
                    val commandType = splitLine[1]
                    if (commandType == "ls") null else {
                        when (splitLine[2]) {
                            ".." -> currentDirectory = graph.predecessors(currentDirectory)!!.first()
                            "/" -> currentDirectory = graph.nodes().find { it.name == "/" }!!
                            else -> {
                                currentDirectory =
                                    graph.successors(currentDirectory)!!.find { it.name == splitLine[2] }!!
                            }
                        }
                    }
                }
                Cli.DIR -> {
                    val dir = Directory(splitLine[1], autoIncrementingId++)
                    graph.addNode(dir)
                    graph.putEdge(currentDirectory, dir)
                }
                Cli.FILE -> {
                    val size = splitLine[0].toInt()
                    val name = splitLine[1]
                    val file = File(name, size, autoIncrementingId++)
                    graph.addNode(file)
                    graph.putEdge(currentDirectory, file)
                }
            }
        }
        return graph
    }

    fun recursivelyGetFileSizesForDir(
        graph: MutableGraph<FileSystemNode>,
        currentNode: FileSystemNode,
        fileSizeAggregate: Int
    ): Int {
        return if (currentNode is File) {
            currentNode.size.plus(fileSizeAggregate)
        } else {
            graph.successors(currentNode).sumOf { recursivelyGetFileSizesForDir(graph, it, fileSizeAggregate) }
        }
    }

    override fun part1(input: List<String>): String {
        val graph = buildFileSystem(input)

        val directoriesFileSize =
            graph.nodes().filter { it is Directory }.map { Pair<FileSystemNode, Int>(it, 0) }.toMap()

        return directoriesFileSize.map { (dirNode, fileSize) ->
            recursivelyGetFileSizesForDir(graph, dirNode, fileSize)
        }.filter { it <= 100000 }.sum().toString()
    }

    override fun part2(input: List<String>): String {
        val graph = buildFileSystem(input)
        val rootNode = graph.nodes().find { it.name == "/" }

        val directoriesFileSize =
            graph.nodes().filter { it is Directory }.map { dirNode ->
            Pair<FileSystemNode, Int>(dirNode, recursivelyGetFileSizesForDir(graph, dirNode, 0))
        }.toMap()

        val totalUsed = directoriesFileSize[rootNode]!!
        val totalSize = 70000000
        val neededSize = 30000000
        val minimumSizeToDelete = neededSize - (totalSize - totalUsed)

        return directoriesFileSize.entries.filter { it.value >= minimumSizeToDelete }.map { it.value }.minOrNull()!!.toString()
    }
}

fun main() {
    Day7().apply {
        println(part1(getTestFileLines(testFile())))
        println(part2(getTestFileLines(testFile())))
    }
}