package com.bookcatalog.core.controller

import com.bookcatalog.core.model.BookDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BookControllerTest @Autowired constructor(
  val mockMvc: MockMvc,
  val objectMapper: ObjectMapper
) {


  @Nested
  @DisplayName("getBooks()")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class GetBanks {
    @Test
    fun `should return all books`() {

      //give
      mockMvc.get("/books")
        .andDo { print() }
        .andExpect {
          status { isOk() }
          content { contentType(MediaType.APPLICATION_JSON) }
          jsonPath("$[0].book_id") { value(1) }
        }
      //when

      //then
    }
  }


  @Nested
  @DisplayName("getBook()")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class GetBank {
    @Test
    fun `should return a book with the given isbn`() {
      val isbn = 1
      //give
      mockMvc.get("/books/$isbn")
        .andDo { print() }
        .andExpect {
          status { isOk() }
          content { contentType(MediaType.APPLICATION_JSON) }
          jsonPath("$.title") { value("a") }
          jsonPath("$.authors") { value("b") }
        }
      //when

      //then
    }

    @Test
    fun `should  return NOT FOUND if a book with given isbn does not exist`() {

      //give
      val isbn = 5

      //then

      mockMvc.get("/books/$isbn")
        .andDo { print() }
        .andExpect {
          status { isNotFound() }
        }
    }
  }

  @Nested
  @DisplayName("postBook()")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class PostNewBook {

    @Test
    fun `should post the new book`() {

      //give
      val newBook = BookDto(8, 8, "a", "b", "c", 1, "d", "e")
      //when
      val post = mockMvc.post("/books") {
        contentType = MediaType.APPLICATION_JSON
        content = objectMapper.writeValueAsString(newBook)
      }
      //then
      post
        .andDo { print() }
        .andExpect {
          status { isCreated() }
        }
    }

    @Test
    fun `should return BAD REQUEST if a book with given isbn already exists`() {

      //give
      val invalidBook = BookDto(4, 4, "a", "b", "c", 1, "d", "e")
      //when
      val post = mockMvc.post("/books") {
        contentType = MediaType.APPLICATION_JSON
        content = objectMapper.writeValueAsString(invalidBook)
      }
      //then
      post
        .andDo { print() }
        .andExpect {
          status { isBadRequest() }
        }
    }
  }

  @Nested
  @DisplayName("patchBook()")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class PatchBook {

    @Test
    fun `should update an existing book`() {

      //give
      val isbn = 4
      val updatedBook = BookDto(4, 4, "b", "b", "kkkkkk", 1, "d", "e")
      val put = mockMvc.patch("/books/${updatedBook.isbn}") {
        contentType = MediaType.APPLICATION_JSON
        content = objectMapper.writeValueAsString(updatedBook)
      }
      //then
      put
        .andDo { print() }
        .andExpect {
          status { isOk() }
          content {
            contentType(MediaType.APPLICATION_JSON)
            json(objectMapper.writeValueAsString(updatedBook))
          }

        }
      mockMvc.get("/books/${updatedBook.isbn}")
        .andExpect {
          content { json(objectMapper.writeValueAsString(updatedBook)) }
        }
    }

    @Test
    fun `should return NOT FOUND if isbn match no existing book`() {

      //give
      val invalidBook = BookDto(8, 5, "b", "b", "c", 1, "d", "e")
      //when
      val patchRequest = mockMvc.patch("/books/${invalidBook.isbn}") {
        contentType = MediaType.APPLICATION_JSON
        content = objectMapper.writeValueAsString(invalidBook)
      }
      //then
      patchRequest
        .andDo { print() }
        .andExpect { status { isNotFound() } }
    }
  }

  @Nested
  @DisplayName("deleteBook()")
  @TestInstance(TestInstance.Lifecycle.PER_CLASS)
  inner class DeleteBook {

    @Test
    fun `should delete an existing book`() {

      //give
      val toDeleteIsbn = 4
      //when/then
      mockMvc.delete("/books/$toDeleteIsbn")
        .andDo { print() }
        .andExpect { status { isNoContent() } }
      mockMvc.get("/books/$toDeleteIsbn")
        .andDo { print() }
        .andExpect { status { isNotFound() } }
    }

    @Test
    fun `should return NOT FOUND if isbn match no existing book `() {

      //give
      val toDeleteIsbn = 5
      //when

      //then
      mockMvc.delete("/books/$toDeleteIsbn")
        .andDo { print() }
        .andExpect { status { isNotFound() } }
    }
  }
}
