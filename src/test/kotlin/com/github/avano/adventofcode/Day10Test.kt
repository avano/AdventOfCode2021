package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.*
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.params.provider.Arguments

class Day10Test: DayTest() {
    override fun part1(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day10(),
                Input("[({(<(())[]>[[{[]{<()<>>\n" +
                        "[(()[<>])]({[<{<<[]>>(\n" +
                        "{([(<{}[<>[]}>{[]{[(<()>\n" +
                        "(((({<>}<{<{<>}{[]{[]{}\n" +
                        "[[<[([]))<([[{}[[()]]]\n" +
                        "[{[{({}]{}}([{[{{{}}([]\n" +
                        "{<[[]]>}<{[{[{[]{()[[[]\n" +
                        "[<(<(<(<{}))><([]([]()\n" +
                        "<{([([[(<>()){}]>(<<{{\n" +
                        "<{([{{}}[<[[[<>{}]]]>[]]"),
                26397)
        )
    }

    override fun part2(): List<Arguments> {
        return listOf(
            Arguments.of(
                Day10(),
                Input("[({(<(())[]>[[{[]{<()<>>\n" +
                        "[(()[<>])]({[<{<<[]>>(\n" +
                        "{([(<{}[<>[]}>{[]{[(<()>\n" +
                        "(((({<>}<{<{<>}{[]{[]{}\n" +
                        "[[<[([]))<([[{}[[()]]]\n" +
                        "[{[{({}]{}}([{[{{{}}([]\n" +
                        "{<[[]]>}<{[{[{[]{()[[[]\n" +
                        "[<(<(<(<{}))><([]([]()\n" +
                        "<{([([[(<>()){}]>(<<{{\n" +
                        "<{([{{}}[<[[[<>{}]]]>[]]"),
                288957L)
        )
    }
}
