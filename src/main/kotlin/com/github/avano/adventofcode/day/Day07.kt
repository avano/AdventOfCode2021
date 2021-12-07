package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input
import kotlin.math.abs

class Day07 : Day() {
    private fun List<Int>.distance(destination: Int, compute: (Int, Int) -> Int): Int {
        return fold(0) { sum, e -> sum + compute(destination, e) }
    }

    private fun gaussSum(n: Int): Int = n * (n + 1) / 2

    override fun part1(input: Input): Any {
        val ints = input.asInts().sorted()
        val median = ints[if (ints.size % 2 == 0) (ints.size / 2 - 1) else (ints.size / 2)]
        return ints.distance(median) { destination, e -> abs(destination - e) }
    }

    override fun part2(input: Input): Any {
        val ints = input.asInts().sorted()
        var min = Integer.MAX_VALUE
        for (i in 0..ints.last()) {
            val current = ints.distance(i) { destination, e -> gaussSum(abs(destination - e)) }
            if (current < min) {
                min = current
            }
        }
        return min
    }
}
