package io.ggamnyang.quarter.main.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JenkinsTestController {

    @GetMapping("/test")
    fun testJenkins(): String {
        return "Hello, Jenkins CI CD WORLD!!!!"
    }
}
