package katas.`6kyu`

import java.util.regex.Matcher
import java.util.regex.Pattern

/**
 * A traveling salesman has to visit clients. He got each client's address e.g. "432 Main Long Road St. Louisville OH 43071" as a list.

The basic zipcode format usually consists of two capital letters followed by a white space and five digits.
The list of clients to visit was given as a string of all addresses, each separated from the others by a comma, e.g. :

"123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432".

To ease his travel he wants to group the list by zipcode.

Task
The function travel will take two parameters r (addresses' list of all clients' as a string) and zipcode and
returns a string in the following format:

zipcode:street and town,street and town,.../house number,house number,...

The street numbers must be in the same order as the streets where they belong.

If a given zipcode doesn't exist in the list of clients' addresses return "zipcode:/"


 */

internal var ad =
    ("123 Main Street St. Louisville OH 43071,432 Main Long Road St. Louisville OH 43071,786 High Street Pollocksville NY 56432,"
            + "54 Holy Grail Street Niagara Town ZP 32908,3200 Main Rd. Bern AE 56210,1 Gordon St. Atlanta RE 13000,"
            + "10 Pussy Cat Rd. Chicago EX 34342,10 Gordon St. Atlanta RE 13000,58 Gordon Road Atlanta RE 13000,"
            + "22 Tokyo Av. Tedmondville SW 43098,674 Paris bd. Abbeville AA 45521,10 Surta Alley Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32908,320 Main Al. Bern AE 56210,14 Gordon Park Atlanta RE 13000,"
            + "100 Pussy Cat Rd. Chicago EX 34342,2 Gordon St. Atlanta RE 13000,5 Gordon Road Atlanta RE 13000,"
            + "2200 Tokyo Av. Tedmondville SW 43098,67 Paris St. Abbeville AA 45521,11 Surta Avenue Goodtown GG 30654,"
            + "45 Holy Grail Al. Niagara Town ZP 32918,320 Main Al. Bern AE 56215,14 Gordon Park Atlanta RE 13200,"
            + "100 Pussy Cat Rd. Chicago EX 34345,2 Gordon St. Atlanta RE 13222,5 Gordon Road Atlanta RE 13001,"
            + "2200 Tokyo Av. Tedmondville SW 43198,67 Paris St. Abbeville AA 45522,11 Surta Avenue Goodville GG 30655,"
            + "2222 Tokyo Av. Tedmondville SW 43198,670 Paris St. Abbeville AA 45522,114 Surta Avenue Goodville GG 30655,"
            + "2 Holy Grail Street Niagara Town ZP 32908,3 Main Rd. Bern AE 56210,77 Gordon St. Atlanta RE 13000")


fun main(args: Array<String>) {

    print(travel(ad, "NY 5643"))
    print(travell(ad, "NY 5643"))
    print(travelll(ad, "NY 5643"))
    print(travellll(ad, "NY 5643"))
    print(travellllll(ad, "NY 5643"))
}

fun travel(r: String, zipcode: String): String {
    var isZipCode = false
    val addressList = arrayListOf<Pair<String, String>>()
    val listAddress = r.split(",")
    var streetName = arrayListOf<String>()
    var houseNumber = arrayListOf<String>()
    listAddress.forEach {
        addressList.add(Pair(it.takeLast(8), it.dropLast(9)))
    }
    addressList.forEach { pair ->
        pair.takeIf { it.first == zipcode }
            ?.run {
                houseNumber.add(pair.second.split(" ")[0])
                streetName.add(pair.second.substringAfter(" "))
                isZipCode = true
            }
    }

    return if (!isZipCode) "$zipcode:/" else "$zipcode:${streetName.joinToString(",")}/${houseNumber.joinToString(",")}"
}

/*********************** Best Practice *************************/

val address = Pattern.compile("(?<number>\\d+) (?<street>.+) (?<zip>[A-Z]{2} \\d{5})")

fun travell(r:String, zipcode:String):String {
    val index = HashMap<String,MutableList<Address>>()

    val addresses = r.split(',').map {
        val matcher = address.matcher(it)
        if (matcher.matches()) Address(matcher) else null
    }.filterNotNull()

    addresses.forEach { index.append(it.zip, it) }

    return "$zipcode:" +
            "${index[zipcode]?.joinToString(",", transform = Address::street) ?: ""}/" +
            "${index[zipcode]?.joinToString(",", transform = Address::number) ?: ""}"
}

fun <K,V> HashMap<K,MutableList<V>>.append(key: K, value: V) {
    putIfAbsent(key, ArrayList())
    get(key)?.add(value)
}

data class Address(val zip: String, val street: String, val number: String) {
    constructor(matcher: Matcher) : this(
        matcher.group("zip"),
        matcher.group("street"),
        matcher.group("number"))
}

/*********************** Best Practice *************************/

val DIVIDER = " "

data class Addresss(
    val postcode: String,
    val street: String,
    val number: String
)

fun travelll(r:String, zipcode:String):String {
    val sb = StringBuilder()
    sb.append("$zipcode:")

    val matchingAddresses = r.split(',')
        .map(String::toAddress).filter { it.postcode == zipcode }

    matchingAddresses.forEach { sb.append("${it.street},") }
    sb.replaceLast(",", "")

    sb.append("/")
    matchingAddresses.forEach { sb.append("${it.number},") }
    sb.replaceLast(",", "")

    return sb.toString()
}

fun String.getStringBetweenOccurenceOf(divider: String, start: Int, end: Int): String {
    val splitted = this.split(divider)
    val sb = StringBuilder()
    val max = iff(end <= splitted.size && end > 0, end, splitted.size)

    for (i in start until max){
        sb.append(splitted[i])
        if(i < max - 1)
            sb.append(divider)
    }
    return sb.toString()
}

fun<T> iff(condition: Boolean, result1: T, result2: T) = if (condition) result1 else result2


fun StringBuilder.replaceLast(search: String, replacement: String){
    val index = this.lastIndexOf(search)
    if(index > 0)
        this.replace(index, index + 1, replacement)
}

fun String.toAddress(): Addresss =
    Addresss(
        getPostCode(this, DIVIDER),
        getStreet(this, DIVIDER),
        getHouseNo(this, DIVIDER)
    )

fun getPostCode(address: String, divider: String): String {
    val blanks = address.count { divider.contains(it) }
    return address.getStringBetweenOccurenceOf(divider, blanks - 1, 0)
}

fun getStreet(address: String, divider: String): String {
    val blanks = address.count { divider.contains(it) }
    return address.getStringBetweenOccurenceOf(divider, 1, blanks - 1)
}

fun getHouseNo(address: String, divider: String) =
    address.getStringBetweenOccurenceOf(divider, 0, 1)


/*********************** Best Practice *************************/


fun travellll(r: String, zipcode: String): String {
    val addresses = r.split(",")
    val addressesObj = addresses.map { address ->

        val split = address.split(" ").toMutableList()
        val zipCode = "${split[split.size - 2]} ${split[split.size - 1]}"
        val houseNumber = split[0]
        split.removeAt(split.size - 2)
        split.removeAt(split.size - 1)
        split.removeAt(0)
        val streetAndTown = split.joinToString(separator = " ")
        Addres(zipCode = zipCode, houseNumber = houseNumber, streetAndTown = streetAndTown)

    }.toList()

    val filteredList = addressesObj.filter { address -> address.zipCode == zipcode }.toList()
    if (filteredList.isEmpty()) return "$zipcode:/"
    val streets = filteredList.map { it.streetAndTown }.toList()
    val houseNumbers = filteredList.map { it.houseNumber }.toList()

    return "$zipcode:${streets.joinToString(",")}/${houseNumbers.joinToString(",")}"
}

data class Addres(val zipCode: String, val streetAndTown: String, val houseNumber: String)

/*********************** Best Practice *************************/


data class StreetAddress(val houseNumber: Int, val street: String, val zipCode: String)

fun travellllll(r: String, zipcode: String): String {
    val matches = """(\d+) (.*?) ([A-Z]{2,} \d+),?""".toRegex().findAll(r)

    val streetAddressList = matches.map {
        with(it.destructured) {
            StreetAddress(this.component1().toInt(), this.component2(), this.component3())
        }
    }.filter { it.zipCode == zipcode }.toList()
    val streets = streetAddressList.joinToString(",") { it.street }
    val houseNumbers = streetAddressList.joinToString(",") { it.houseNumber.toString() }
    return "$zipcode:$streets/$houseNumbers"
}