package com.bookcatalog.core.controller.user

import com.bookcatalog.core.model.user.UserDto
import com.bookcatalog.core.service.user.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.NoSuchElementException


@RestController
@CrossOrigin(origins = ["http://localhost:4200"])
@RequestMapping("/users")
class UserController constructor(@Autowired private val userService: UserService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getUsers(): Collection<UserDto> = userService.getUsers()

    @GetMapping("/username")
    @ResponseStatus(HttpStatus.OK)
    fun getUser(@PathVariable username: String): Optional<UserDto> = userService.getUser(username)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun postUser(@RequestBody user: UserDto): UserDto = userService.postUser(user)

    @PatchMapping("/username")
    fun updateUser(@RequestBody user: UserDto, @PathVariable username: String): UserDto = userService.patchUser(user, username)

    @DeleteMapping("/username")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable username: String) = userService.deleteUser(username)
}