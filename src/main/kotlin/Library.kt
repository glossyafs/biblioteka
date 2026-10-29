class Library {
    val books = mutableListOf<Book>()

    // Каталог
    fun printCatalog() {
        println("№   Название                          Автор          Год    Жанр         Статус")
        for ((index, book) in books.withIndex()) {
            val num = (index + 1).toString().padEnd(4)
            val title = book.title.padEnd(35)
            val author = book.author.padEnd(14)
            val year = book.year.toString().padEnd(6)
            val genre = book.genre.name.padEnd(12)
            val status = book.status.name
            println("$num$title $author $year $genre $status")
        }
    }

    // Статистика
    fun printStatusStats() {
        var available = 0
        var borrowed = 0
        var lost = 0
        var reserved = 0
        var archived = 0

        for (book in books) {
            when (book.status) {
                BookStatus.AVAILABLE -> available++
                BookStatus.BORROWED -> borrowed++
                BookStatus.LOST -> lost++
                BookStatus.RESERVED -> reserved++
                BookStatus.ARCHIVED -> archived++
            }
        }
        println("Доступно: $available")
        println("Выдано: $borrowed")
        println("Потеряно: $lost")
        println("Зарезервировано: $reserved")
        println("В архиве: $archived")
    }

    // Жанры
    fun printGenreStats() {
        val counts = mutableMapOf<Genre, Int>()
        for (g in Genre.values()) counts[g] = 0
        for (book in books) {
            counts[book.genre] = counts[book.genre]!! + 1
        }
        for ((genre, count) in counts) {
            if (count > 0) println("${genre.name}: $count")
        }
    }

    // Действия
    fun findAvailable(): List<Book> = books.filter { it.status == BookStatus.AVAILABLE }
    fun findByGenre(genreName: String): List<Book> {
        val genre = Genre.values().find { it.name.equals(genreName, ignoreCase = true) }
        return if (genre != null) books.filter { it.genre == genre } else emptyList()
    }

    fun findByYear(afterYear: Int): List<Book> = books.filter { it.year > afterYear }

    fun borrowBook(index: Int) {
        if (index in 1..books.size) {
            val book = books[index - 1]
            if (book.status == BookStatus.AVAILABLE) {
                book.status = BookStatus.BORROWED
                println("Книга '${book.title}' выдана.")
            } else {
                println("Ошибка: книга '${book.title}' недоступна (статус: ${book.status.displayName}).")
            }
        } else println("Ошибка: неверный номер книги.")
    }

    fun returnBook(index: Int) {
        if (index in 1..books.size) {
            val book = books[index - 1]
            if (book.status == BookStatus.BORROWED) {
                book.status = BookStatus.AVAILABLE
                println("Книга '${book.title}' возвращена.")
            } else println("Ошибка: книгу '${book.title}' не выдавали.")
        }
    }

    fun loseBook(index: Int) {
        if (index in 1..books.size) {
            books[index - 1].status = BookStatus.LOST
            println("Книга '${books[index - 1].title}' отмечена как потерянная.")
        }
    }

    fun reserveBook(index: Int) {
        if (index in 1..books.size) {
            books[index - 1].status = BookStatus.RESERVED
            println("Книга '${books[index - 1].title}' зарезервирована.")
        }
    }

    // Отчет
    fun printReport() {
        println("\n=== ОТЧЁТ ПО КАТАЛОГУ ===")
        println("Всего книг: ${books.size}")

        val oldest = books.minByOrNull { it.year }
        val newest = books.maxByOrNull { it.year }
        val avgYear = books.map { it.year }.average().toInt()

        println("\nСамая старая книга: ${oldest?.title} (${oldest?.year})")
        println("Самая новая книга: ${newest?.title} (${newest?.year})")
        println("Средний год: $avgYear")
    }
}