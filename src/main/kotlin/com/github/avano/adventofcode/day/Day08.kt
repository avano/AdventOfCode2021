package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day08 : Day() {

    override fun part1(input: Input): Any {
        fun List<String>.countSimple(): Int = this.stream().filter { it.trim().length in 2..4 || it.trim().length == 7 }.count().toInt()

        var sum = 0
        for (line in input.asList()) {
            val (_, right) = line.split('|')
            sum += right.split(' ').countSimple()
        }

        return sum
    }

    override fun part2(input: Input): Any {
        val digitMap = mapOf(
            "abcefg" to 0,
            "cf" to 1,
            "acdeg" to 2,
            "acdfg" to 3,
            "bcdf" to 4,
            "abdfg" to 5,
            "abdefg" to 6,
            "acf" to 7,
            "abcdefg" to 8,
            "abcdfg" to 9
        )

        fun init(): MutableMap<Char, MutableSet<Char>> = ('a'..'g').associateWith { mutableSetOf<Char>() }.toMutableMap()
        fun String.sortedSplit() = split(" ").sortedBy { it.trim().length }.toMutableList()
        fun Map<Char, Char>.matchesDigit(s: String): Boolean = s.map { this[it] }.sortedBy { it }.joinToString(separator = "") in digitMap.keys

        var sum = 0
        for (line in input.asList()) {
            val mapping = init()
            val (sourceDigits, targetDigits) = line.split(" | ")
            val digits = sourceDigits.sortedSplit()

            // Populate mapping map with possible mappings
            for (entry in digits.groupBy { it.length }) {
                val sourceRemaining = mutableSetOf<Char>()
                val targetRemaining = digitMap.keys.filter { it.length == entry.key }.map { it.toSet() }.flatten().toMutableSet()
                for (sourceDigit in entry.value) {
                    sourceRemaining.addAll(sourceDigit.toSet())
                    for (sourceSignal in sourceDigit) {
                        if (mapping.getValue(sourceSignal).isNotEmpty()) {
                            sourceRemaining.remove(sourceSignal)
                            targetRemaining.removeAll(mapping.getValue(sourceSignal))
                        }
                    }
                }
                sourceRemaining.forEach { mapping.getValue(it).addAll(targetRemaining) }
            }

            // Create all possible combinations of mappings
            var mappings = mutableSetOf<MutableMap<Char, Char>>()
            for (sourceDigit in digits) {
                for (sourceSignal in sourceDigit) {
                    if (mappings.isEmpty()) {
                        for (targetSignal in mapping.getValue(sourceSignal)) {
                            mappings.add(mutableMapOf(sourceSignal to targetSignal))
                        }
                    } else {
                        val newMappings = mutableSetOf<MutableMap<Char, Char>>()
                        for (targetSignal in mapping.getValue(sourceSignal)) {
                            // filter all mappings that do not have source->signal mapped yet
                            mappings.filter { !it.containsKey(sourceSignal) && !it.containsValue(targetSignal) }.forEach {
                                // Create a copy of each map and add a new mapping there
                                val newMap = HashMap(it)
                                newMap[sourceSignal] = targetSignal
                                newMappings.add(newMap)
                            }
                        }
                        // Do nothing if nothing changed in this step (all mappings were already present)
                        if (newMappings.size > 0) {
                            mappings = newMappings
                        }
                    }
                }
            }

            // Iterate over digits until there is only one mapping left
            var remainingMappings = mappings.toSet()
            while (remainingMappings.size != 1) {
                val sourceDigit = digits.removeFirst()
                remainingMappings = remainingMappings.filter { it.matchesDigit(sourceDigit) }.toSet()
            }

            // Build the resulting number from separated numbers
            val sb = StringBuilder()
            for (targetDigit in targetDigits.split(" ")) {
                // Apply the mapping and sort the chars alphabetically, so that they match the keys in digitMap
                sb.append(digitMap.getValue(targetDigit.map { remainingMappings.first()[it] }.sortedBy { it }.joinToString(separator = "")))
            }
            sum += sb.toString().toInt()
        }
        return sum
    }
}
