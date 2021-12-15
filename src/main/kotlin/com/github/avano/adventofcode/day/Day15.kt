package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Coordinate
import com.github.avano.adventofcode.util.Input

class Day15 : Day() {
    data class Node(val value: Int = -1, var distance: Int = Integer.MAX_VALUE, var visited: Boolean = false) {
        override fun toString(): String {
            return value.toString()
        }
    }

    private fun Array2D<Node>.getRisk(end: Coordinate): Int {
        get(0, 0).distance = 0
        val queue = mutableListOf(Coordinate(0, 0))
        while (queue.isNotEmpty()) {
            val coord = queue.removeFirst()
            if (coord == end) {
                break
            }

            val el = get(coord)
            if (el.visited) {
                continue
            }
            el.visited = true

            val neighbours = neighbours(coord).filter { !get(it).visited }
            neighbours.forEach {
                val nDist = el.distance + get(it).value
                if (nDist < get(it).distance) {
                    get(it).distance = nDist
                }
            }
            queue.addAll(neighbours)
            queue.sortBy { get(it).distance }
        }
        return get(end).distance
    }

    override fun part1(input: Input): Any {
        val map = input.as2DArray { Node(it.digitToInt()) }
        return map.getRisk(Coordinate(map.columnsSize - 1, map.rowsSize - 1))
    }

    override fun part2(input: Input): Any {
        fun Array2D<Node>.extend(times: Int): Array2D<Node> {
            fun Int.overflow(): Int = if (this >= 10) this - 9 else this
            val map = Array2D(List(this.rowsSize * times) { MutableList(this.columnsSize * times) { Node() } })
            for (y in 0 until map.rowsSize) {
                val yIncrement = y / this.columnsSize
                for (x in 0 until map.columnsSize) {
                    val xIncrement = x / this.columnsSize
                    val prev = this.get(x % this.columnsSize, y % this.rowsSize)
                    map.set(x, y, prev.copy(value = (prev.value + yIncrement + xIncrement).overflow()))
                }
            }
            return map
        }

        val map = input.as2DArray { Node(it.digitToInt()) }.extend(5)
        return map.getRisk(Coordinate(map.columnsSize - 1, map.rowsSize - 1))
    }
}
