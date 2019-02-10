package CodeWarsKata

fun main(args: Array<String>) {


    print(calculateYears(10)[0])
    print(calculateYears(10)[1])
    print(calculateYears(10)[2])

}

fun calculateYears(years: Int): Array<Int> = when (years) {
    1 -> arrayOf(years, years + 14, years + 14)
    2 -> arrayOf(years, years + 22, years + 22)
    else -> arrayOf(years, ((years) * 4 ) + 24 - 8, ((years) * 5 ) + 24 - 10)
}

