package com.bookcatalog.core.model

data class BookDto(
  val id: Int,
  val isbn: Int,
  val title: String,
  val authors: String,
  val publisher: String,
  val pages: Int,
  val plot: String,
  val bookImage: String
)
