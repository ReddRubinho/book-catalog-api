package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto
import reactor.core.publisher.Flux

interface BookDataSource {

  fun getBooks(): Collection<BookDto>
}
