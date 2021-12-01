package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day01
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day01Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day01(),
                Input("199\n" +
                        "200\n" +
                        "208\n" +
                        "210\n" +
                        "200\n" +
                        "207\n" +
                        "240\n" +
                        "269\n" +
                        "260\n" +
                        "263"),
                7)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day01(),
                Input("199\n" +
                        "200\n" +
                        "208\n" +
                        "210\n" +
                        "200\n" +
                        "207\n" +
                        "240\n" +
                        "269\n" +
                        "260\n" +
                        "263"),
                5)
        )
    }
}
