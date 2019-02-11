package CodeWarsKata

/**
 * Kata Task
I have a cat and a dog.

I got them at the same time as kitten/puppy. That was humanYears years ago.

Return their respective ages now as [humanYears,catYears,dogYears]

NOTES:

humanYears >= 1
humanYears are whole numbers only
Cat Years
15 cat years for first year
+9 cat years for second year
+4 cat years for each year after that
Dog Years
15 dog years for first year
+9 dog years for second year
+5 dog years for each year after that
References

http://www.catster.com/cats-101/calculate-cat-age-in-cat-years
http://www.slate.com/articles/news_and_politics/explainer/2009/05/a_dogs_life.html

 */
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


