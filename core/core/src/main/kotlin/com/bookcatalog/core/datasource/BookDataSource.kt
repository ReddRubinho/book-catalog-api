package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository("book_jpa")
interface BookDataSource: JpaRepository<BookDto, Number> {

  fun findByIsbn(isbn: Int): BookDto

  fun deleteByIsbn(isbn: Int): Any
}
