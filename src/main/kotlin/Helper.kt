import java.util.Scanner

val scanner = Scanner(System.`in`)

fun readNonEmptyString(title: String, error: String): String {
    while (true) {
        println(title)
        val text = scanner.nextLine().trim()

        if (text.isEmpty()) {
            println(error)
        } else {
            return text
        }
    }
}