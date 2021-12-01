package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day01 : Day() {
    override fun part1(input: Input): Any {
        val list = input.asIntList()
        return list.foldIndexed(0) { index, sum, el -> if (index > 0 && el > list[index - 1]) sum + 1 else sum }
    }

    override fun part2(input: Input): Any {
        val list = input.asIntList()
        var sum = 0
        var lastWindow = list.subList(0, 3).sum()
        for (i in 1 until list.size - 2) {
            val current = list.subList(i, i + 3).sum()
            sum += if (current > lastWindow) 1 else 0
            lastWindow = current
        }
        return sum
    }
}
