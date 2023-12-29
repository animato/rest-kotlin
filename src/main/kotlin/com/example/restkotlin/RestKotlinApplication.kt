package com.example.restkotlin

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.UUID

@SpringBootApplication
@ConfigurationPropertiesScan
class RestKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestKotlinApplication>(*args)
}

@Configuration
class DroidConfiguration {
    @Bean
    @ConfigurationProperties(prefix = "droid")
    fun createDroid(): Droid {
        return Droid()
    }
}


@Entity
class Coffee(@Id var id: String, var name: String) {
    constructor(name: String) : this(UUID.randomUUID().toString(), name)
}