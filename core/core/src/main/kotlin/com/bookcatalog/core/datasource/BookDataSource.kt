package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto
import reactor.core.publisher.Flux

interface BookDataSource {

  fun getBanks(): Flux<BookDto>
}
