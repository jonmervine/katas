package com.darkmage530.adventOfCode.y2022

import com.darkmage530.adventOfCode.getTestInputLines
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class Day5Test : StringSpec({
    val day5 = Day5()
    val testInput = """    [D]    
[N] [C]    
[Z] [M] [P]
 1   2   3 

move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2"""

    "part1" {
        day5.part1(getTestInputLines(testInput))
            .shouldBe("CMZ")
    }

    "part2" {
        day5.part2(getTestInputLines(testInput))
            .shouldBe("MCD")
    }
})