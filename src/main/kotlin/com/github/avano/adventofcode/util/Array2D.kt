package com.github.avano.adventofcode.util

import java.lang.StringBuilder

class Array2D<T>(val list: List<MutableList<T>>) {
    val rowsSize = list.size
    val columnsSize = list[0].size

    fun get(x: Int, y: Int): T = list[y][x]
    fun set(x: Int, y: Int, t: T) = list[y].set(x, t)

    fun forEach(f: (T) -> Unit) {
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                f(get(x, y))
            }
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                sb.append(if (get(x,y) == 0) "." else get(x,y)).append(" ")
            }
            sb.append("\n")
        }
        return sb.toString()
    }
}

class Coordinate(val x: Int, val y: Int) {
    constructor(x: String, y: String): this(x.toInt(), y.toInt())
}
