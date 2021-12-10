package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day10 : Day() {
    private fun Char.getClosingBracket(): Char {
        return when (this) {
            '(' -> ')'
            '[' -> ']'
            '{' -> '}'
            '<' -> '>'
            else -> throw IllegalArgumentException()
        }
    }

    private fun Char.isBeginning() = listOf('(', '[', '{', '<').any { this == it }

    private fun String.getCorruptedScore(): Int {
        val scoreMap = mapOf(')' to 3, ']' to 57, '}' to 1197, '>' to 25137)
        var score = 0
        val bracketList = mutableListOf<Char>()
        for (char in this) {
            if (char.isBeginning()) {
                bracketList.add(char)
            } else {
                if (bracketList.last().getClosingBracket() != char) {
                    score += scoreMap.getValue(char)
                    break
                } else {
                    bracketList.removeLast()
                }
            }
        }
        return score
    }

    private fun String.getImcompleteScore(): Long {
        val scoreMap = mapOf(')' to 1, ']' to 2, '}' to 3, '>' to 4)
        val bracketList = mutableListOf<Char>()
        for (char in this) {
            if (char.isBeginning()) {
                bracketList.add(char)
            } else {
                bracketList.removeLast()
            }
        }
        return bracketList.reversed().fold(0) { sum, e -> sum * 5 + scoreMap.getValue(e.getClosingBracket()) }
    }

    override fun part1(input: Input): Any {
        return input.asList().fold(0) { sum, e -> sum + e.getCorruptedScore() }
    }

    override fun part2(input: Input): Any {
        val scores = input.asList().filter { it.getCorruptedScore() == 0 }.map { it.getImcompleteScore() }.filter { it != 0L }.sorted()
        return scores[scores.size / 2]
    }
}
