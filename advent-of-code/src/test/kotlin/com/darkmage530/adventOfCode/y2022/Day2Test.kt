package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day2Test : StringSpec({
    val day2 = Day2()
    val testInput = """A Y
B X
C Z"""

    "part1" {
        day2.part1(getTestInputLines(testInput))
            .shouldBe("15")
    }

    "part2" {
        day2.part2(getTestInputLines(testInput))
            .shouldBe("12")
    }
})