package io.ggamnyang.quarter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class QuarterApplication

fun main(args: Array<String>) {
    runApplication<QuarterApplication>(*args)
}
