package com.bookcatalog.core.datasource

import com.bookcatalog.core.model.BookDto
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class MockBookDataSource : BookDataSource {
  override fun getBanks(): Flux<BookDto> {
    TODO("Not yet implemented")
  }
}
