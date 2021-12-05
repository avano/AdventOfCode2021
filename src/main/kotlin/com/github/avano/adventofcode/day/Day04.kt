package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Array2D
import com.github.avano.adventofcode.util.Input

class Day04 : Day() {
    class BingoNumber(val number: Int, var found: Boolean = false)

    class BingoBoard(private val board: Array2D<BingoNumber>, var active: Boolean = true) {
        fun mark(number: Int) {
            for (y in 0 until board.rowsSize) {
                for (x in 0 until board.columnsSize) {
                    if (board.get(x, y).number == number) {
                        board.get(x, y).found = true
                        break
                    }
                }
            }
        }

        fun count(): Int {
            var sum = 0
            board.forEach { n -> sum += if (!n.found) n.number else 0 }
            return sum
        }

        fun check() = board.checkRows() || board.checkColumns()

        private fun Array2D<BingoNumber>.checkRows(): Boolean {
            for (y in 0 until rowsSize) {
                var found = true
                for (x in 0 until columnsSize) {
                    found = found && get(x, y).found
                }
                if (found) {
                    return true
                }
            }
            return false
        }

        private fun Array2D<BingoNumber>.checkColumns(): Boolean {
            for (x in 0 until columnsSize) {
                var found = true
                for (y in 0 until rowsSize) {
                    found = found && get(x, y).found
                }
                if (found) {
                    return true
                }
            }
            return false
        }
    }

    private fun createBoards(input: List<String>): List<BingoBoard> {
        val boards = mutableListOf<BingoBoard>()

        for (i in 2 until input.size step 6) {
            val b = mutableListOf<MutableList<BingoNumber>>()
            for (j in i..i + 4) {
                b.add(input[j].split(' ').filter { it.isNotEmpty() }.map { BingoNumber(it.toInt()) } as MutableList<BingoNumber>)
            }
            boards.add(BingoBoard(Array2D(b)))
        }
        return boards
    }

    override fun part1(input: Input): Any {
        val numbers = input.asList()[0].split(',').map { it.toInt() }.toList()
        val boards = createBoards(input.asList())

        for (n in numbers) {
            for (b in boards.indices) {
                boards[b].mark(n)
                if (boards[b].check()) {
                    return n * boards[b].count()
                }
            }
        }
        return -1
    }

    override fun part2(input: Input): Any {
        val numbers = input.asList()[0].split(',').map { it.toInt() }.toList()
        val boards = createBoards(input.asList())

        for (n in numbers) {
            for (b in boards.indices) {
                if (boards[b].active) {
                    boards[b].mark(n)
                    if (boards[b].check()) {
                        if (boards.filter { it.active }.size == 1) {
                            return n * boards[b].count()
                        } else {
                            boards[b].active = false
                        }
                    }
                }
            }
        }
        return -1
    }
}
