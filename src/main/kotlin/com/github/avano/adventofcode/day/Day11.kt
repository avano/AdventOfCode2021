package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Coordinate
import com.github.avano.adventofcode.util.Input

class Day11 : Day() {
    class Octopus(var energy: Int = 0, var flashed: Boolean = false, var visited: Boolean = false) {
        fun flash() {
            energy = 0
            flashed = true
        }

        fun increase() {
            energy++
        }

        fun reset() {
            flashed = false
            visited = false
        }
    }

    private fun Array2D<Octopus>.process(): MutableList<Coordinate> {
        val result = mutableListOf<Coordinate>()
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                val octopus = get(x, y)
                octopus.increase()
                octopus.reset()

                if (octopus.energy > 9) {
                    result.add(Coordinate(x, y))
                }
            }
        }
        return result
    }

    private fun Array2D<Octopus>.increasedAdjacent(c: Coordinate) = adjacent(c).filter { !get(it).flashed && !get(it).visited }
        .onEach { get(it).increase() }

    private fun MutableList<Coordinate>.countFlashes(array: Array2D<Octopus>): Int {
        var flashes = 0
        while (isNotEmpty()) {
            val currentCoordinates = removeFirst()
            val currentOctopus = array.get(currentCoordinates)
            if (!currentOctopus.flashed && currentOctopus.energy > 9) {
                currentOctopus.flash()
                flashes++
                currentOctopus.visited = true
                addAll(array.increasedAdjacent(currentCoordinates))
            }
        }
        return flashes
    }

    override fun part1(input: Input): Any {
        val array = input.as2DArray { Octopus(energy = it.digitToInt()) }
        var flashes = 0

        repeat(100) {
            val queue = array.process()
            flashes += queue.countFlashes(array)
        }

        return flashes
    }

    override fun part2(input: Input): Any {
        val array = input.as2DArray { Octopus(energy = it.digitToInt()) }
        var i = 0
        while (true) {
            i++
            val queue = array.process()

            if (queue.countFlashes(array) == 100) {
                return i
            }
        }
    }
}
