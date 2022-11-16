package com.bookcatalog.core.service

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.model.BookDto
import org.springframework.stereotype.Service

@Service
class BookService constructor(private val dataSource: BookDataSource){
  fun getBooks() : Collection<BookDto> = dataSource.getBooks()

  fun getBook(isbn: String) : BookDto = dataSource.getBook(isbn)

  fun postBook(book: BookDto): BookDto  = dataSource.postBook(book)

  fun patchBook(book: BookDto, isbn: Int): BookDto = dataSource.patchBook(book, isbn)

  fun deleteBook(isbn: Int) = dataSource.deleteBook(isbn)
}
