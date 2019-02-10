package CodeWarsKata

fun main(args: Array<String>) {

}

fun quadratic(a:Double, b:Double, c:Double):Double {

    var x1 : Double
    var x2 : Double


    val determinant = (b*b) - (4 * a *c)

    when {
        determinant > 0 -> {
            x1 = (-b + Math.sqrt(determinant) / (2*a))
            x2 = (-b - Math.sqrt(determinant) / (2*a))

            return if (x1>x2) x2 else x1
        }
        determinant == 0.0 -> {
            x1  = -b / (2*a)
            x2  = -b / (2*a)
            return x1
        }
        else -> {
            var unReal = -b / (2*a)
            var x = Math.sqrt(-determinant) / (2*a)
            return x
        }
    }

}