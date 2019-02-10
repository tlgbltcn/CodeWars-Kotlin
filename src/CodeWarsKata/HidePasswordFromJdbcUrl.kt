package CodeWarsKata

object HidePasswordFromJdbcUrl {

    fun hidePasswordFromConnection(urlString: String): String {


        return "hello world!"


    }

    fun main(args: Array<String>) {
        val hidePasswordFromJdbculr = HidePasswordFromJdbcUrl
        val url = "jdbc:mysql://sdasdasdasd:szdasdasd:dfsdfsdfsdf/sdfsdfsdf?user=root&password=12345"
        print(hidePasswordFromJdbculr.hidePasswordFromConnection("url"))
    }

}