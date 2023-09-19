package io.ggamnyang.quarter

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class JenkinsTestController {

    @GetMapping("/test")
    @ResponseBody
    fun testJenkins(): String {
        return "Hello, Jenkins CI CD WORLD"
    }
}
