package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Coordinate
import com.github.avano.adventofcode.util.Input
import java.lang.Integer.max
import kotlin.math.abs

class Day05 : Day() {
    data class Line(val from: Coordinate, val to: Coordinate) {
        fun max() = Coordinate(max(from.x, to.y), max(from.y, to.y))
        fun isStraight() = from.x == to.x || from.y == to.y
        fun distance() = max(abs(from.x - to.x), abs(from.y - to.y))
    }

    private fun Array2D<Int>.increment(x: Int, y: Int) = set(x, y, get(x, y) + 1)

    private fun List<String>.toLines(): List<Line> {
        val regex = "^(\\d+),(\\d+) -> (\\d+),(\\d+)$".toRegex()
        return mapNotNull {
            regex.matchEntire(it)?.destructured?.let { (x1, y1, x2, y2) ->
                Line(
                    Coordinate(x1, y1),
                    Coordinate(x2, y2)
                )
            }
        }
    }

    private fun List<Line>.getMax(): Coordinate {
        var x = -1
        var y = -1
        onEach {
            val lineMax = it.max()
            x = if (lineMax.x > x) lineMax.x else x
            y = if (lineMax.y > y) lineMax.y else y
        }
        return Coordinate(x, y)
    }

    private fun List<Line>.process(array: Array2D<Int>) {
        forEach {
            val xStep = if (it.from.x > it.to.x) -1 else if (it.from.x < it.to.x) 1 else 0
            val yStep = if (it.from.y > it.to.y) -1 else if (it.from.y < it.to.y) 1 else 0
            repeat(it.distance() + 1) { inc ->
                array.increment(it.from.x + (xStep * inc), it.from.y + (yStep * inc))
            }
        }
    }

    private fun solve(list: List<Line>): Int {
        val max = list.getMax()

        val array = Array2D(List(max.y + 1) { MutableList(max.x + 1) { 0 } })
        list.process(array)

        var overlaps = 0
        array.forEach { overlaps += if (it > 1) 1 else 0 }

        return overlaps
    }

    override fun part1(input: Input): Any {
        return solve(input.asList().toLines().filter { it.isStraight() })
    }

    override fun part2(input: Input): Any {
        return solve(input.asList().toLines())
    }
}
