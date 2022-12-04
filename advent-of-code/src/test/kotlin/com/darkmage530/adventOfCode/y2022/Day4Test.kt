package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day4Test : StringSpec({
    val day4 = Day4()
    val testInput = """2-4,6-8
2-3,4-5
5-7,7-9
2-8,3-7
6-6,4-6
2-6,4-8"""

    "part1" {
        day4.part1(getTestInputLines(testInput))
            .shouldBe("2")
    }

    "part2" {
        day4.part2(getTestInputLines(testInput))
            .shouldBe("4")
    }

})
