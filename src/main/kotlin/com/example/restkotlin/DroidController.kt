package com.example.restkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/droid")
class DroidController(val droid: Droid) {
    @GetMapping
    fun getDroid2(): Droid {
        return droid
    }
}