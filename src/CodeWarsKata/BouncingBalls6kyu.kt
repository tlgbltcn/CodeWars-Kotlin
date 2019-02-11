package CodeWarsKata

import java.lang.Math.ceil
import kotlin.math.ln

/**
 * A child is playing with a ball on the nth floor of a tall building. The height of this floor, h, is known.

He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).

His mother looks out of a window 1.5 meters from the ground.

How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing?

Three conditions must be met for a valid experiment:
Float parameter "h" in meters must be greater than 0
Float parameter "bounce" must be greater than 0 and less than 1
Float parameter "window" must be less than h.
If all three conditions above are fulfilled, return a positive integer, otherwise return -1.

Note: The ball can only be seen if the height of the rebounding ball is stricty greater than the window parameter.

Example:

h = 3, bounce = 0.66, window = 1.5, result is 3

h = 3, bounce = 1, window = 1.5, result is -1 (Condition 2) not fulfilled).
 */

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

/*********************** Best Practice *************************/


fun bouncingBall(h:Double, bounce:Double, window:Double):Int {
    if(h <= 0.0  || bounce <= 0.0 || bounce >= 1.0 || window >= h || window <= 0.0 )
        return -1

    val sequenceOfJumps = generateSequence(h){ it *bounce}

    val numberOfJumps = generateSequence(h){ it * bounce}
            .takeWhile{it > window}
            .count()

    return (numberOfJumps * 2) - 1
}

fun bouncingBallll(h:Double, b:Double, w:Double):Int = if(h>0 && b>0 && b<1 && w<h) 1+2*(ceil(ln(w/h)/ln(b)).toInt()-1) else -1

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