package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day
import com.github.avano.adventofcode.util.Input
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class DayTest {
    abstract fun part1(): List<Arguments>
    abstract fun part2(): List<Arguments>

    @ParameterizedTest
    @MethodSource("part1")
    fun part1Test(d: Day, input: Input, output: Any) {
        assertEquals(output, d.part1(input))
    }

    @ParameterizedTest
    @MethodSource("part2")
    fun part2Test(d: Day, input: Input, output: Any) {
        assertEquals(output, d.part2(input))
    }
}
