package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day03
import com.github.avano.adventofcode.day.Day04
import com.github.avano.adventofcode.day.Day05
import com.github.avano.adventofcode.day.Day06
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day06Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day06(),
                Input("3,4,3,1,2"),
                5934L)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day06(),
                Input("3,4,3,1,2"),
                26984457539L)
        )
    }
}
