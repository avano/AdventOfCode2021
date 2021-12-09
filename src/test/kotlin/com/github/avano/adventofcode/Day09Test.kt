package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.*
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day09Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day09(),
                Input("2199943210\n" +
                        "3987894921\n" +
                        "9856789892\n" +
                        "8767896789\n" +
                        "9899965678"),
                15)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day09(),
                Input("2199943210\n" +
                        "3987894921\n" +
                        "9856789892\n" +
                        "8767896789\n" +
                        "9899965678"),
                1134)
        )
    }
}
