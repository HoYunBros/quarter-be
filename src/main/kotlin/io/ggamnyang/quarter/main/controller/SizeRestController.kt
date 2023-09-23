package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.size.SizeResponse
import io.ggamnyang.quarter.main.domain.size.SizeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sizes")
class SizeRestController(
    private val sizeService: SizeService
) {

    @GetMapping
    fun findAll(): ResponseEntity<ApiResponse<List<SizeResponse>>> {
        val responses = sizeService.findAll()

        return ResponseEntity.ok(ApiResponse.success(responses))
    }
}
