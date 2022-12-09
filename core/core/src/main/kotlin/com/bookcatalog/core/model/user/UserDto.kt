package com.bookcatalog.core.model.user

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "user")
data class UserDto(
    @Id
    @JsonProperty ("username")
    @Column(name = "username")
    val username: String = "",

    @JsonProperty("user_password")
    @Column(name = "user_password")
    val password: String = "",

    @JsonProperty("category")
    @Column(name = "category")
    val category: String = "",

    @JsonProperty("mail")
    @Column(name = "mail")
    val mail: String = "",

    @JsonProperty("user_image")
    @Column(name = "user_image")
    val userImage: String = ""

)