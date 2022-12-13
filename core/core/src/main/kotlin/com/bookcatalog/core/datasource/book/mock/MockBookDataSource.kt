package com.bookcatalog.core.datasource.book.mock

import com.bookcatalog.core.datasource.book.BookDataSource
import com.bookcatalog.core.model.book.BookDto
import org.springframework.stereotype.Repository
import java.sql.Date

@Repository("book_mock")
abstract class MockBookDataSource : BookDataSource {

  val books = mutableListOf(
    BookDto("1", "a", "b", "c", Date.valueOf("2000-12-05"), 1, "d", "e"),
    BookDto("2", "a", "a", "c", Date.valueOf("2000-12-05"), 1, "d", "e"),
    BookDto("3", "a", "a", "c", Date.valueOf("2000-12-05"), 1, "d", "e"),
    BookDto("4", "b", "b", "c", Date.valueOf("2000-12-05"), 1, "d", "e")
  )

  fun getBooks(): Collection<BookDto> = books
  fun getBook(isbn: String): BookDto = books.firstOrNull { it.isbn == isbn }
    ?: throw NoSuchElementException("Could not find a book with isbn $isbn")

  fun postBook(book: BookDto): BookDto {
    if (books.any { it.isbn == book.isbn }) {
      throw IllegalArgumentException("Book with isbn ${book.isbn} already exists")
    } else {
      books.add(book)
    }
    return book
  }

  fun patchBook(book: BookDto, isbn: String): BookDto {
    val currentBook = books.firstOrNull { it.isbn == isbn }
      ?: throw NoSuchElementException("Could not find a book with isbn ${book.isbn}")

    books.remove(currentBook)
    books.add(book)

    return book
  }

  fun deleteBook(isbn: String) {
    val deletedBook: BookDto = books.firstOrNull() { it.isbn == isbn }
      ?: throw NoSuchElementException("Could not find a book with isbn ${isbn}")

    books.remove(deletedBook)
  }

  override fun findByIsbn(isbn: String): BookDto = books.firstOrNull { it.isbn == isbn }
    ?: throw NoSuchElementException("Could not find a book with isbn $isbn")

}
