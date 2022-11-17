package com.bookcatalog.core.datasource.network

import com.bookcatalog.core.datasource.BookDataSource
import com.bookcatalog.core.datasource.network.dto.BookList
import com.bookcatalog.core.model.BookDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("book_network")
class NetworkDataSource(
  @Autowired private val restTemplate: RestTemplate
) : BookDataSource {

  override fun getBooks(): Collection<BookDto> {
    val response: ResponseEntity<BookList> =
      restTemplate.getForEntity("http://localhost:8080/books")

    return response.body?.results
      ?: throw IOException("Could not fetch books from the network")
  }

  override fun getBook(isbn: String): BookDto {
    TODO("Not yet implemented")
  }

  override fun postBook(book: BookDto): BookDto {
    TODO("Not yet implemented")
  }

  override fun patchBook(book: BookDto, isbn: Int): BookDto {
    TODO("Not yet implemented")
  }

  override fun deleteBook(isbn: Int) {
    TODO("Not yet implemented")
  }
}
