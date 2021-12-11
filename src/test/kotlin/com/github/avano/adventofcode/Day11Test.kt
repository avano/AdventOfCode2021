package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.*
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day11Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day11(),
                Input("5483143223\n" +
                        "2745854711\n" +
                        "5264556173\n" +
                        "6141336146\n" +
                        "6357385478\n" +
                        "4167524645\n" +
                        "2176841721\n" +
                        "6882881134\n" +
                        "4846848554\n" +
                        "5283751526"),
                1656)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day11(),
                Input("5483143223\n" +
                        "2745854711\n" +
                        "5264556173\n" +
                        "6141336146\n" +
                        "6357385478\n" +
                        "4167524645\n" +
                        "2176841721\n" +
                        "6882881134\n" +
                        "4846848554\n" +
                        "5283751526"),
                195)
        )
    }
}
