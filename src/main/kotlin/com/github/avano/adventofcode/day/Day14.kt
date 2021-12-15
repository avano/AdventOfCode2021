package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day14 : Day() {
    private fun solve(input: Input, iterations: Int): Long {
        fun <T> MutableMap<T, Long>.add(el: T, count: Long) {
            this[el] = this.getOrDefault(el, 0L) + count
        }

        val rules = input.asList().subList(2, input.asList().size).map { it.split(" -> ") }.associate { it[0] to it[1] }
        var pairCount = input.asList()[0].windowed(2).groupingBy { it }.eachCount().mapValues { it.value.toLong() }.toMutableMap()
        var lastPair = input.asList()[0].windowed(2).last()
        val charCount = mutableMapOf<Char, Long>()

        repeat(iterations) {
            val nextPairCount = mutableMapOf<String, Long>()
            pairCount.forEach { (pair, count) ->
                val (first, second) = Pair(pair[0] + rules.getValue(pair), rules.getValue(pair) + pair[1])
                nextPairCount.add(first, count)
                nextPairCount.add(second, count)

                if (it == iterations - 1) {
                    first.forEach { charCount.add(it, count) }
                    if (pair == lastPair) {
                        charCount.add(second[1], 1)
                    }
                }

                if (pair == lastPair) {
                    lastPair = second
                }
            }
            pairCount = nextPairCount
        }

        return charCount.values.maxOrNull()!! - charCount.values.minOrNull()!!
    }

    override fun part1(input: Input): Any = solve(input, 10)
    override fun part2(input: Input): Any = solve(input, 40)
}
