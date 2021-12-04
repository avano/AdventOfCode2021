package com.github.avano.adventofcode.util

class Array2D<T>(val list: List<List<T>>) {
    val rowsSize = list.size
    val columnsSize = list[0].size

    fun get(x: Int, y: Int): T = list[y][x]

    fun forEach(f: (T) -> Unit) {
        for (y in 0 until rowsSize) {
            for (x in 0 until columnsSize) {
                f(get(x, y))
            }
        }
    }
}
