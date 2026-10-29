fun main() {
    System.setOut(java.io.PrintStream(System.out, true, "UTF-8"))

    val lib = Library()

    lib.books.add(Book("Мастер и Маргарита", "Булгаков", 1967, Genre.FICTION, BookStatus.AVAILABLE))
    lib.books.add(Book("Преступление и наказание", "Достоевский", 1866, Genre.FICTION, BookStatus.BORROWED))
    lib.books.add(Book("Краткая история времени", "Хокинг", 1988, Genre.SCIENTIFIC, BookStatus.AVAILABLE))
    lib.books.add(Book("Властелин колец", "Толкин", 1954, Genre.FANTASY, BookStatus.BORROWED))
    lib.books.add(Book("Убийство в Восточном экспрессе", "Кристи", 1934, Genre.DETECTIVE, BookStatus.LOST))
    lib.books.add(Book("Стив Джобс", "Айзексон", 2011, Genre.BIOGRAPHY, BookStatus.AVAILABLE))
    lib.books.add(Book("Гарри Поттер и философский камень", "Роулинг", 1997, Genre.FANTASY, BookStatus.AVAILABLE))
    lib.books.add(Book("Маленький принц", "Сент-Экзюпери", 1943, Genre.CHILDREN, BookStatus.RESERVED))
    lib.books.add(Book("Дюна", "Герберт", 1965, Genre.FANTASY, BookStatus.AVAILABLE))
    lib.books.add(Book("Космос", "Саган", 1980, Genre.SCIENTIFIC, BookStatus.ARCHIVED))
    lib.books.add(Book("Шерлок Холмс", "Дойл", 1892, Genre.DETECTIVE, BookStatus.AVAILABLE))
    lib.books.add(Book("Анна Каренина", "Толстой", 1877, Genre.FICTION, BookStatus.BORROWED))

    println("--- КАТАЛОГ ---")
    lib.printCatalog()

    println("\n--- СТАТИСТИКА ---")
    lib.printStatusStats()

    println("\n--- ЖАНРЫ ---")
    lib.printGenreStats()

    println("\n--- ДЕЙСТВИЯ ---")
    lib.borrowBook(1) // Выдаем доступную
    lib.borrowBook(2) // Пытаемся выдать уже выданную

    println("\n--- ОТЧЕТ ---")
    lib.printReport()
}