package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input
import com.github.avano.adventofcode.util.getInputs

abstract class Day {
    val number = javaClass.simpleName.substringAfter("Day")
    val inputs: Pair<Input, Input> by lazy {
        getInputs(number)
    }

    abstract fun part1(input: Input): Any
    abstract fun part2(input: Input): Any
}
