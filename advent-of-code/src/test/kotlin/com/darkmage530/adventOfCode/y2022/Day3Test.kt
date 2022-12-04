package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day3Test : StringSpec({
    val day3 = Day3()
    val testInput = """vJrwpWtwJgWrhcsFMMfFFhFp
jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
PmmdzqPrVvPwwTWBwg
wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
ttgJtRGJQctTZtZT
CrZsJsPPZsGzwwsLwLmpwMDw"""

    "part1" {
        day3.part1(getTestInputLines(testInput))
            .shouldBe("157")
    }

    "part2" {
        day3.part2(getTestInputLines(testInput))
            .shouldBe("70")
    }
})