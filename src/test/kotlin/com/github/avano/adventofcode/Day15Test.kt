package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day14
import com.github.avano.adventofcode.day.Day15
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day15Test : DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day15(),
                Input(
                    "1163751742\n" +
                            "1381373672\n" +
                            "2136511328\n" +
                            "3694931569\n" +
                            "7463417111\n" +
                            "1319128137\n" +
                            "1359912421\n" +
                            "3125421639\n" +
                            "1293138521\n" +
                            "2311944581"
                ),
                40
            )
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day15(),
                Input(
                    "1163751742\n" +
                            "1381373672\n" +
                            "2136511328\n" +
                            "3694931569\n" +
                            "7463417111\n" +
                            "1319128137\n" +
                            "1359912421\n" +
                            "3125421639\n" +
                            "1293138521\n" +
                            "2311944581"
                ),
                315
            )
        )
    }
}
