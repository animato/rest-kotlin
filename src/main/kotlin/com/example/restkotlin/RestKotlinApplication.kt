package com.example.restkotlin

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.UUID

@SpringBootApplication
class RestKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestKotlinApplication>(*args)
}

@Entity
class Coffee(@Id var id: String, var name: String) {
    constructor(name: String) : this(UUID.randomUUID().toString(), name)
}