package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.*
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day12Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day12(),
                Input("start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end"),
                10),
            Arguments.of(
                Day12(),
                Input("dc-end\n" +
                        "HN-start\n" +
                        "start-kj\n" +
                        "dc-start\n" +
                        "dc-HN\n" +
                        "LN-dc\n" +
                        "HN-end\n" +
                        "kj-sa\n" +
                        "kj-HN\n" +
                        "kj-dc"),
                19),
            Arguments.of(
                Day12(),
                Input("fs-end\n" +
                        "he-DX\n" +
                        "fs-he\n" +
                        "start-DX\n" +
                        "pj-DX\n" +
                        "end-zg\n" +
                        "zg-sl\n" +
                        "zg-pj\n" +
                        "pj-he\n" +
                        "RW-he\n" +
                        "fs-DX\n" +
                        "pj-RW\n" +
                        "zg-RW\n" +
                        "start-pj\n" +
                        "he-WI\n" +
                        "zg-he\n" +
                        "pj-fs\n" +
                        "start-RW"),
                226)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day12(),
                Input("start-A\n" +
                        "start-b\n" +
                        "A-c\n" +
                        "A-b\n" +
                        "b-d\n" +
                        "A-end\n" +
                        "b-end"),
                36),
            Arguments.of(
                Day12(),
                Input("dc-end\n" +
                        "HN-start\n" +
                        "start-kj\n" +
                        "dc-start\n" +
                        "dc-HN\n" +
                        "LN-dc\n" +
                        "HN-end\n" +
                        "kj-sa\n" +
                        "kj-HN\n" +
                        "kj-dc"),
                103),
            Arguments.of(
                Day12(),
                Input("fs-end\n" +
                        "he-DX\n" +
                        "fs-he\n" +
                        "start-DX\n" +
                        "pj-DX\n" +
                        "end-zg\n" +
                        "zg-sl\n" +
                        "zg-pj\n" +
                        "pj-he\n" +
                        "RW-he\n" +
                        "fs-DX\n" +
                        "pj-RW\n" +
                        "zg-RW\n" +
                        "start-pj\n" +
                        "he-WI\n" +
                        "zg-he\n" +
                        "pj-fs\n" +
                        "start-RW"),
                3509)
        )
    }
}
