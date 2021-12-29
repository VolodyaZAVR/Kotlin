package library

class Library : LibraryService {
    private val users: MutableList<User> = mutableListOf()
    private val bookList: MutableMap<Book, Status> = mutableMapOf()

    override fun findBooks(title: String?, author: Author?, year: Year?, genre: Genre?): List<Book> {
        var result: List<Book> = listOf()
        for (key in bookList.keys) {
            if (title != null)
                result = findBooks(title, result)
            if (author != null)
                result = findBooks(author, result)
            if (year != null)
                result = findBooks(year, result)
            if (genre != null)
                result = findBooks(genre, result)
        }
        return result.distinct()
    }

    override fun findBooks(title: String, currBookList: List<Book>?): List<Book> {
        val tempBookList: List<Book> = currBookList ?: bookList.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (item in tempBookList)
            if (item.title == title)
                result.add(item)
        return result
    }

    override fun findBooks(author: Author, currBookList: List<Book>?): List<Book> {
        val tempBookList: List<Book> = currBookList ?: bookList.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (item in tempBookList)
            if (item.author == author)
                result.add(item)
        return result
    }

    override fun findBooks(year: Year, currBookList: List<Book>?): List<Book> {
        val tempBookList: List<Book> = currBookList ?: bookList.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (item in tempBookList)
            if (item.year == year)
                result.add(item)
        return result
    }

    override fun findBooks(genre: Genre, currBookList: List<Book>?): List<Book> {
        val tempBookList: List<Book> = currBookList ?: bookList.keys.toList()
        val result: MutableList<Book> = mutableListOf()
        for (item in tempBookList)
            if (item.genre == genre)
                result.add(item)
        return result
    }

    override fun getAllBooks(): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for (item in bookList.keys) {
            result.add(item)
        }
        return result
    }

    override fun getAllAvailableBooks(): List<Book> {
        val result: MutableList<Book> = mutableListOf()
        for ((key, value) in bookList) {
            if (value == Status.Available)
                result.add(key)
        }
        return result
    }

    override fun getBookStatus(book: Book): Status? {
        return if (bookList[book] == null)
            null
        else
            bookList[book]
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return bookList.toMap()
    }

    override fun setBookStatus(book: Book, status: Status) {
        if (bookList[book] == status)
            throw IllegalArgumentException("You can't set status that book already have!")
        bookList[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        if (bookList.keys.contains(book))
            throw IllegalArgumentException("You can't add book that is already in library!")
        bookList[book] = status
    }

    override fun registerUser(user: User) {
        if (users.contains(user))
            throw IllegalArgumentException("You can't registered an registered user!")
        users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (!users.contains(user))
            throw IllegalArgumentException("You can't unregistered an unregistered user!")
        users.remove(user)
    }

    override fun takeBook(user: User, book: Book) {
        if (!users.contains(user))
            throw IllegalArgumentException("You can't give books to unregistered users!")
        if (!bookList.keys.contains(book))
            throw IllegalArgumentException("You can't give out a book that doesn't exist")
        if (bookList[book] != Status.Available)
            throw IllegalArgumentException("You can't give out books that are not available")
        if (userUsedBooksCount(user) >= 3)
            throw IllegalArgumentException("User can't have more than three books")
        setBookStatus(book, Status.UsedBy(user))
    }

    private fun userUsedBooksCount(user: User): Int {
        var booksCount = 0
        for (item in bookList.values)
            if (item == Status.UsedBy(user))
                booksCount++
        return booksCount
    }

    override fun returnBook(book: Book) {
        if (getBookStatus(book) == Status.Available)
            throw IllegalArgumentException("You can't return a book that is already in the library")
        setBookStatus(book, Status.Available)
    }
}