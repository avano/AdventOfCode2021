package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input
import com.github.avano.adventofcode.util.getInputs

abstract class Day {
    val inputs: Pair<Input, Input> by lazy {
        getInputs(javaClass.simpleName.substringAfter("Day"))
    }

    abstract fun part1(input: Input): Any
    abstract fun part2(input: Input): Any
}
