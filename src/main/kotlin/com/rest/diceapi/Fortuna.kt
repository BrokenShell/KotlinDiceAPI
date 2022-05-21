package com.rest.diceapi

import java.util.concurrent.ThreadLocalRandom

fun canonical(): Double {
    val random = ThreadLocalRandom.current()
    return random.nextDouble()
}

fun randomBelow(bound: Int): Int {
    val random = ThreadLocalRandom.current()
    return random.nextInt(bound)
}

fun randomRange(lo: Int, hi: Int): Int {
    return lo + randomBelow(1 + hi - lo)
}

fun dice(rolls: Int, sides: Int): Int {
    var total = 0
    (1..rolls).forEach { _ ->
        total += randomRange(1, sides)
    }
    return total
}