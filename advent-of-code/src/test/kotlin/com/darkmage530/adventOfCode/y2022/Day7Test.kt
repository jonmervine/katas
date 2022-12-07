package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day7Test : StringSpec({
    val testInput = """$ cd /
$ ls
dir a
14848514 b.txt
8504156 c.dat
dir d
$ cd a
$ ls
dir e
29116 f
2557 g
62596 h.lst
$ cd e
$ ls
584 i
$ cd ..
$ cd ..
$ cd d
$ ls
4060174 j
8033020 d.log
5626152 d.ext
7214296 k"""

    "part1" {
        Day7(0).part1(getTestInputLines(testInput))
            .shouldBe("95437")
    }

    "part2" {
        Day7(0).part2(getTestInputLines(testInput))
            .shouldBe("24933642")
    }

    "test root plus directory and two files" {
        val localDay7 = Day7(0)
        val example = listOf(
            "$ cd /",
            "$ ls",
            "dir a",
            "666 poi.txt",
            "$ cd a",
            "$ ls",
            "100 aoi.txt",
            "$ cd ..")
        val graph = localDay7.buildFileSystem(example)
        localDay7.recursivelyGetFileSizesForDir(graph, graph.nodes().find { it.id == 0 }!!, 0)
            .shouldBe(766)
    }

    "test root plus multiple directories directory and files" {
        val localDay7 = Day7(0)
        val example = listOf(
            "$ cd /",
            "$ ls",
            "dir a",
            "dir b",
            "666 poi.txt",
            "$ cd a",
            "$ ls",
            "dir a",
            "100 aoi.txt",
            "$ cd a",
            "13 kumiko.txt",
            "$ cd ..",
            "$ cd ..",
            "$ cd b",
            "34 akko.txt")
        val graph = localDay7.buildFileSystem(example)
        localDay7.recursivelyGetFileSizesForDir(graph, graph.nodes().find { it.id == 0 }!!, 0)
            .shouldBe(813)

        localDay7.recursivelyGetFileSizesForDir(graph, graph.nodes().find { it.id == 1 }!!, 0)
            .shouldBe(113)

        localDay7.recursivelyGetFileSizesForDir(graph, graph.nodes().find { it.name == "b" }!!, 0)
            .shouldBe(34)

        localDay7.recursivelyGetFileSizesForDir(graph, graph.nodes().find { it.id == 4 }!!, 0)
            .shouldBe(13)
    }

})
