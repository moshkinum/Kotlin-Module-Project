import java.util.Scanner

class NoteScreen(val archive: Archive) {

    private val pointsMenu: MutableList<String> = getPointsMenu()
    private val menu = Menu(
        pointsMenu,
        { onCreate() },
        { index -> onOpen(index) },
    )

    fun start(isRun: Boolean = true) {
        println("------------------------------")
        println("Заметки архива '${archive.name}'")
        println("------------------------------")

        menu.show()

        if (isRun) {
            menu.run()
        }
    }

    private fun getPointsMenu(): MutableList<String> {
        val points = mutableListOf(MENU_CREATE, MENU_EXIT)

        for (note in archive.notes) {
            points.add(points.size - 1, note.title)
        }

        return points
    }

    private fun onCreate() {
        println("------------------------------")
        println("Создание заметки")
        println("------------------------------")

        val title = Helper.inputText(
            "Введите заголовок заметки:",
            "Заголовок заметки не должен быть пустым:",
        )
        val text = Helper.inputText(
            "Введите текст заметки:",
            "Текст заметки не должен быть пустым:",
        )

        archive.notes.add(Note(title, text))
        pointsMenu.add(pointsMenu.size - 1, title)

        start(false)
    }

    private fun onOpen(index: Int) {
        println("------------------------------")
        println("Заметка '${archive.notes[index].title}'")
        println("------------------------------")
        println("Текст заметки: '${archive.notes[index].text}'")
        println("Введите любой символ для выхода:")
        val scanner = Scanner(System.`in`)

        scanner.nextLine().trim()
        start(false)
    }

    private companion object {
        private const val MENU_CREATE = "Создать заметку"
        private const val MENU_EXIT = "Выход"
    }
}
