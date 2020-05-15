package katas.`6kyu`

/**
 * When you divide the successive powers of 10 by 13 you get the following remainders of the integer divisions:

1, 10, 9, 12, 3, 4.

Then the whole pattern repeats.

Hence the following method: Multiply the right most digit of the number with the left most number in the sequence shown above,
the second right most digit to the second left most digit of the number in the sequence. The cycle goes on and you sum all these products.
Repeat this process until the sequence of sums is stationary.

...........................................................................

Example: What is the remainder when 1234567 is divided by 13?

7×1 + 6×10 + 5×9 + 4×12 + 3×3 + 2×4 + 1×1 = 178

We repeat the process with 178:

8x1 + 7x10 + 1x9 = 87

and again with 87:

7x1 + 8x10 = 87

...........................................................................

From now on the sequence is stationary and the remainder of 1234567 by 13 is the same as the remainder of 87 by 13: 9

Call thirt the function which processes this sequence of operations on an integer n (>=0). thirt will return the stationary number.

thirt(1234567) calculates 178, then 87, then 87 and returns 87.

thirt(321) calculates 48, 48 and returns 48
 */

// division by 13
fun divisionBy13(n: Long): Long {
    var t = n
    return generateSequence(t) {
        t = t.toString().dropLast(1).toLong() + (t % 10) * 4
        t
    }.filter { it.toString().length < 3 }.map { (it % 13) }.first()
}

fun main() {
    println(thirt(8529))
}

val ruleArr = listOf(1, 10, 9, 12, 3, 4)

fun thirt(n: Long) = generateSequence(n) {
    var indextX = -1
    it.toString().reversed().foldIndexed(0) { i, acc, c ->
        if (i % ruleArr.size != 0) indextX++ else indextX = 0
        acc + (c.toString().toInt() * ruleArr[indextX])
    }.toLong()

}.take(10).last()


val seq = listOf(1, 10, 9, 12, 3, 4);

tailrec fun thirtt(n: Long): Long {
    val v = n.toString().toList()
        .reversed()
        .mapIndexed { index, c -> c.toString().toLong() * seq[index % seq.size] }
        .sum()
    return if (v < 100) v else thirt(v)
}


tailrec fun thirttt(n: Long): Long {
    val new = n.toString().reversed().map { it - '0' }.mapIndexed { i, c -> seq[i % seq.size] * c }.sum().toLong()
    return if (new == n) n
    else thirt(new)
}

fun thirtttt(n: Long): Long {
    val d = longArrayOf(1, 10, 9, 12, 3, 4)
    var p = n
    while (true) {
        val c = p.toString().reversed().mapIndexed { i, c -> d[i % d.size] * (c - '0') }.sum()
        if (p == c) return p
        p = c
    }
}

fun thirttttt(n: Long): Long = n.toString()
    .reversed()
    .mapIndexed { index, c -> (c - '0').toLong() * listOf(1, 10, 9, 12, 3, 4)[index % 6] }
    .sum()
    .let { if (it < 100) it else thirt(it) }

fun thirtttttt(n: Long): Long {
    val i =
        n.toString().reversed().mapIndexed { i, c -> Character.getNumericValue(c) * arrayOf(1, 10, 9, 12, 3, 4)[i % 6] }
            .sum().toLong()
    return when (i) {
        n -> i
        else -> thirt(i)
    }
}
