package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

private val regex = "^(\\w+) (\\d+)$".toRegex()

private fun Input.eachLine(f: (String, Int) -> Unit) {
    asList().forEach {
        regex.matchEntire(it)?.destructured?.let { (direction, length) ->
            f(direction, length.toInt())
        }
    }
}

class Day02 : Day() {
    override fun part1(input: Input): Any {
        var horizontal = 0
        var depth = 0

        fun process(direction: String, length: Int) {
            when (direction) {
                "forward" -> horizontal += length
                "up" -> depth -= length
                "down" -> depth += length
                else -> println("Unknown direction $direction")
            }
        }

        input.eachLine(::process)

        return horizontal * depth
    }

    override fun part2(input: Input): Any {
        var horizontal = 0
        var depth = 0
        var aim = 0

        fun process(direction: String, length: Int) {
            when (direction) {
                "forward" -> {
                    horizontal += length
                    if (aim != 0) {
                        depth += length * aim
                    }
                }
                "up" -> aim -= length
                "down" -> aim += length
                else -> println("Unknown direction $direction")
            }
        }

        input.eachLine(::process)

        return horizontal * depth
    }
}
