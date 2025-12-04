
fun main() {

    fun List<String>.toLongPair(): List<Pair<Long, Long>> =
        this.map { it.split(",") }
            .flatten()
            .map { it.split("-") }
            .map { Pair(first = it[0].toLong(), second = it[1].toLong()) }

    fun part1(input: List<String>): Long {
        var sum = 0L
        input.toLongPair().forEach { entry ->
            (entry.first..entry.second).forEach { num ->
                val numStr = num.toString()
                val size = numStr.length
                if (size % 2 == 0) {
                    if (numStr.take(size/2) == numStr.takeLast(size/2)) {
                        sum += num
                    }
                }
            }
        }
        return sum
    }

    fun part2(input: List<String>): Long {
        var sum = 0L
        input.toLongPair().forEach { pair ->
            (pair.first..pair.second).forEach { num ->
                val numStr = num.toString()
                val mask = numStr.fold("") { mask, nextChar ->
                    var validMask = false
                    if (mask.isNotEmpty()) {
                        for (n in 1..numStr.length) {
                            validMask = (mask.repeat(n) == numStr)
                            if (validMask || numStr.length <= n * mask.length) break
                        }
                    }

                    if (validMask) mask else "$mask$nextChar"
                }
                sum += if (mask == numStr) 0L else num
            }
        }
        return sum
    }

    // Read the input from the `src/Day01.txt.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
