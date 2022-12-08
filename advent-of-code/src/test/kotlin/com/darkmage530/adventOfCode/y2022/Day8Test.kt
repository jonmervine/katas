package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day8Test : StringSpec({

    val testInput =
"""30373
25512
65332
33549
35390"""

    "part1" {
        Day8().part1(getTestInputLines(testInput))
            .shouldBe("21")
    }

    "part2" {
        Day8().part2(getTestInputLines(testInput))
            .shouldBe("8")
    }
})
