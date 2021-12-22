package katas.`7kyu`

/**
 * There is enough money available on ATM in nominal value 10, 20, 50, 100, 200 and 500 dollars.

You are given money in nominal value of n with 1<=n<=1500.

Try to find minimal number of notes that must be used to repay in dollars, or output -1 if it is impossible.

Good Luck!!!
 */

fun main() {
    println(count(770))
    println(__count(770))
}

val availableCaches = listOf(500, 200, 100, 50, 20, 10)

fun count(number: Int): Int {
    val iterator = availableCaches.listIterator()
    if ((number.rem(10) != 0) or (number < 1) or (number > 1500)) return -1
    var index = 0
    var quotient = 0
    var n = number
    if (iterator.hasNext()) iterator.next()
    do {
        if (n / availableCaches[index] > 0 && n > 0) {
            quotient += n / availableCaches[index]
            n %= availableCaches[index]
        } else {
            if (iterator.hasNext()) {
                iterator.next()
                index++
            } else break
        }
    } while (true)

    return quotient
}

fun _count(amount: Int): Int {
    val (a, k) = availableCaches.fold(Pair(amount, 0)){ (a, k), v -> Pair(a % v, k + a / v) }
    return if (a == 0) k else -1
}

fun __count(number: Int): Int {
    var remaining = number
    val notes = listOf(500, 200, 100, 50, 20, 10)
    var max = 0
    for (x in notes){
        val temp = remaining/x
        if (temp > 0){
            remaining -= temp*x
            max += temp
        }
    }
    if (remaining > 0) return -1 else return max
}