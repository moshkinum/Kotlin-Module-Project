class ArchiveScreen() {

    private val archives: MutableList<Archive> = mutableListOf()
    private val pointsMenu: MutableList<String> =
        mutableListOf(MENU_CREATE, MENU_EXIT)
    private val menu = Menu(
        pointsMenu,
        { onCreate() },
        { index -> onOpen(index) },
    )

    fun start(isRun: Boolean = true) {
        println("------------------------------")
        println("Список архивов")
        println("------------------------------")

        menu.show()

        if (isRun) {
            menu.run()
            println("Выход из программы")
        }
    }

    private fun onCreate() {
        println("------------------------------")
        println("Создание архива")
        println("------------------------------")

        val name = readNonEmptyString(
            "Введите наименование архива:",
            "Наименование архива не должно быть пустым:",
        )
        val notes: MutableList<Note> = mutableListOf()

        archives.add(Archive(name, notes))
        pointsMenu.add(pointsMenu.size - 1, name)

        start(false)
    }

    private fun onOpen(index: Int) {
        val noteScreen = NoteScreen(archives[index])
        noteScreen.start()

        start(false)
    }

    private companion object {
        private const val MENU_CREATE = "Создать архив"
        private const val MENU_EXIT = "Выход"
    }
}
