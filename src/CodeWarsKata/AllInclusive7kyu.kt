package CodeWarsKata


fun main(args: Array<String>) {

    var arr : ArrayList<String> = arrayListOf("tdkfd","tolg","fdfwf","efefef", "fefefefesxw")
    var arr1 : ArrayList<String> = arrayListOf("tdkfd","fdfwf","efefef", "fefefefesxw","tolga","fslfkmwlfkqwlsf", "eofeo")
    var a = arrayListOf("bsjq", "qbsj", "sjqb", "twZNsslC", "jqbs")
 //   var b = arrayListOf("TzYxlgfnhf", "yq VAutLjMLyo", "BhRXjYA", "YABhRXj", "hRXjYAB", "jYABhRX", "XjYABhR", "ABhRXjY", "")
    var b= arrayListOf("134","542","3453","42344","533334","63435","73454656")

    print(containsAllRots("443421",b))

}

fun containsAllRots(strng: String, arr : ArrayList<String>) : Boolean {
    val partOne : String
    val partTwo : String
    var isContains = false
    val inclusiveString : String
    var isEvenNumber = false
    val size = strng.length
    if(size % 2 == 0) isEvenNumber = true

    when (strng) {
        "" -> isContains = false
        else -> {
            if (isEvenNumber){
                partOne = strng.slice(0 until size/2)
                partTwo = strng.slice(size/2 until size)
                inclusiveString = partTwo + partOne
            }else {
                partOne = strng.slice(0 until (size/2))
                partTwo = strng.slice((size/2)+1 until size)
                inclusiveString = partTwo + strng[(size/2)] + partOne
            }


            arr.forEach{
                if (it.contains(inclusiveString)) isContains = true
            }
        }
    }


    return isContains
}