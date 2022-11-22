package com.bookcatalog.core.datasource.jpa

import com.bookcatalog.core.model.BookDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("book_jpa")
interface BookRepository : JpaRepository<BookDto, Number>{

  fun findByIsbn(isbn: String): BookDto

  fun deleteByIsbn(isbn: Int): Any
}