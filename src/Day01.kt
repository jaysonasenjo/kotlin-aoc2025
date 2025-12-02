fun main() {
    fun part1(input: List<String>): Int {
        var dial = 50
        return input.count {
            val clicks = it.drop(1).toInt()
            dial = if (it[0] == 'L')
                (dial - clicks) % 100
            else
                (dial + clicks) % 100
            dial == 0
        }
    }

    fun part2(input: List<String>): Int {
        var dial = 50
        return input.map {
            val direction = if (it[0] == 'L') -1 else 1
            val clicks = it.drop(1).toInt()
            (0..<clicks).count {
                dial = (dial + direction) % 100
                dial == 0
            }
        }.reduce { sum, next -> sum + next }
    }

    // Read the input from the `src/Day01.txt.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
