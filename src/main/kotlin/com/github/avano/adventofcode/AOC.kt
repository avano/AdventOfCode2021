package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day
import java.util.stream.IntStream
import kotlin.streams.toList

private fun runDay(d: Day) {
    println("Day ${d.number}:")
    println("Part 1: " + d.part1(d.inputs.first))
    println("Part 2: " + d.part2(d.inputs.second))
    println("-----")
}

private fun newDay(num: String): Day? {
    return try {
        Class.forName(Day::class.java.packageName + ".Day$num").getConstructor().newInstance() as Day
    } catch (e: ClassNotFoundException) {
        null
    }
}

fun main(args: Array<String>) {
    val days: List<Day> = if (args.isEmpty()) {
        IntStream.range(1, 26).mapToObj { newDay(it.toString().padStart(2, '0')) }.toList()
    } else {
        args.map { newDay(it) }.toList()
    }.filterNotNull()

    days.forEach(::runDay)
}
