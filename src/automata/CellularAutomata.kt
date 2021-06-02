package automata

import java.util.*

class CellularAutomata(seedNumber: Long, public val ruleNumber: Int, public val length: Int) {
    val rule = Rule(ruleNumber)
    var curr = 100
    private val arrayOfLines = LinkedList<IntArray>()

    init {
        arrayOfLines.add(seedNumber.toString(2).toCharArray().map { it.code - '0'.code }.take(length).toIntArray())
        Thread {
            for (i in 1..1_001_000) {
                val temp = nextLine()
                arrayOfLines.add(temp)
            }
        }.start()
    }

    private fun nextLine(): IntArray {
        val tempLine = arrayOfLines.last
        val newLine = IntArray(tempLine.size)

        val last = tempLine.size - 1

        newLine[0] = rule.getState(tempLine[last], tempLine[0], tempLine[1])
        for (i in 1 until last) {
            newLine[i] = rule.getState(tempLine[i - 1], tempLine[i], tempLine[i + 1])
        }
        newLine[last] = rule.getState(tempLine[last - 1], tempLine[last], tempLine[0])

        return newLine
    }

    fun getLine(): IntArray {
        return arrayOfLines[curr++]
    }
}