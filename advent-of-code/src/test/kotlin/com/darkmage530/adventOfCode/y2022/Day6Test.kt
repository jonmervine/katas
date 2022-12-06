package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day6Test : StringSpec({
    val day6 = Day6()
    val testInput = mapOf<String, Pair<Int, Int>>("mjqjpqmgbljsphdztnvjfqwrcgsmlb" to Pair(7, 19),
"bvwbjplbgvbhsrlpgdmjqwftvncz" to Pair(5, 23),
"nppdvjthqldpwncqszvftbrmjlhg" to Pair(6, 23),
"nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to Pair(10, 29),
"zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to Pair(11, 26))

    "part1" {
        testInput.map { test ->
            day6.part1(getTestInputLines(test.key))
                .shouldBe(test.value.first.toString())
        }

    }

    "part2" {
        testInput.map { test ->
            day6.part2(getTestInputLines(test.key))
                .shouldBe(test.value.second.toString())
        }
    }
})