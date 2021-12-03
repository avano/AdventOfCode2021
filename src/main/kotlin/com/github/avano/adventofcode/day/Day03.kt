package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input
import kotlin.math.abs
import kotlin.streams.toList

class Day03 : Day() {
    override fun part1(input: Input): Any {
        val onesCount = getOnes(input.asList())
        val gamma = Integer.parseInt(onesCount.joinToString(separator = ""), 2)
        val epsilon = Integer.parseInt(onesCount.map { abs(it - 1) }.joinToString(separator = ""), 2)

        return gamma * epsilon
    }

    override fun part2(input: Input): Any {
        fun Input.reduce(most: Boolean): Int {
            var current = asList()
            var bitCount = getOnes(current)
            var i = 0
            while (current.size != 1) {
                current = current.stream().filter { if (most) it[i] == bitCount[i].digitToChar() else it[i] != bitCount[i].digitToChar() }.toList()
                bitCount = getOnes(current)
                i++
            }
            return Integer.parseInt(current[0], 2)
        }

        val oxygenGeneratorRating = input.reduce(most = true)
        val co2ScrubberRating = input.reduce(most = false)

        return oxygenGeneratorRating * co2ScrubberRating
    }

    private fun getOnes(list: List<String>): List<Int> {
        val bitCount = List(list[0].length) { 0 } as MutableList
        list.forEach {
            it.forEachIndexed { i, c -> bitCount[i] += if (c == '1') 1 else 0 }
        }
        return bitCount.map { if (it >= list.size / 2.0) 1 else 0 }
    }
}
