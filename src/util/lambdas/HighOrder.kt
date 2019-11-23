package util.lambdas


fun main() {

    insertBlockToFunction("Hiiii EveryBody") { nameSpace ->
        println(nameSpace)

    }

    val x = returnInlineFunction(10) {
        println(it)
        return@returnInlineFunction
    }

    println(" ---- $x")
}


inline fun insertBlockToFunction(str: String ,block: (nameSpace: String) -> Unit) {
    // before block doSomething()
    block(str)
    // after block doSomething()
    println("I will be executed when you call insertBlockToFunction()")
}

inline fun crossInlineFunction(crossinline block:() -> Unit) {

    noInlineLambdaFunction("dsdsd") {
        block()
    }
}

inline fun returnInlineFunction(number: Int,crossinline block: (square: Int) -> Unit) : Int {
    val result = number * number
    block(result)
    return result
}

fun noInlineLambdaFunction(str: String, block: (nameSpace: String) -> Unit): String{

    block(str+str)

    return str.length.toString()
}

fun normalFunction() {

    crossInlineFunction {
        return@crossInlineFunction
    }
}
