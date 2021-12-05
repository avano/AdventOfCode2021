package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day03
import com.github.avano.adventofcode.day.Day04
import com.github.avano.adventofcode.day.Day05
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day05Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day05(),
                Input("0,9 -> 5,9\n" +
                        "8,0 -> 0,8\n" +
                        "9,4 -> 3,4\n" +
                        "2,2 -> 2,1\n" +
                        "7,0 -> 7,4\n" +
                        "6,4 -> 2,0\n" +
                        "0,9 -> 2,9\n" +
                        "3,4 -> 1,4\n" +
                        "0,0 -> 8,8\n" +
                        "5,5 -> 8,2"),
                5)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day05(),
                Input("0,9 -> 5,9\n" +
                        "8,0 -> 0,8\n" +
                        "9,4 -> 3,4\n" +
                        "2,2 -> 2,1\n" +
                        "7,0 -> 7,4\n" +
                        "6,4 -> 2,0\n" +
                        "0,9 -> 2,9\n" +
                        "3,4 -> 1,4\n" +
                        "0,0 -> 8,8\n" +
                        "5,5 -> 8,2"),
                12)
        )
    }
}
