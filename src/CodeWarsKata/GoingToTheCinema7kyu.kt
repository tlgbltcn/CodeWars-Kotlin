package CodeWarsKata

fun main(args: Array<String>) {

    print(movie(100, 10, 0.95))
}

fun movie(card:Int, ticket:Int, perc:Double):Int {

    var mCard = card.toDouble()
    var mTicket = 0
    var count = 0
    var mPerc = 1.0
    var multiplyArray: ArrayList<Double> = arrayListOf(1.0)

    while (mTicket <= mCard){
        count++
        mTicket += ticket * 1
        mPerc *= perc
        multiplyArray.add(mPerc)
        mCard += (ticket * perc) * multiplyArray[count-1]
        mCard.toInt()
    }

    return count
}


/*********************** Best Practice *************************/

fun movie_(card: Int, ticket: Int, percent: Double): Int {
    tailrec fun iter(i: Int, pb: Double, sa: Int, sb: Double): Int =
            if (Math.ceil(sb) < sa) i
            else iter(i + 1, pb * percent, sa + ticket, sb + pb)
    return iter(0, ticket * percent, 0, card.toDouble())
}
