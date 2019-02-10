package CodeWarsKata

fun main(args: Array<String>) {

    print(nbYear(1500, 5.0, 100, 5000))
    print(nbYear_(1500, 5.0, 100, 5000))
}


fun nbYear(pp0: Int, percent: Double, aug: Int, p: Int): Int {

    var year = 0
    var total = pp0.toDouble()
    while (total < p) {
        year++
        total += (total * percent / 100 + (aug))
    }
    return year
}


/*********************** Best Practice *************************/


fun nbYear_(pp0: Int, percent: Double, aug: Int, p: Int): Int =
        generateSequence(pp0.toDouble()){it + (it * percent/100) + aug }.takeWhile { it<p }.count()
