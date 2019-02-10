package CodeWarsKata

fun main(args: Array<String>) {

    print(countRedBeads(3))
}

fun countRedBeads(nBlue: Int): Int =  if(nBlue < 2) 0 else (nBlue-1)*2
