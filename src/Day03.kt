import kotlin.collections.forEach

fun main() {

    fun part1(input: List<String>): Long {
        return input.sumOf { line ->
            var indexLeft = 0
            var maxLeft = 0
            line.take(line.length - 1).forEachIndexed { i, c ->
                if (c.digitToInt() > maxLeft) {
                    indexLeft = i
                    maxLeft = c.digitToInt()
                }
            }
            var maxRight = 0
            line.withIndex().reversed().forEach {
                maxRight = if (it.index > indexLeft && it.value.digitToInt() > maxRight)
                    it.value.digitToInt() else maxRight
            }

            "$maxLeft$maxRight".toLong()
        }
    }

    fun part2(input: List<String>): Long {
        return input.sumOf { line ->
            val maxSize = 12
            var currLeftPointer = 0
            var maxNumStr = ""

            (maxSize-1 downTo 0).forEach {
                var max = 0
                var maxIndex = 0
                val subStr = line.substring(currLeftPointer, line.length - it)
                subStr.map { c -> c.digitToInt() }
                    .forEachIndexed { i, num ->
                        if (num > max ) {
                            maxIndex = i
                            max = num
                        }
                }
                maxNumStr += max
                currLeftPointer += maxIndex + 1
            }
            maxNumStr.toLong()
        }
    }

    // Read the input from the `src/Day01.txt.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
