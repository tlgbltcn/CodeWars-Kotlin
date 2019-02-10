package CodeWarsKata

import util.IteratorSample

/**
 * Given an integer, take the (mean) average of each pair of consecutive digits. Repeat this process until you have a single integer, then return that integer. e.g.

digitsAverage(246)
average of 2 and 4 is 3, average of 4 and 6 is 5
so after first iteration 246 => 35
average of 3 and 5 is 4

so digitsAverage(246) returns 4

If the average of two digits is not an integer, round the result up. e.g.

digitsAverage(89)
average of 8 and 9 is 8.5 ==> return 9

p.s. for a bigger challenge, check out the one line version of this kata by myjinxin2015!

 */


fun main(args: Array<String>) {

    println(digitsAverage(3579))




    //println(m.filter { it%2 ==1})
}

fun digitsAverage(input: Int) : Int {
    var numbers = input
    var list : MutableList<Int> = mutableListOf()
    var list2 : MutableList<Int> = mutableListOf()
    while(numbers != 0 ){
        list.add(numbers%10)
        numbers /= 10
    }
    list.reversed()

    var sample = IteratorSample(list.reversed() as MutableList<Any>)

    var mList = list.reversed().iterator()

    while (sample.hasNext()){

        print(sample.next())

    }

    return 0
}

