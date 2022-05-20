package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom

@RestController
class ResponseController {

    fun dice(rolls: Int, sides: Int): Int {
        var total = 0
        for (i in 1..rolls) total += randomRange(1, sides)
        return total
    }

    fun randomRange(lo: Int, hi: Int): Int {
        val random = ThreadLocalRandom.current()
        return when {
            lo < hi -> lo + random.nextInt(1 + hi - lo)
            lo == hi -> lo
            else -> randomRange(hi, lo)
        }
    }

    @GetMapping("/")
    fun response(
        @RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
        @RequestParam(value = "sides", defaultValue = "20") sides: Int,
    ): Response {
        return Response(dice(rolls, sides))
    }
}