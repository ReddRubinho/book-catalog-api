package com.bookcatalog.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableJpaRepositories
class CoreApplication {
  @Bean fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()
}

fun main(args: Array<String>) {
	runApplication<CoreApplication>(*args)
}
