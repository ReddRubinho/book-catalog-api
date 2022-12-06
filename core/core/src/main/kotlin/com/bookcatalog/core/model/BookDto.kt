package com.bookcatalog.core.model

import com.bookcatalog.core.model.id.BookId
import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.Hibernate
import java.util.*
import javax.persistence.*

@Entity(name = "book")
@IdClass(BookId::class)
data class BookDto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("book_id")
    val id: Int = 0,

    @Id
    @JsonProperty("isbn")
    val isbn: Int = 0,

    @JsonProperty("title")
    val title: String = "",

    @JsonProperty("authors")
    val authors: String = "",

    @JsonProperty("publisher")
    val publisher: String = "",

    @JsonProperty("premiere")
    @Temporal(TemporalType.DATE)
    val premiere: java.sql.Date = ,

    @JsonProperty("pages")
    val pages: Int = 0,

    @JsonProperty("plot")
    val plot: String = "",

    @JsonProperty("bookImage")
    val bookImage: String = ""
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as BookDto

        return id == other.id
                && isbn == other.isbn
    }

    override fun hashCode(): Int = Objects.hash(id, isbn);

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , isbn = $isbn , title = $title , authors = $authors , publisher = $publisher , pages = $pages , plot = $plot , bookImage = $bookImage )"
    }
}
