package katas.`5kyu`

/**
 * xTake the following IPv4 address: 128.32.10.1

This address has 4 octets where each octet is a single byte (or 8 bits).

1st octet 128 has the binary representation: 10000000
2nd octet 32 has the binary representation: 00100000
3rd octet 10 has the binary representation: 00001010
4th octet 1 has the binary representation: 00000001
So 128.32.10.1 == 10000000.00100000.00001010.00000001

Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361

Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.

Examples
2149583361 ==> "128.32.10.1"
32         ==> "0.0.0.32"
0          ==> "0.0.0.0"

10000000001000000000101000000001
10000000001000000000101000000001
10000000001000000000101000000001

01100110010010001100100110110100
1100110010010001100100110110100

00101110000001011111000110001110  772141454
00101110000001011111000110001110

 */

val numb = "00101110000001011111000110001110"
fun main() {
    println(longToIP(772141454.toUInt()))
    println(_longToIP(772141454.toUInt()))
}

fun longToIP(ip: UInt) =
    ip.toString(radix = 2).padStart(32, '0')
        .windowed(step = 8, size = 8)
        .map { it.toInt(radix = 2) }
        .joinToString(".")


fun _longToIP(x: UInt) = (0..24 step 8).map {
    x shr it and 255u
}.reversed().joinToString(".")

fun __longToIP(ip: UInt): String =
    ip.toString(2)
        .padStart(32,'0')
        .chunked(8)
        .map { it.toInt(2) }
        .joinToString(separator = ".")


fun providingData() {
    var sum: Long = 0L
    numb.reversed().foldIndexed(1) { index, acc, c ->
        if (c == '1') {
            sum += acc
        }
        acc + acc
    }
    sum.toUInt()
}