import library.*
import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals


class UtilKtTest {
    @Test
    fun `checking the function setBookStatus`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        library.setBookStatus(book, Status.ComingSoon)
        assertEquals(Status.ComingSoon, library.getBookStatus(book))
    }

    @Test
    fun `checking the function find when books exist`() {
        val library = Library()
        library.addBook(Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021)), Status.Available)
        library.addBook(Book("Left You Dead", Author("Not Peter James"), Genre.CRIME, Year(2029)), Status.Available)
        val books = listOf(
            Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021)),
            Book("Left You Dead", Author("Not Peter James"), Genre.CRIME, Year(2029))
        )
        assertEquals(books, library.findBooks("Left You Dead", library.getAllBooks()))
    }

    @Test
    fun `checking the function find when books non-exist`() {
        val library = Library()
        val books = listOf<Book>()
        library.addBook(Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021)), Status.Available)
        library.addBook(Book("Left You Dead", Author("Not Peter James"), Genre.CRIME, Year(2029)), Status.Available)
        assertEquals(books, library.findBooks("Claire DeWitt and the City of the Dead", library.getAllBooks()))
    }

    @Test
    fun `checking the change in the status of the book after the function takeBook`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        val user = User("Ivan")
        library.registerUser(user)
        library.takeBook(user, book)
        assertEquals(Status.UsedBy(user), library.getBookStatus(book))
    }

    @Test
    fun `checking the change in the status of the book after the function returnBook`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        val user = User("Ivan")
        library.registerUser(user)
        library.takeBook(user, book)
        library.returnBook(book)
        assertEquals(Status.Available, library.getBookStatus(book))
    }

    @Test
    fun `checking for an exception when the status changes to the same`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.setBookStatus(book, Status.Available) }
        assertEquals("You can't set status that book already have!", exception.message)
    }

    @Test
    fun `checking for an exception when adding an existing book`() {
        val library = Library()
        library.addBook(Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021)), Status.Available)
        val exception =
            assertFailsWith<IllegalArgumentException> {
                library.addBook(
                    Book(
                        "Left You Dead",
                        Author("Peter James"),
                        Genre.CRIME,
                        Year(2021)
                    ), Status.Available
                )
            }
        assertEquals("You can't add book that is already in library!", exception.message)
    }

    @Test
    fun `checking for an exception when adding an existing user`() {
        val library = Library()
        val user = User("Ivan")
        library.registerUser(user)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.registerUser(user) }
        assertEquals("You can't registered an registered user!", exception.message)
    }

    @Test
    fun `checking for an exception when deleting a non-existent user`() {
        val library = Library()
        val user = User("Ivan")
        val exception =
            assertFailsWith<IllegalArgumentException> { library.unregisterUser(user) }
        assertEquals("You can't unregistered an unregistered user!", exception.message)
    }

    @Test
    fun `checking for errors when issuing a non-existing book`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        val user = User("Ivan")
        val exception =
            assertFailsWith<IllegalArgumentException> { library.takeBook(user, book) }
        assertEquals("You can't give books to unregistered users!", exception.message)
    }

    @Test
    fun `checking for an error when issuing a book to a non-existing user`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        val user = User("Ivan")
        library.registerUser(user)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.takeBook(user, book) }
        assertEquals("You can't give out a book that doesn't exist", exception.message)
    }

    @Test
    fun `checking for an error when issuing an unavailable book`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.ComingSoon)
        val user = User("Ivan")
        library.registerUser(user)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.takeBook(user, book) }
        assertEquals("You can't give out books that are not available", exception.message)
    }

    @Test
    fun `checking for errors when trying to issue four books to one user`() {
        val library = Library()
        val book1 = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        val book2 = Book("Claire DeWitt and the City of the Dead", Author("Sara Gran"), Genre.CRIME, Year(2011))
        val book3 = Book("The Thief", Author("Fuminori Nakamura"), Genre.CRIME, Year(2012))
        val book4 = Book("And Then There Were None", Author("Agatha Christie"), Genre.DETECTIVE, Year(2021))
        library.addBook(book1, Status.Available)
        library.addBook(book2, Status.Available)
        library.addBook(book3, Status.Available)
        library.addBook(book4, Status.Available)
        val user = User("Ivan")
        library.registerUser(user)
        library.takeBook(user, book1)
        library.takeBook(user, book2)
        library.takeBook(user, book3)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.takeBook(user, book4) }
        assertEquals("User can't have more than three books", exception.message)
    }

    @Test
    fun `checking for an exception when returning an available book`() {
        val library = Library()
        val book = Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021))
        library.addBook(book, Status.Available)
        val exception =
            assertFailsWith<IllegalArgumentException> { library.returnBook(book) }
        assertEquals("You can't return a book that is already in the library", exception.message)
    }

}