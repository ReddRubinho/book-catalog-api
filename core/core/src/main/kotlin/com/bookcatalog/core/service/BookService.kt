package com.bookcatalog.core.service

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.model.BookDto
import org.springframework.stereotype.Service

@Service
class BookService (private val dataSource: BookDataSource){
  fun getBooks() : Collection<BookDto> = dataSource.getBooks()
}
