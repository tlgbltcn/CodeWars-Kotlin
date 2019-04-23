package util

inline fun f(crossinline body: () -> Unit) {
    val f = object : Runnable {
        override fun run() {

        }

    }
}