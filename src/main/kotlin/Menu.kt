import java.util.Scanner

class Menu(
    val items: List<String>,
    val onCreate: () -> Unit,
    val onOpen: (Int) -> Unit,
) {

    fun run() {
        while (true) {
            val number = inputNumber()

            when (number) {
                0 -> {
                    onCreate()
                }

                items.size - 1 -> {
                    return
                }

                else -> {
                    onOpen(number - 1)
                }
            }
        }
    }

    fun show() {
        items.forEachIndexed { index, element -> println("$index. $element") }
    }

    private fun inputNumber(): Int {
        val scanner = Scanner(System.`in`)

        while (true) {
            println("Введите номер пункта меню")
            val number = scanner.nextLine().toIntOrNull()

            if (number == null) {
                println("Cледует вводить цифру")
                show()
            } else if ((number < 0) or (number > items.size - 1)) {
                println("Tакой цифры нет")
                show()
            } else {
                return number
            }
        }
    }
}