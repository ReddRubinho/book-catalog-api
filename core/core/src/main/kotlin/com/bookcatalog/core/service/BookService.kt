package com.bookcatalog.core.service

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.model.BookDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BookService(@Qualifier("book_jpa") private val dataSource: BookDataSource){
  fun getBooks() : Collection<BookDto> = dataSource.findAll()

  fun getBook(isbn: Int) : BookDto = dataSource.findByIsbn(isbn)

  fun postBook(book: BookDto): BookDto  = dataSource.save(book)

  fun patchBook(book: BookDto, isbn: Int): BookDto = dataSource.save(book)

  fun deleteBook(isbn: Int) = dataSource.deleteByIsbn(isbn)
}
