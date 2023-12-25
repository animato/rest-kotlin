package com.example.restkotlin

import org.springframework.web.bind.annotation.*
import java.util.function.Predicate

@RestController
class RestApiDemoController {
    private val coffees: MutableList<Coffee> = mutableListOf(Coffee("Cafe Cereza"),
        Coffee("Cafe Ganador"),
        Coffee("Cafe Lareno"),
        Coffee("Cafe Tres Pontas"))

    //    @RequestMapping(value = ["/coffees"], method = [RequestMethod.GET])
    @GetMapping("/coffees")
    fun getCoffees(): Iterable<Coffee> {
        return coffees
}

    @PostMapping("/coffees")
    fun postCoffee(@RequestBody coffee: Coffee): Coffee {
        coffees.add(coffee)
        return coffee
    }

    @PutMapping("/coffees/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): Coffee {
        var coffeeIndex = -1

        for (c: Coffee in coffees) {
            if (c.id == id) {
                coffeeIndex = coffees.indexOf(c)
                coffees[coffeeIndex] = coffee
            }
        }

        return if (coffeeIndex == -1) postCoffee(coffee) else coffee;
    }

    @DeleteMapping("/coffees/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        coffees.removeIf { c -> c.id == id }
    }
}