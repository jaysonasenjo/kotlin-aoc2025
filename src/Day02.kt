fun main() {
    fun part1(input: List<String>): Long {
        var sum = 0L
        input.map { it.split(",") }.flatten()
            .map { entry ->
                val range = entry.split("-")
                (range[0].toLong()..range[1].toLong()).forEach { num ->
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

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Read the input from the `src/Day01.txt.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
