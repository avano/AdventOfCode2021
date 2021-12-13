package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day13
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day13Test : DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day13(),
                Input(
                    "6,10\n" +
                            "0,14\n" +
                            "9,10\n" +
                            "0,3\n" +
                            "10,4\n" +
                            "4,11\n" +
                            "6,0\n" +
                            "6,12\n" +
                            "4,1\n" +
                            "0,13\n" +
                            "10,12\n" +
                            "3,4\n" +
                            "3,0\n" +
                            "8,4\n" +
                            "1,10\n" +
                            "2,14\n" +
                            "8,10\n" +
                            "9,0\n" +
                            "\n" +
                            "fold along y=7\n" +
                            "fold along x=5"
                ),
                17
            )
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day13(),
                Input(
                    "6,10\n" +
                            "0,14\n" +
                            "9,10\n" +
                            "0,3\n" +
                            "10,4\n" +
                            "4,11\n" +
                            "6,0\n" +
                            "6,12\n" +
                            "4,1\n" +
                            "0,13\n" +
                            "10,12\n" +
                            "3,4\n" +
                            "3,0\n" +
                            "8,4\n" +
                            "1,10\n" +
                            "2,14\n" +
                            "8,10\n" +
                            "9,0\n" +
                            "\n" +
                            "fold along y=7\n" +
                            "fold along x=5"
                ),
                "\n" +
                "# # # # # \n" +
                        "#       # \n" +
                        "#       # \n" +
                        "#       # \n" +
                        "# # # # # \n" +
                        "          \n" +
                        "          \n"
            )
        )
    }
}
