package com.example.restkotlin

import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Component

@Component
class DataLoader(val coffeeRepository: CoffeeRepository) {
    @PostConstruct
    fun postConstruct() {
        coffeeRepository.saveAll(mutableListOf(Coffee("Cafe Cereza"),
            Coffee("Cafe Ganador"),
            Coffee("Cafe Lareno"),
            Coffee("Cafe Tres Pontas")))
    }
}