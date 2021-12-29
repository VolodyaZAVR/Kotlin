import library.Library
import library.Book
import library.Author
import library.Genre
import library.Year
import library.Status

fun main() {
    val library = Library()

    library.addBook(Book("Left You Dead", Author("Peter James"), Genre.CRIME, Year(2021)), Status.Available)
    library.addBook(Book("Claire DeWitt and the City of the Dead", Author("Sara Gran"), Genre.CRIME, Year(2011)), Status.Available)
    library.addBook(Book("The Thief", Author("Fuminori Nakamura"), Genre.CRIME, Year(2012)), Status.Restoration)
    library.addBook(Book("And Then There Were None", Author("Agatha Christie"), Genre.DETECTIVE, Year(2021)), Status.Available)
    library.addBook(Book("Cosmos", Author("Dr. Sagan"), Genre.SCIENCE, Year(1980)), Status.ComingSoon)
    library.addBook(Book("Altered Carbon", Author("Richard Morgan"), Genre.CYBERPUNK, Year(2002)), Status.Available)
    library.addBook(Book("The Lord of the Rings", Author("J. R. R. Tolkien"), Genre.FANTASY, Year(1954)), Status.Available)
    library.addBook(Book("The Great Gatsby", Author("Scott Fitzgerald"), Genre.NOVEL, Year(1925)), Status.Available)
    library.addBook(Book("1984", Author("George Orwell"), Genre.DISTOPIA, Year(1949)), Status.Available)

    println(library.findBooks(null, null, Year(2021), Genre.CRIME))
}