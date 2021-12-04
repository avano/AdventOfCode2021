@file:OptIn(ExperimentalTime::class)

package com.github.avano.adventofcode

import com.github.avano.adventofcode.day.Day
import java.util.stream.IntStream
import kotlin.streams.toList
import kotlin.time.ExperimentalTime
import kotlin.time.measureTimedValue

private fun runDay(d: Day) {
    println("Day ${d.number}:")
    val (part1, part1Time) = measureTimedValue {
        d.part1(d.inputs.first)
    }
    val (part2, part2Time) = measureTimedValue {
        d.part2(d.inputs.second)
    }
    println("Part 1: $part1 ($part1Time)")
    println("Part 2: $part2 ($part2Time)")
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
