package com.bookcatalog.core.datasource.mock

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.model.BookDto
import org.springframework.stereotype.Repository

@Repository("book_mock")
abstract class MockBookDataSource : BookDataSource {

  val books = mutableListOf(
    BookDto(1, 1, "a", "b", "c", 1, "d", "e"),
    BookDto(2, 2, "a", "a", "c", 1, "d", "e"),
    BookDto(3, 3, "a", "a", "c", 1, "d", "e"),
    BookDto(4, 4, "b", "b", "c", 1, "d", "e")
  )

  fun getBooks(): Collection<BookDto> = books
  fun getBook(isbn: String): BookDto = books.firstOrNull { it.isbn == isbn.toInt() }
    ?: throw NoSuchElementException("Could not find a book with isbn $isbn")

  fun postBook(book: BookDto): BookDto {
    if (books.any { it.isbn == book.isbn }) {
      throw IllegalArgumentException("Book with isbn ${book.isbn} already exists")
    } else {
      books.add(book)
    }
    return book
  }

  fun patchBook(book: BookDto, isbn: Int): BookDto {
    val currentBook = books.firstOrNull { it.isbn == isbn }
      ?: throw NoSuchElementException("Could not find a book with isbn ${book.isbn}")

    books.remove(currentBook)
    books.add(book)

    return book
  }

  fun deleteBook(isbn: Int) {
    val deletedBook: BookDto = books.firstOrNull() { it.isbn == isbn }
      ?: throw NoSuchElementException("Could not find a book with isbn ${isbn}")

    books.remove(deletedBook)
  }

  override fun findByIsbn(isbn: Int): BookDto = books.firstOrNull { it.isbn == isbn.toInt() }
    ?: throw NoSuchElementException("Could not find a book with isbn $isbn")

}
