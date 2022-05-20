package com.rest.diceapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DiceApiApplication

fun main(args: Array<String>) {
    runApplication<DiceApiApplication>(*args)
}
