@file:Suppress("UNREACHABLE_CODE")

package CodeWarsKata

fun main(args: Array<String>) {

    //print(isPrime(24).toString())

    println(gap(4, 100, 110)[0])
    println(gap(4, 100, 110)[1])


}

/**
 * @param g is (integer >= 2) which indicates the gap we are looking for
 * @param m is (integer > 2) which gives the start of the search (m inclusive)
 * @param n is (integer >= m) which gives the end of the search (n inclusive)
 */


fun gap(g: Int, m: Long, n: Long): LongArray {
    var isFirstNotPrime = false
    var isSecondNotPrime = false

    loopFirst@ (m..n).forEach { i ->
        for (t in i / 2 downTo 2) {

            isFirstNotPrime = (i % t == 0.toLong())
            if (isFirstNotPrime) break


        }

        if (!isFirstNotPrime) {
            val asd = i + 1
            loop@ for (z in asd..n) {
                for (s in z / 2 downTo 2) {

                    if (z%s == 0.toLong()) break

                }
                if (!isSecondNotPrime) {
                    if (z - i > g.toLong()) {
                        break@loop
                    } else {
                        if (z - i == g.toLong()) {
                            return longArrayOf(i, z)
                        } else {
                            break@loop
                        }

                    }


                }

            }


        }
    }


    return longArrayOf(0L, 0L)

}



fun isPrime(i: Long) : Long{
    var isPrime = false
        for (t in i/2 downTo 2){

            isPrime = (i%t == 0.toLong())
            if (isPrime) {
                return break
            }
        }

        return if (!isPrime) i else -1

    }

