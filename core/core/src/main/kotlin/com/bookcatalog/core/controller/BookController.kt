package com.bookcatalog.core.controller

import com.bookcatalog.core.model.BookDto
import com.bookcatalog.core.service.BookService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

  @GetMapping
  fun getBooks(): Collection<BookDto> = bookService.getBooks()
}
