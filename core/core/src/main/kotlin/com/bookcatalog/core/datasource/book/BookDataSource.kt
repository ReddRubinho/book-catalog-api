package com.bookcatalog.core.datasource.book

import com.bookcatalog.core.model.book.BookDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("book_jpa")
interface BookDataSource: JpaRepository<BookDto, Int> {

  fun findByIsbn(isbn: Int): BookDto

  fun deleteByIsbn(isbn: Int): Any
}
