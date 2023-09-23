package io.ggamnyang.quarter.main.domain.recommendation

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RecommendationService(
    private val recommendationRepository: RecommendationRepository
) {
    @Cacheable(value = ["allRecommendations"], key = "'all'")
    fun findAll(): List<RecommendationResponse> {
        val recommendations = recommendationRepository.findAll()

        return recommendations.map { RecommendationResponse(it) }
    }
}
