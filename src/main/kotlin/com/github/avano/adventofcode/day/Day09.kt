package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Coordinate
import com.github.avano.adventofcode.util.Input

class Day09 : Day() {
    private fun Array2D<Int>.isLowPoint(x: Int, y: Int): Boolean {
        val thisValue = get(x, y)
        return neighbours(x, y).all { get(it) > thisValue }
    }

    private fun Array2D<Int>.lowPoints(): List<Coordinate> {
        val result = mutableListOf<Coordinate>()
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                if (isLowPoint(x, y)) {
                    result.add(Coordinate(x, y))
                }
            }
        }
        return result
    }

    override fun part1(input: Input): Any {
        val heightMap = input.as2DArray { it.digitToInt() }
        return heightMap.lowPoints().fold(0) { sum, c -> sum + 1 + heightMap.get(c) }
    }

    override fun part2(input: Input): Any {
        val heightMap = input.as2DArray { it.digitToInt() }
        val basins = mutableListOf<Int>()
        val visited = mutableSetOf<Coordinate>()

        for (lowPoint in heightMap.lowPoints()) {
            var sum = 0
            val queue = mutableListOf(lowPoint)
            while (queue.isNotEmpty()) {
                val current = queue.removeFirst()
                if (!visited.contains(current)) {
                    sum++
                    queue.addAll(heightMap.neighbours(current).filter { c ->
                        !visited.contains(c)
                                && heightMap.get(c) > heightMap.get(current)
                                && heightMap.get(c) < 9
                    })
                    visited.add(current)
                }
            }
            basins.add(sum)
        }
        return basins.sorted().takeLast(3).fold(1) { sum, e -> sum * e }
    }
}
