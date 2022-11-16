package com.bookcatalog.core.model

import com.fasterxml.jackson.annotation.JsonProperty

data class BookDto constructor(

  @JsonProperty("")
  val id: Number,
  val isbn: Number,
  val title: String,
  val authors: String,
  val publisher: String,
  val pages: Number,
  val plot: String,
  val bookImage: String
)
