package CodeWarsKata

import java.lang.Math.ceil
import kotlin.math.ln


/**
 *  Float parameter "h" in meters must be greater than 0
 *  Float parameter "bounce" must be greater than 0 and less than 1
 *  Float parameter "window" must be less than h.
 */

fun main(args: Array<String>) {

    println(bouncingBall(30.0, 0.66, 1.5))
    //println(bouncingBallll(30.0, 0.66, 1.5))


}


fun bouncingBalls(h: Double, bounce: Double, window: Double): Int {
    var mH: Double = h
    var see: Int = -1
    for (it in h.toInt() downTo 0) {

        if (bounce < 1.0 && bounce > 0.0 && h > window && h > 0) {
            see += 2
            mH = downBall(mH, bounce)
            println(mH.toString())
            if (window > mH) {
                return see
                (break)

            } else continue
        } else return -1
    }

    return -1
}


fun downBall(h: Double, bounce: Double): Double {

    val maxRise: Double = h * bounce

    return maxRise
}



/*
 Amazing solution
 */

fun bouncingBall(h:Double, bounce:Double, window:Double):Int {
    if(h <= 0.0  || bounce <= 0.0 || bounce >= 1.0 || window >= h || window <= 0.0 )
        return -1

    val sequenceOfJumps = generateSequence(h){ it *bounce}

    val numberOfJumps = generateSequence(h){ it * bounce}
            .takeWhile{it > window}
            .count()

    return (numberOfJumps * 2) - 1
}



/*
 Amazing solution
 */

fun bouncingBallll(h:Double, b:Double, w:Double):Int = if(h>0 && b>0 && b<1 && w<h) 1+2*(ceil(ln(w/h)/ln(b)).toInt()-1) else -1


/*
 Amazing solution
 */

fun bouncingBalll(h:Double, bounce:Double, window:Double):Int {
    if (h <= 0 || bounce <= 0.0 || bounce >= 1.0 || h <= window) {
        return -1
    }

    var observations = 1
    var currentHeight = h

    do {
        currentHeight = currentHeight * bounce
        observations += 2
    } while(currentHeight > window)


    return observations - 2
}