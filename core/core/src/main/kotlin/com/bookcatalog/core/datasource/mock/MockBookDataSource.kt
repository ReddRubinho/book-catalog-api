package com.bookcatalog.core.datasource.mock

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.model.BookDto
import org.springframework.stereotype.Repository

@Repository
class MockBookDataSource : BookDataSource {

  val books = listOf(BookDto(1, 1 ,"a", "b", "c", 1, "d", "e"))
  override fun getBooks(): Collection<BookDto> = books
}
