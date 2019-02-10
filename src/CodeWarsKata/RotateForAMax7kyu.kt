package CodeWarsKata

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