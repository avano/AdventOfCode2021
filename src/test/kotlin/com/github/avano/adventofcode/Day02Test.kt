package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day02
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day02Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day02(),
                Input("forward 5\n" +
                        "down 5\n" +
                        "forward 8\n" +
                        "up 3\n" +
                        "down 8\n" +
                        "forward 2"),
                150)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day02(),
                Input("forward 5\n" +
                        "down 5\n" +
                        "forward 8\n" +
                        "up 3\n" +
                        "down 8\n" +
                        "forward 2"),
                900)
        )
    }
}
