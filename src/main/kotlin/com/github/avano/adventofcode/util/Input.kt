package com.github.avano.adventofcode.util

class Input(private val lines: List<String>) {
    constructor(s: String) : this(s.split("\n".toRegex()))

    fun asList(): List<String> = lines
    fun asIntList(): List<Int> = lines.map { it.toInt() }
    fun asString(): String = lines.joinToString(separator = "\n").trim()
}
