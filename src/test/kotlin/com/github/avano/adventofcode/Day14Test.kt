package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day14
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day14Test : DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day14(),
                Input(
                    "NNCB\n" +
                            "\n" +
                            "CH -> B\n" +
                            "HH -> N\n" +
                            "CB -> H\n" +
                            "NH -> C\n" +
                            "HB -> C\n" +
                            "HC -> B\n" +
                            "HN -> C\n" +
                            "NN -> C\n" +
                            "BH -> H\n" +
                            "NC -> B\n" +
                            "NB -> B\n" +
                            "BN -> B\n" +
                            "BB -> N\n" +
                            "BC -> B\n" +
                            "CC -> N\n" +
                            "CN -> C"
                ),
                1588L
            )
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day14(),
                Input(
                    "NNCB\n" +
                            "\n" +
                            "CH -> B\n" +
                            "HH -> N\n" +
                            "CB -> H\n" +
                            "NH -> C\n" +
                            "HB -> C\n" +
                            "HC -> B\n" +
                            "HN -> C\n" +
                            "NN -> C\n" +
                            "BH -> H\n" +
                            "NC -> B\n" +
                            "NB -> B\n" +
                            "BN -> B\n" +
                            "BB -> N\n" +
                            "BC -> B\n" +
                            "CC -> N\n" +
                            "CN -> C"
                ),
                2188189693529L
            )
        )
    }
}
