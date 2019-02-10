package CodeWarsKata

import java.util.*

fun main(args: Array<String>) {
    val i = System.currentTimeMillis()
    print(loop(Random(i),6))
}


 fun loop(random: Random, int: Int): Int {
     if (int <= 0) return random.nextInt()

     for (it in 1..int) {
         random.nextInt()
     }


 	return random.nextInt()
 }
//

// ***********************************************
// ******************* MENTION *******************
// Please remove the comment above to pass the test
// ******************* MENTION *******************
// ***********************************************

fun loopa(random: Random, int: Int): Int {
    if (int <= 0) return random.nextInt()
    else {
        random.nextInt()
        return loop(random, int - 1)
    }
}