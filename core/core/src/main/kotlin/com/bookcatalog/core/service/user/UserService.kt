package com.bookcatalog.core.service.user


import com.bookcatalog.core.datasource.user.UserDataSource
import com.bookcatalog.core.model.user.UserDto
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(@Qualifier("user_jpa") private val dataSource: UserDataSource) {

    fun getUsers(): Collection<UserDto> = dataSource.findAll()

    fun getUser(username: String): UserDto = dataSource.findByUsername(username)

    fun postUser(user: UserDto): UserDto = dataSource.save(user)

    fun patchUser(user: UserDto, username: String): UserDto = dataSource.save(user)

    fun deleteUser(username: String) = dataSource.deleteById(username)

}