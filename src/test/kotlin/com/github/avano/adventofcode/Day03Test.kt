package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day03
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day03Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day03(),
                Input("00100\n" +
                        "11110\n" +
                        "10110\n" +
                        "10111\n" +
                        "10101\n" +
                        "01111\n" +
                        "00111\n" +
                        "11100\n" +
                        "10000\n" +
                        "11001\n" +
                        "00010\n" +
                        "01010"),
                198)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day03(),
                Input("00100\n" +
                        "11110\n" +
                        "10110\n" +
                        "10111\n" +
                        "10101\n" +
                        "01111\n" +
                        "00111\n" +
                        "11100\n" +
                        "10000\n" +
                        "11001\n" +
                        "00010\n" +
                        "01010"),
                230)
        )
    }
}
