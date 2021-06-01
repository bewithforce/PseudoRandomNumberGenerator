import automata.CellularAutomata
import automata.PrimitiveCellularAutomata
import automata.Rule
import java.io.File
import java.io.FileOutputStream

const val seed = 1622454244341


fun spiralOrder(a: Array<IntArray>): ArrayList<Int> {
    var i: Int
    var k = 0
    var l = 0
    var m = a.size
    var n: Int = a[0].size
    println(m)
    println(n)
    println()
    val result: ArrayList<Int> = ArrayList(m * n)
    while (k < m && l < n) {
        i = l
        while (i < n) {
            result.add(a[k][i])
            ++i
        }
        k++
        i = k
        while (i < m) {
            result.add(a[i][n - 1])
            ++i
        }
        n--
        if (k < m) {
            i = n - 1
            while (i >= l) {
                result.add(a[m - 1][i])
                --i
            }
            m--
        }
        if (l < n) {
            i = m - 1
            while (i >= k) {
                result.add(a[i][l])
                --i
            }
            l++
        }
    }
    return result
}

fun primitive() {
    val seed = System.currentTimeMillis()

    //class 1
    val r32 = PrimitiveCellularAutomata(seed, 32)

    //class 2
    val r4 = PrimitiveCellularAutomata(seed, 4)
    val r108 = PrimitiveCellularAutomata(seed, 108)

    //class 3
    val r22 = PrimitiveCellularAutomata(seed, 22)
    val r30 = PrimitiveCellularAutomata(seed, 30)
    val r126 = PrimitiveCellularAutomata(seed, 126)
    val r150 = PrimitiveCellularAutomata(seed, 150)
    val r182 = PrimitiveCellularAutomata(seed, 182)

    //class 4 and uncased
    val r110 = PrimitiveCellularAutomata(seed, 110)
    val r62 = PrimitiveCellularAutomata(seed, 62)
    val r73 = PrimitiveCellularAutomata(seed, 73)
    val r54 = PrimitiveCellularAutomata(seed, 54)

    Thread.sleep(2000)

    File("results/r32.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r32.getRand())
        }
    }
    File("results/r4.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r4.getRand())
        }
    }
    File("results/r108.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r108.getRand())
        }
    }
    File("results/r22.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r22.getRand())
        }
    }
    File("results/r30.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r30.getRand())
        }
    }
    File("results/r126.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r126.getRand())
        }
    }
    File("results/r150.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r150.getRand())
        }
    }
    File("results/r182.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r182.getRand())
        }
    }
    File("results/r110.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r110.getRand())
        }
    }
    File("results/r62.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r62.getRand())
        }
    }
    File("results/r73.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r73.getRand())
        }
    }
    File("results/r54.out").printWriter().use { out ->
        for (i in 1..32678) {
            out.print(r54.getRand())
        }
    }
}

fun basicVar(a1: CellularAutomata, a2: CellularAutomata) {
    File("results/${a1.rule.getNumber()}_${a2.rule.getNumber()}.out").printWriter().use { out ->
        a1.curr = 100
        a2.curr = 100
        for (i in 1..31250) {
            val t1 = a1.getLine()
            val t2 = a2.getLine()
            for (j in t1.indices) {
                out.print(t1[j] xor t2[j])
            }
        }
    }
}

fun work() {
    val rulesArray =
        arrayListOf(
            CellularAutomata(seed, 22, 41),
            CellularAutomata(seed, 30, 41),
            CellularAutomata(seed, 45, 41),
            CellularAutomata(seed, 54, 41),
            CellularAutomata(seed, 60, 41),
            CellularAutomata(seed, 62, 41),
            CellularAutomata(seed, 73, 41),
            CellularAutomata(seed, 75, 41),
            CellularAutomata(seed, 86, 41),
            CellularAutomata(seed, 89, 41),
            CellularAutomata(seed, 101, 41),
            CellularAutomata(seed, 102, 41),
            CellularAutomata(seed, 106, 41),
            CellularAutomata(seed, 110, 41),
            CellularAutomata(seed, 120, 41),
            CellularAutomata(seed, 126, 41),
            CellularAutomata(seed, 135, 41),
            CellularAutomata(seed, 149, 41),
            CellularAutomata(seed, 150, 41),
            CellularAutomata(seed, 153, 41),
            CellularAutomata(seed, 169, 41),
            CellularAutomata(seed, 182, 41),
            CellularAutomata(seed, 195, 41),
            CellularAutomata(seed, 225, 41),
        )

    Thread.sleep(10000)
    println("let's go")

    for (i in 0 until rulesArray.size - 1) {
        for (j in i + 1 until rulesArray.size) {
            basicVar(rulesArray[i], rulesArray[j])
        }
    }
}

fun main() {
    val rulesArray =
        intArrayOf(
            22,
            30,
            45,
            54,
            60,
            62,
            73,
            75,
            86,
            89,
            101,
            102,
            106,
            110,
            120,
            126,
            135,
            149,
            150,
            153,
            169,
            182,
            195,
            225,
        )

    println("let's go")

    var i1 = 1
    var i2 = 1
    var i3 = 1
    var i4 = 1

    val list = File("./results").list()!!

    var i = 0
    while(i != list.size){
        var file = File("./results/${list[i]}")
        file.copyTo(File("1/${i1++}"))
        FileOutputStream(File("1/info.txt"), true).bufferedWriter().use { writer ->
            writer.write("${list[i++]}\n")
        }

        file = File("./results/${list[i]}")
        file.copyTo(File("2/${i2++}"))
        FileOutputStream(File("2/info.txt"), true).bufferedWriter().use { writer ->
            writer.write("${list[i++]}\n")
        }

        file = File("./results/${list[i]}")
        file.copyTo(File("3/${i3++}"))
        FileOutputStream(File("3/info.txt"), true).bufferedWriter().use { writer ->
            writer.write("${list[i++]}\n")
        }

        file = File("./results/${list[i]}")
        file.copyTo(File("4/${i4++}"))
        FileOutputStream(File("4/info.txt"), true).bufferedWriter().use { writer ->
            writer.write("${list[i++]}\n")
        }
    }
}

//seed =

//8, 17, 29, 43, 64

// in spiral form indices
// 28, 67, 101, 136, 166, 197, 223, 250, 272, 295, 313, 332, 346, 361, 371, 382, 388, 395, 396, 397,