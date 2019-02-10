package CodeWarsKata

fun main(args: Array<String>) {
    var s1 = arrayOf<String>("hoqqqqqqqqqqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz")
    var s2 = arrayOf<String>("cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww")
    print(mxdiflg(s1,s2))
}

fun mxdiflg(a1: Array<String>, a2: Array<String>): Int = if (a1.isEmpty() || a2.isEmpty()) { -1
    }else{
        var xMax = a1.reduce { maxLenght, element -> if (element.length > maxLenght.length) element else maxLenght }.length
        var xMin = a1.reduce { minLenght, element -> if (element.length < minLenght.length) element else minLenght }.length
        var yMax = a2.reduce { maxLenght, element -> if (element.length > maxLenght.length) element else maxLenght}.length
        var yMin = a2.reduce { minLenght, element -> if (element.length < minLenght.length) element else minLenght}.length
        if(Math.abs(xMax - yMin) > Math.abs(yMax - xMin)) Math.abs(xMax - yMin) else Math.abs(yMax - xMin)
    }

