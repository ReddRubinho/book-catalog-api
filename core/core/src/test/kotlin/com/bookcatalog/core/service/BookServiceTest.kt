package com.bookcatalog.core.service

import com.bookcatalog.core.datasource.book.BookDataSource
import com.bookcatalog.core.service.book.BookService
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BookServiceTest constructor(
    private val dataSource: BookDataSource = mockk(relaxed = true),
    private val bookService: BookService = BookService(dataSource)
){



  @Test
  fun `should call its data source to retrieve books`() {
    //when
    val books = bookService.getBooks()
    //then
    verify(exactly = 1) {
      dataSource.getBooks()
    }
  }
}
