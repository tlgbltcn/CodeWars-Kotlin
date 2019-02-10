package CodeWarsKata

fun main(args: Array<String>) {

    print(seven(477557101))
}

fun seven(n:Long): LongArray {

    var n = n
    var count = 0

    while(n.toString().length > 2){
        count++
        var t = Math.abs(n%10)
        n /= 10
        n -= t*2
    }

    return longArrayOf(n,count.toLong())

}


//m = 477557101->47755708->4775554->477547->47740->4774->469->28