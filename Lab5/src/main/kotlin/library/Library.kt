package library

class Library : LibraryService {
    private val users: MutableList<User> = mutableListOf()
    private val bookList: MutableMap<Book, Status> = mutableMapOf()

    override fun findBooks(substring: String): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(author: Author): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(year: Year): List<Book> {
        TODO("Not yet implemented")
    }

    override fun findBooks(genre: Genre) {
        TODO("Not yet implemented")
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
        return bookList[book]
    }

    override fun getAllBookStatuses(): Map<Book, Status> {
        return bookList.toMap()
    }

    override fun setBookStatus(book: Book, status: Status) {
        bookList[book] = status
    }

    override fun addBook(book: Book, status: Status) {
        bookList[book] = status
    }

    override fun registerUser(user: User) {
        if (!users.contains(user))
            users.add(user)
    }

    override fun unregisterUser(user: User) {
        if (users.contains(user))
            users.remove(user)
    }


    override fun takeBook(user: User, book: Book) {
        setBookStatus(book, Status.UsedBy(user))
        TODO("add a check on the number of books")
    }

    override fun returnBook(book: Book) {
        setBookStatus(book, Status.Available)
    }

}