package com.rest.diceapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ThreadLocalRandom

@RestController
class ResponseController {

    fun dice(rolls: Int, sides: Int): Int {
        var total = 0
        (1..rolls).forEach { _ ->
            total += randomRange(1, sides)
        }
        return total
    }

    fun randomRange(lo: Int, hi: Int): Int {
        val random = ThreadLocalRandom.current()
        return lo + random.nextInt(1 + hi - lo)
    }

    @GetMapping("/")
    fun home(): String {
        val output = listOf(
            "<!DOCTYPE html>",
            "<html lang='en'>",
            "<head>",
            "<meta charset='UTF-8'>",
            "<title>YARGA</title>",
            "</head>",
            "<body>",
            "<h1>Welcome to YARGA!</h1>",
            "<h2>Yet Another Random Generator API</h2>",
            "<br>",
            "<h3>API Endpoints</h3>",
            "<h4>Dice</h4>",
            "<ul>",
            "<li>Dice(rolls: Int, sides: Int) -> Int</li>",
            "<li>Method: GET</li>",
            "<li>Param `rolls`: Int</li>",
            "<li>Param `sides`: Int</li>",
            "<li>Example: <a href='/dice?rolls=1&sides=20'>/dice?rolls=1&sides=20</a></li>",
            "</ul>",
            "<h4>PercentTrue</h4>",
            "<ul>",
            "<li>PercentTrue(percent: Int) -> Bool</li>",
            "<li>Method: GET</li>",
            "<li>Param `percent`: Int</li>",
            "<li>Example: <a href='/percent-true?percent=50'>/percent-true?percent=50</a></li>",
            "</ul>",
            "</body>",
            "</html>",
        )
        return output.joinToString(separator = "\n")
    }

    @GetMapping("/dice")
    fun getDice(
        @RequestParam(value = "rolls", defaultValue = "1") rolls: Int,
        @RequestParam(value = "sides", defaultValue = "20") sides: Int,
    ): NumericResponse {
        return NumericResponse(dice(rolls, sides))
    }

    @GetMapping("percent-true")
    fun getPercentTrue(
        @RequestParam(value = "percent", defaultValue = "50") percent: Int,
    ): BoolResponse {
        return BoolResponse(dice(1, 100) <= percent)
    }
}