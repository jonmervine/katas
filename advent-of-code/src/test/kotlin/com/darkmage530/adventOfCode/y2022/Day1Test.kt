package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day1Test : StringSpec({
    val day1 = Day1()
    val testInput = """1000
2000
3000

4000

5000
6000

7000
8000
9000

10000"""

    "part1" {
        day1.part1(getTestInputLines(testInput))
            .shouldBe(24000)
    }

    "part2" {
        day1.part2(getTestInputLines(testInput))
            .shouldBe(45000)
    }

})