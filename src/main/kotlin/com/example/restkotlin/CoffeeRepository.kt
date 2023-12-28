package com.example.restkotlin

import org.springframework.data.repository.CrudRepository

interface CoffeeRepository: CrudRepository<Coffee, String> {
}