package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ResponseController {

    @GetMapping("/")
    fun getHome(): String {
        return homepage
    }

    @GetMapping("/canonical")
    fun getCanonical(): Response {
        return Response(canonical())
    }

    @GetMapping("/range")
    fun getRange(@RequestParam(value = "lo", defaultValue = "1") lo: Int,
                 @RequestParam(value = "hi", defaultValue = "10") hi: Int): Response {
        return Response(randomRange(lo, hi))
    }

    @GetMapping("/die")
    fun getDie(@RequestParam(value = "sides", defaultValue = "6") sides: Int): Response {
        return Response(randomDice(1, sides))
    }

    @GetMapping("/dice")
    fun getDice(@RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
                @RequestParam(value = "sides", defaultValue = "20") sides: Int): Response {
        return Response(randomDice(rolls, sides))
    }

    @GetMapping("/percent-true")
    fun getPercentTrue(@RequestParam(value = "chance", defaultValue = "50") chance: Int): Response {
        return Response(randomDice(1, 100) <= chance)
    }

    @GetMapping("/random-value")
    fun getRandomValue(@RequestParam(value = "sequence") sequence: List<String>): Response {
        return Response(getRandomElement(sequence))
    }
}