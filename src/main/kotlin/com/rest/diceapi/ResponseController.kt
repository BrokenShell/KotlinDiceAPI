package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom

@RestController
class ResponseController {
    val random: ThreadLocalRandom = ThreadLocalRandom.current()

    fun dice(rolls: Int, sides: Int): Int {
        var total = 0
        (1..rolls).forEach { _ ->
            total += randomRange(1, sides)
        }
        return total
    }

    fun randomRange(lo: Int, hi: Int): Int {
        return lo + random.nextInt(1 + hi - lo)
    }

    @GetMapping("/")
    fun response(
        @RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
        @RequestParam(value = "sides", defaultValue = "20") sides: Int,
    ): Response {
        return Response(dice(rolls, sides))
    }
}