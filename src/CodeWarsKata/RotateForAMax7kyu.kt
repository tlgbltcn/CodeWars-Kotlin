package CodeWarsKata

/**
 *
 * Let us begin with an example:

Take a number: 56789. Rotate left, you get 67895.

Keep the first digit in place and rotate left the other digits: 68957.

Keep the first two digits in place and rotate the other ones: 68579.

Keep the first three digits and rotate left the rest: 68597. Now it is over since keeping the first four it remains only one digit which rotated is itself.

You have the following sequence of numbers:

56789 -> 67895 -> 68957 -> 68579 -> 68597

and you must return the greatest: 68957.

Task
Write function max_rot(n) which given a positive integer n returns the maximum number you got doing rotations similar to the above example.

So max_rot (or maxRot or ... depending on the language) is such as:

max_rot(56789) should return 68957

max_rot(38458215) should return 85821534

 */

fun main(args: Array<String>) {
    print( maxRott(38458215))

}

fun maxRot(n: Long) : Long {

    val numberList = arrayListOf<Long>()
    numberList.add(n)
    var text = n.toString()

    (1 until n.toString().length).forEach { t ->
        text = text.removeRange(t-1, t) + text[t-1]
        numberList.add(text.toLong())
    }

    return numberList.reduce{ max, element -> if(element > max) element else max}
}


/*********************** Best Practice *************************/


fun maxRott(n:Long):Long =
        generateSequence ("" to n.toString()) {
            if (it.second.length < 2) null
            else it.first + it.second[1] to it.second.substring(2) + it.second[0]
        }.map {
            (it.first + it.second).toLong()
        }.max()?:n

/*********************** Best Practice *************************/


fun maxRottt(n:Long):Long = generateSequence("" to n.toString()) { it ->
    it.takeIf{ it.second.length >= 2}
            ?.let { (a, b) -> (a + b[1]) to (b.drop(2) + b[0]) }
}.map { (a, b) -> (a + b).toLong() }
        .max() ?: n


/*********************** Best Practice *************************/

fun maxRotttt(n: Long) = n.toString().let {
    it.foldIndexed(listOf(it.toLong())) { index, acc, _ ->
        acc + listOf(acc[index].toString().let { it ->
            (it.take(index) + it.drop(index).let { it.drop(1) + it.take(1) }).toLong()
        })
    }.max() ?: 0
}