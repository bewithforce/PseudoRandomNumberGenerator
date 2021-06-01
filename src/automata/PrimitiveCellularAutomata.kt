package automata

import java.util.*

class PrimitiveCellularAutomata(seedNumber: Long, ruleNumber: Int) {
    private val rule = Rule(ruleNumber)

    private val arrayOfRands = LinkedList<Boolean>()

    private val arrayOfLines = LinkedList<String>()

    init {
        arrayOfLines.add(seedNumber.toString(2).padStart(32, '0'))
        Thread {
            for (i in 1..65536) {
                val temp = nextLine()
                arrayOfLines.add(temp)
                if (i % 2 == 0)
                    arrayOfRands.add(temp[32] == '1')
                else
                    arrayOfRands.add(temp[31] == '1')
            }
        }.start()
    }

    private fun nextLine(): String {
        val tempLine = arrayOfLines.last[arrayOfLines.last.length - 1] + arrayOfLines.last + arrayOfLines.last[0]
        val newLine = StringBuilder(tempLine.length)

        for (i in 1 until tempLine.length - 1) {
            newLine.append(rule.getState(tempLine.substring(i - 1, i + 2)))
        }
        return newLine.toString()
    }

    fun getRand(): Int {
        val result = arrayOfRands.first
        arrayOfRands.removeFirst()
        return if (result) 1 else 0
    }

    fun getLine(): String {
        val result = arrayOfLines.first
        arrayOfLines.removeFirst()
        return result
    }
}