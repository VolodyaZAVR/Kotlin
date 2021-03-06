package library

data class Book (val title: String, val author: Author, val genre: Genre, val year: Year)
data class Author (val name: String)
data class User (val name: String)
data class Year (val year: Int)

enum class Genre {
    CRIME,
    DETECTIVE,
    SCIENCE,
    DISTOPIA,
    CYBERPUNK,
    FANTASY,
    NOVEL
}

sealed class Status {
    object Available : Status()
    data class UsedBy(val user: User) : Status()
    object ComingSoon : Status()
    object Restoration : Status()
}

interface LibraryService {

    fun findBooks(title: String?, author: Author?, year: Year?, genre: Genre?): List<Book>
    fun findBooks(title: String, currBookList : List<Book>?): List<Book>
    fun findBooks(author: Author, currBookList : List<Book>?): List<Book>
    fun findBooks(year: Year, currBookList : List<Book>?): List<Book>
    fun findBooks(genre: Genre, currBookList : List<Book>?): List<Book>

    fun getAllBooks(): List<Book>
    fun getAllAvailableBooks(): List<Book>

    fun getBookStatus(book: Book): Status?
    fun getAllBookStatuses(): Map<Book, Status>

    fun setBookStatus(book: Book, status: Status)

    fun addBook(book: Book, status: Status = Status.Available)

    fun registerUser(user: User)
    fun unregisterUser(user: User)

    fun takeBook(user: User, book: Book)
    fun returnBook(book: Book)
}
