fun main() {
    fun removableRoll(input: List<String>, x: Int, y: Int): Boolean =
        listOf(
            input.getOrElse(x-1) { "."}.getOrElse(y-1) { '.' },
            input.getOrElse(x) { "."}.getOrElse(y-1) { '.' },
            input.getOrElse(x+1) { "."}.getOrElse(y-1) { '.' },
            input.getOrElse(x-1) { "."}.getOrElse(y) { '.' },
            input.getOrElse(x+1) { "."}.getOrElse(y) { '.' },
            input.getOrElse(x-1) { "."}.getOrElse(y+1) { '.' },
            input.getOrElse(x) { "."}.getOrElse(y+1) { '.' },
            input.getOrElse(x+1) { "."}.getOrElse(y+1) { '.' }
        ).count { '@' == it } < 4

    fun part1(input: List<String>): Int {
        var removable = 0
        for (y in 0..<input.size) {
            for (x in 0..<input[y].length) {
                if (input[x][y] != '@') continue

                val removableRoll = removableRoll(input, x, y)
                if (removableRoll) {
                    removable++
                }
            }
        }
        return removable
    }

    fun part2(input: List<String>): Int {
        var removable = 0
        val newInput = mutableListOf<String>()
        for (y in 0..<input.size) {
            var newRow = ""
            for (x in 0..<input[y].length) {
                if (input[x][y] != '@') {
                    newRow += input[x][y]
                    continue
                }

                if (removableRoll(input, x, y)) {
                    removable++
                    newRow += '.'
                } else newRow += input[x][y]
            }
            newInput.add(newRow)
        }
        return if (removable > 0) removable + part2(newInput) else removable
    }

    // Read the input from the `src/Day01.txt.txt` file.
    val input = readInput("DayX")
    part1(input).println()
    part2(input).println()
}
