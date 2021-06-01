package automata

class Rule(private val number: Int) {
    private val newStates = number.toString(2).padStart(8, '0')

    fun getState(trio: String): Char {
        return newStates[7 - trio.toInt(2)]
    }

    fun getState(a: Int, b: Int, c:Int): Int {
        val trio = a.toString() + b + c
        return newStates[7 - trio.toInt(2)].code - '0'.code
    }

    fun getNumber(): Int{
        return number
    }
}