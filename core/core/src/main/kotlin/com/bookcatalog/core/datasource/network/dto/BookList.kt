package com.bookcatalog.core.datasource.network.dto

import com.bookcatalog.core.model.BookDto

data class BookList (
  val results: Collection<BookDto>
  ) {
}
