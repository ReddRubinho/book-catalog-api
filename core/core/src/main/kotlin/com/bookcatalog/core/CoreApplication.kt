package com.bookcatalog.core

import com.bookcatalog.core.configuration.BookCatalogConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.hibernate5.LocalSessionFactoryBean

@SpringBootApplication
@EnableJpaRepositories
class CoreApplication {

}

fun main(args: Array<String>) {

        runApplication<CoreApplication>(*args)
}
