package CodeWarsKata

fun main(args: Array<String>) {

    println(zap(4, 100, 110)[0])
    println(zap(4, 100, 110)[1])


}


fun zap(g: Int, m: Long, n: Long): LongArray {

    var isFirstNotPrime: Boolean
    var isSecondNotPrime: Boolean
    var isTrySecondPrime : Boolean
    var istryResulr : Boolean


    loopFirst@ (m..n).forEach { i ->

        isFirstNotPrime = isitPrime(i) == (-1).toLong()


        if (!isFirstNotPrime) {
            val asd = i + 1
            val trySecondPrime  = i + g

            loop@ for (z in asd..n) {

                isTrySecondPrime = isitPrime(trySecondPrime) == (-1).toLong()
                if (!isTrySecondPrime){

                    for (t in asd..trySecondPrime){
                        istryResulr =  isitPrime(t) == (-1).toLong()

                        if (!istryResulr){
                            return longArrayOf(i,t)
                        }

                    }

                }else {
                    isSecondNotPrime = isitPrime(z) == (-1).toLong()

                    if (!isSecondNotPrime) {
                        if (z - i > g.toLong()) {
                            break
                        } else {
                            if (z - i == g.toLong()) {
                                return longArrayOf(i, z)
                            } else {
                                break
                            }

                        }

                    }

                }


            }
            
        }
    }
    
    return longArrayOf()

}


fun isitPrime(i: Long) : Long{
    var isPrime = false
    for (t in i/2 downTo 2){

        isPrime = (i%t == 0.toLong())
        if (isPrime) {
            return break
        }
    }

    return if (!isPrime) i else -1

}
