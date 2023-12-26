package com.example.restkotlin

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {
    private val coffees: MutableList<Coffee> = mutableListOf(Coffee("Cafe Cereza"),
        Coffee("Cafe Ganador"),
        Coffee("Cafe Lareno"),
        Coffee("Cafe Tres Pontas"))

    //    @RequestMapping(value = ["/coffees"], method = [RequestMethod.GET])
    @GetMapping
    fun getCoffees(): Iterable<Coffee> {
        return coffees
    }

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Coffee? {
        for (c in coffees) {
            if (c.id == id) {
                return c
            }
        }
        return null
    }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Coffee {
        coffees.add(coffee)
        return coffee
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        var coffeeIndex = -1

        for (c: Coffee in coffees) {
            if (c.id == id) {
                coffeeIndex = coffees.indexOf(c)
                coffees[coffeeIndex] = coffee
            }
        }

        return if (coffeeIndex == -1) ResponseEntity(postCoffee(coffee), HttpStatus.CREATED) else ResponseEntity(coffee, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        coffees.removeIf { c -> c.id == id }
    }
}