package com.bookcatalog.core.controller.book

import com.bookcatalog.core.model.book.BookDto
import com.bookcatalog.core.service.book.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
@RequestMapping("/books")
class BookController constructor(@Autowired private val bookService: BookService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getBooks(): Collection<BookDto> = bookService.getBooks()

    @GetMapping("/{isbn}")
    @ResponseStatus(HttpStatus.OK)
    fun getBook(@PathVariable isbn: Int): BookDto = bookService.getBook(isbn)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postBook(@RequestBody book: BookDto): BookDto = bookService.postBook(book)

    @PatchMapping("/{isbn}")
    fun updateBook(@RequestBody book: BookDto, @PathVariable isbn: Int): BookDto = bookService.patchBook(book, isbn)

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBook(@PathVariable isbn: Int) = bookService.deleteBook(isbn)
}
