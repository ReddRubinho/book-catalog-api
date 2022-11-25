package com.bookcatalog.core.model

import com.fasterxml.jackson.annotation.JsonProperty

@Entity
data class BookDto constructor(

  @JsonProperty("book_id")
  val id: Number,
  @JsonProperty("isbn")
  val isbn: Number,
  @JsonProperty("title")
  val title: String,
  @JsonProperty("authors")
  val authors: String,
  @JsonProperty("publisher")
  val publisher: String,
  @JsonProperty("pages")
  val pages: Number,
  @JsonProperty("plot")
  val plot: String,
  @JsonProperty("bookImage")
  val bookImage: String
)
