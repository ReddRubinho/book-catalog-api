package com.bookcatalog.core.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBookDataSourceTest {

  private val mockDataSource = MockBookDataSource()

  @Test
  fun `should provide a collection of books`() {
    //when

    val books = mockDataSource.getBooks()
    //then

    assertThat(books).isNotEmpty
    assertThat(books.size).isGreaterThanOrEqualTo(1)
  }

  @Test
  fun `should provide some mock data`() {
    //when

    val books = mockDataSource.getBooks()
    //then

    assertThat(books).allMatch {it.authors.isNotBlank() && it.id != 0 }
  }

}
