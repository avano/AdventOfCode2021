package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day06 : Day() {
    private fun Input.populate(m: MutableList<Long>) = asInts().forEach { m[it] = m[it] + 1L }

    private fun solve(input: Input, days: Int): Long {
        val lanternfish = MutableList(9) { 0L }
        input.populate(lanternfish)

        repeat(days) {
            var prev = 0L
            var current: Long
            for (j in 8 downTo 0) {
                current = lanternfish[j]
                if (j == 0 && current != 0L) {
                    lanternfish[8] = current
                    lanternfish[6] = lanternfish[6] + current
                }
                lanternfish[j] = prev
                prev = current
            }
        }

        return lanternfish.sum()
    }

    override fun part1(input: Input): Any {
        return solve(input, 80)
    }

    override fun part2(input: Input): Any {
        return solve(input, 256)
    }
}
