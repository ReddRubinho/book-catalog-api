package com.bookcatalog.core.datasource.user

import com.bookcatalog.core.model.user.UserDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository("user_jpa")
interface UserDataSource : JpaRepository<UserDto, String> {

    fun findByUsername(username: String): UserDto
}