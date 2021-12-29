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
        return result.distinctBy { it.title }
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