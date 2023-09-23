package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.recommendation.RecommendationResponse
import io.ggamnyang.quarter.main.domain.recommendation.RecommendationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/recommendations")
class RecommendationRestController(
    private val recommendationService: RecommendationService
) {

    @GetMapping
    fun findAll(): ResponseEntity<ApiResponse<List<RecommendationResponse>>> {
        val responses = recommendationService.findAll()

        return ResponseEntity.ok(ApiResponse.success(responses))
    }
}
