package com.github.avano.adventofcode.util

import java.io.File

private const val PATH = "src/main/resources/input"
private const val PART_FILE_PREFIX = "part"
private const val INPUT_FILE_PREFIX = "input"

fun getInputs(day: String): Pair<Input, Input> {
    val files = File("$PATH/$day").listFiles()
    if (files == null || files.isEmpty()) {
        throw IllegalArgumentException("No files found in $PATH/$day folder")
    }
    val content: Map<String, List<String>> = files.associate { it.name to it.readLines() }
    return if (files.size == 2) Pair(Input(content.getValue(PART_FILE_PREFIX + 1)), Input(content.getValue(PART_FILE_PREFIX + 2)))
        else Pair(Input(content.getValue(INPUT_FILE_PREFIX)), Input(content.getValue(INPUT_FILE_PREFIX)))
}
