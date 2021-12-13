package com.github.avano.adventofcode.day

import com.github.avano.adventofcode.util.Input

class Day12 : Day() {
    data class Path(private val sb: StringBuilder = StringBuilder(), var visitedTwice: Boolean = false, var done: Boolean = false) {
        fun add(cave: String) {
            sb.append(cave)
            if (cave == "end") {
                done = true
            } else {
                sb.append(",")
            }
        }

        fun contains(cave: String): Boolean {
            return sb.contains(cave)
        }

        fun clone(): Path = Path(StringBuilder(sb), visitedTwice, done)
    }

    private fun String.isLowercase(): Boolean = all { it.isLowerCase() }

    private fun Map<String, Set<String>>.nextCaves(cave: String, path: Path): Set<String> {
        return this.getValue(cave)
            .filter { "start" != it }
            .filter {
                if (it.isLowercase()) {
                    if (!path.contains(it)) {
                        true
                    } else !path.visitedTwice
                } else {
                    true
                }
            }.toSet()
    }

    private fun Input.parseDirections(): Map<String, Set<String>> {
        val paths = mutableMapOf<String, MutableSet<String>>()
        asList().forEach { line ->
            val (from, to) = line.split("-")
            paths[from] = (paths[from] ?: mutableSetOf()).apply { add(to) }
            paths[to] = (paths[to] ?: mutableSetOf()).apply { add(from) }
        }
        return paths
    }

    private fun Map<String, Set<String>>.traverse(cave: String, path: Path, result: MutableSet<Path>): Path {
        path.add(cave)
        if (path.done) {
            return path
        }

        nextCaves(cave, path).forEach {
            val clone = path.clone()
            if (it.isLowercase() && clone.contains(it)) {
                clone.visitedTwice = true
            }
            val p = traverse(it, clone, result)
            if (p.done) {
                result.add(p)
            }
        }

        return path
    }

    override fun part1(input: Input): Any {
        val result = mutableSetOf<Path>()
        input.parseDirections().traverse("start", Path(visitedTwice = true), result)
        return result.size
    }

    override fun part2(input: Input): Any {
        val result = mutableSetOf<Path>()
        input.parseDirections().traverse("start", Path(), result)
        return result.size
    }
}
