import java.io.File

fun main() {
    fun day01(): List<Int> { // returns a list of total calories per elf
        val calorieList = File("src/main/kotlin/day01.txt").readLines()
        val emptyStringIndices = calorieList.mapIndexedNotNull { index, line -> if (line.isEmpty()) index else null }
        return emptyStringIndices.mapIndexed { index, emptyStringIndex ->
            val fromIndex = if (index == 0) 0 else emptyStringIndices[index - 1] + 1
            calorieList.subList(fromIndex, emptyStringIndex).map { it.toInt() }.total()
        }
    }

    println("Day 01 part 1 solution: ${day01().max()}")
    println("Day 01 part 2 solution: ${day01().sortedDescending().subList(0, 3).total()}")
}