package com.bookcatalog.core.datasource.book

import com.bookcatalog.core.model.book.BookDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("book_jpa")
interface BookDataSource: JpaRepository<BookDto, Int> {

  fun findByIsbn(isbn: String): BookDto

  fun deleteByIsbn(isbn: String): Any

  fun findByTitle(title: String): Collection<BookDto>
}
