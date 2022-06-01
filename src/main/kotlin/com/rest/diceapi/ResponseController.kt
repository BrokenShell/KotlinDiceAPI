package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
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

    @GetMapping("/die")
    fun getDie(@RequestParam(value = "sides", defaultValue = "6") sides: Int): Response {
        return Response(dice(1, sides))
    }

    @GetMapping("/dice")
    fun getDice(@RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
                @RequestParam(value = "sides", defaultValue = "20") sides: Int): Response {
        return Response(dice(rolls, sides))
    }

    @GetMapping("percent-true")
    fun getPercentTrue(@RequestParam(value = "chance", defaultValue = "50") chance: Int): Response {
        return Response(dice(1, 100) <= chance)
    }

    @PostMapping("random-value")
    fun getRandomValue(@RequestParam(value = "sequence") sequence: List<String>): Response {
        return Response(getRandomElement(sequence))
    }
}