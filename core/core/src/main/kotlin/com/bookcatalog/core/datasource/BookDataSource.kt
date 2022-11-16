package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto

interface BookDataSource {

  fun getBooks(): Collection<BookDto>

  fun getBook(isbn: String): BookDto

  abstract fun postBook(book: BookDto): BookDto

  abstract fun patchBook(book: BookDto, isbn: Int): BookDto

  abstract fun deleteBook(isbn: Int)
}
