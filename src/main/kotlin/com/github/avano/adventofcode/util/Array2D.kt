package com.github.avano.adventofcode.util

class Array2D<T>(val list: List<MutableList<T>>) {
    val rowsSize = list.size
    val columnsSize = list[0].size

    fun get(x: Int, y: Int): T = list[y][x]
    fun get(c: Coordinate): T = get(c.x, c.y)
    fun set(x: Int, y: Int, t: T) = list[y].set(x, t)

    fun forEach(f: (T) -> Unit) {
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                f(get(x, y))
            }
        }
    }

    fun neighbours(c: Coordinate): List<Coordinate> = neighbours(c.x, c.y)
    fun neighbours(x: Int, y: Int): List<Coordinate> {
        val result = mutableListOf<Coordinate>()
        if (x > 0) {
            result.add(Coordinate(x - 1, y))
        }
        if (x < columnsSize - 1) {
            result.add(Coordinate(x + 1, y))
        }
        if (y > 0) {
            result.add(Coordinate(x, y - 1))
        }
        if (y < rowsSize - 1) {
            result.add(Coordinate(x, y + 1))
        }
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                sb.append(get(x, y)).append(" ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }
}

data class Coordinate(val x: Int, val y: Int) {
    constructor(x: String, y: String) : this(x.toInt(), y.toInt())
}
