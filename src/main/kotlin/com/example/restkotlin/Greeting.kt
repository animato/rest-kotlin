package com.example.restkotlin

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "greeting")
class Greeting(var name: String, var coffee: String) {
}