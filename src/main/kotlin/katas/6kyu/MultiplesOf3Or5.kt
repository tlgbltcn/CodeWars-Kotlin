package katas.`6kyu`

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

Note: If the number is a multiple of both 3 and 5, only count it once.
 */
fun main(args: Array<String>) {

    print(solution(20))
}

fun solution(number: Int) : Int{

    var total = 0
    for (i in number-1 downTo  1){
        if (i%15 == 0){
            total += i
        }else{
            if (i%3 == 0) total += i
            if (i%5 == 0) total += i
        }
    }
    return total
}


/*********************** Best Practice *************************/

fun solution_(number: Int): Int =
        (3 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()

/*********************** Best Practice *************************/


fun solution___(number: Int): Int {
    return IntRange(1, number - 1).filter { x -> x % 3 == 0 || x % 5 == 0 }.sum()
}

/*********************** Best Practice *************************/

fun solution__(number: Int): Int {
    var res=0
    (0 until number).forEach{
        if(it % 3==0 || it % 5==0)
            res+=it
    }
    return res
}