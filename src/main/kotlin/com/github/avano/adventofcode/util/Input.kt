package com.github.avano.adventofcode.util

import java.lang.StringBuilder

class Input(private val lines: List<String>) {
    constructor(s: String) : this(s.split("\n".toRegex()))

    fun asList(): List<String> = lines
    fun asIntList(): List<Int> = lines.map { it.toInt() }
    fun asInts(): List<Int> = lines[0].split(',').map { it.toInt() }
    fun <T> as2DArray(mapper: (Char) -> T): Array2D<T> = Array2D(asList().map { it.trim().map(mapper).toMutableList() })
}
