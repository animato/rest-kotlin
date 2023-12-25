package com.example.restkotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.UUID

@SpringBootApplication
class RestKotlinApplication

fun main(args: Array<String>) {
    runApplication<RestKotlinApplication>(*args)
}

class Coffee(val id: String, var name: String) {
    constructor(name: String) : this(UUID.randomUUID().toString(), name)
}