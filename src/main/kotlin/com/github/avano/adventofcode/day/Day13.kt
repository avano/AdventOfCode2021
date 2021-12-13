package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Coordinate
import com.github.avano.adventofcode.util.Input

class Day13 : Day() {
    private fun Array2D<Char>.setMark(x: Int, y: Int, c: Char) {
        if (get(x, y) == '#') {
            return
        } else {
            set(x, y, c)
        }
    }

    data class Instruction(val axis: String, val count: Int) {
        constructor(line: String) : this(line.split("=")[0], line.split("=")[1].toInt())
    }

    private fun Input.coordinates(): List<Coordinate> {
        return asList().filter { it.matches("\\d+,\\d+".toRegex()) }.map { Coordinate(it.split(',')[0], it.split(',')[1]) }
    }

    private fun Input.instructions(): List<Instruction> {
        return asList().filter { it.contains("fold") }.map { Instruction(it.substringAfter("fold along ")) }
    }

    private fun List<Coordinate>.getMax(): Coordinate {
        return Coordinate(maxByOrNull { it.x }?.x!!, maxByOrNull { it.y }?.y!!)
    }

    private fun initPaper(x: Int, y: Int): Array2D<Char> = Array2D(List(y) { MutableList(x) { '.' } })

    private fun Instruction.map(value: Int): Int {
        return when {
            value == count -> -1
            value < count -> value
            else -> value - ((value - count) * 2)
        }
    }

    private fun Array2D<Char>.processInstruction(i: Instruction): Array2D<Char> {
        val newX = if (i.axis == "x") columnsSize / 2 else columnsSize
        val newY = if (i.axis == "y") rowsSize / 2 else rowsSize
        val newPaper = initPaper(newX, newY)

        for (y in 0 until rowsSize) {
            var currentY = y
            if (i.axis == "y") {
                currentY = i.map(y)
                if (currentY == -1) {
                    continue
                }
            }
            for (x in 0 until columnsSize) {
                var currentX = x
                if (i.axis == "x") {
                    currentX = i.map(x)
                    if (currentX == -1) {
                        continue
                    }
                }

                newPaper.setMark(currentX, currentY, get(x, y))
            }
        }
        return newPaper
    }

    override fun part1(input: Input): Any {
        val points = input.coordinates()
        val instructions = input.instructions()
        val max = points.getMax()
        var sum = 0

        val paper = initPaper(max.x + 1, max.y + 1)
        points.forEach { paper.set(it, '#') }

        paper.processInstruction(instructions.first()).forEach { sum += if (it == '#') 1 else 0 }
        return sum
    }

    override fun part2(input: Input): Any {
        val points = input.coordinates()
        val instructions = input.instructions()
        val max = points.getMax()

        var paper = initPaper(max.x + 1, max.y + 1)
        points.forEach { paper.set(it, '#') }

        instructions.forEach {
            paper = paper.processInstruction(it)
        }
        return "\n" + paper.toString().replace(".", " ")
    }
}
