package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day

fun main(args: Array<String>) {
    args.forEach {
        val d: Day = Class.forName("com.github.avano.adventofcode.day.Day$it").getConstructor().newInstance() as Day
        println("Day $it:")
        println("Part 1: " + d.part1(d.inputs.first))
        println("Part 2: " + d.part2(d.inputs.second))
        println("-----")
    }
}
