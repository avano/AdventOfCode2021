package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.*
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day07Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day07(),
                Input("16,1,2,0,4,2,7,1,2,14"),
                37)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day07(),
                Input("16,1,2,0,4,2,7,1,2,14"),
                168)
        )
    }
}
