package com.bookcatalog.core.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.core.env.Environment
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.web.client.RestTemplate
import java.util.*
import javax.sql.DataSource

@Configuration
@PropertySource("application.properties")
class BookCatalogConfiguration(@Autowired private val env: Environment) {

    @Bean
    fun dataSource(): DataSource = DriverManagerDataSource(
        env.getRequiredProperty("spring.datasource.url"),
        env.getRequiredProperty("spring.datasource.username"),
        env.getRequiredProperty("spring.datasource.password")
    )

    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate = builder.build()
}