import java.util.Scanner

object Helper {
    fun inputText(title: String, error: String): String {
        val scanner = Scanner(System.`in`)

        while (true) {
            println(title)
            val text = scanner.nextLine().trim()

            if (text.length == 0) {
                println(error)
            } else {
                return text
            }
        }
    }
}