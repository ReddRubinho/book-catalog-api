package com.bookcatalog.core.model

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
    var isbn: Int = 0,

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
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as BookDto

        return  isbn == other.isbn
    }

    override fun hashCode(): Int = Objects.hash(isbn);

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(isbn = $isbn , title = $title , authors = $authors , publisher = $publisher , pages = $pages , plot = $plot , bookImage = $bookImage )"
    }
}
