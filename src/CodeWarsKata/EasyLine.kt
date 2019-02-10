package CodeWarsKata

import java.math.BigInteger

fun main(args: Array<String>) {

    print(easyLine(4))

}


fun easyLine(n:Int): BigInteger {
    var temp : BigInteger = BigInteger.valueOf(1)
    var list : ArrayList<BigInteger> = arrayListOf()
    for (i in 0..n){
        temp += calc(n)/((calc(n))*(calc(n-i)))
        list.add(temp)
    }


    return list.map { it }.sumBy { it.toInt()}.toBigInteger()

}


fun calc(n : Int): BigInteger {
    var result : BigInteger = BigInteger.valueOf(1)

    for (i in 2..n){
        result *= i.toBigInteger()
    }

    return result
}
