package com.bookcatalog.core.model.book

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import java.text.SimpleDateFormat
import java.util.*
import javax.persistence.*

@Entity(name = "book")
data class BookDto(

    @Id
    @JsonProperty("isbn")
    @Column(name = "isbn")
    val isbn: Int = 0,

    @JsonProperty("title")
    @Column(name = "title")
    val title: String = "",

    @JsonProperty("authors")
    @Column(name = "authors")
    val authors: String = "",

    @JsonProperty("publisher")
    @Column(name = "publisher")
    val publisher: String = "",

    @JsonProperty("premiere")
    @Temporal(TemporalType.DATE)
    @Column(name = "premiere")
    val premiere: Date = SimpleDateFormat("dd/MM/yyyy").parse("00/00/0000"),

    @JsonProperty("pages")
    @Column(name = "pages")
    val pages: Int = 0,

    @JsonProperty("plot")
    @Column(name = "plot")
    val plot: String = "",

    @JsonProperty("book_image")
    @Column(name = "book_image")
    val bookImage: String = ""
)
