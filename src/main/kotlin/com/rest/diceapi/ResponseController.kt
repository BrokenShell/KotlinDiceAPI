package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ResponseController {

    @GetMapping("/")
    fun home(): String {
        return homepage
    }

    @GetMapping("/canonical")
    fun getCanonical(): DoubleResponse {
        return DoubleResponse(canonical())
    }

    @GetMapping("/die")
    fun getDie(@RequestParam(value = "sides", defaultValue = "6") sides: Int): IntegerResponse {
        return IntegerResponse(dice(1, sides))
    }

    @GetMapping("/dice")
    fun getDice(@RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
                @RequestParam(value = "sides", defaultValue = "20") sides: Int): IntegerResponse {
        return IntegerResponse(dice(rolls, sides))
    }

    @GetMapping("percent-true")
    fun getPercentTrue(@RequestParam(value = "chance", defaultValue = "50") chance: Int): BoolResponse {
        return BoolResponse(dice(1, 100) <= chance)
    }
}