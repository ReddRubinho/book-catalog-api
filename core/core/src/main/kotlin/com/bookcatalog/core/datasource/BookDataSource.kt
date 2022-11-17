package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

interface BookDataSource {

  fun getBooks(): Collection<BookDto>

  fun getBook(isbn: String): BookDto

  abstract fun postBook(book: BookDto): BookDto

  abstract fun patchBook(book: BookDto, isbn: Int): BookDto

  abstract fun deleteBook(isbn: Int)
}
