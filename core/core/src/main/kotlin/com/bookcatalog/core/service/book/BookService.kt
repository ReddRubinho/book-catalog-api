package com.bookcatalog.core.service.book

import com.bookcatalog.core.datasource.book.BookDataSource
import com.bookcatalog.core.model.book.BookDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
//@Transactional
class BookService(@Qualifier("book_jpa") private val dataSource: BookDataSource) {

//    fun init() {
//        if (dataSource.findAll().isEmpty()) {
//            val book: BookDto
//            book
//        }
//
//    }

    fun getBooks(): Collection<BookDto> = dataSource.findAll()

    fun getBooksByTitle(title: String): Collection<BookDto> = dataSource.findByTitle(title)

    fun getBook(isbn: String): BookDto = dataSource.findByIsbn(isbn)

    fun postBook(book: BookDto): BookDto = dataSource.save(book)

    fun patchBook(book: BookDto, isbn: String): BookDto = dataSource.save(book)

    fun deleteBook(isbn: String) = dataSource.deleteByIsbn(isbn)

    fun deleteAll() = dataSource.deleteAll()
}
