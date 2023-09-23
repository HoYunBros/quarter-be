package io.ggamnyang.quarter.main.domain.recommendation

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class RecommendationService(
    private val recommendationRepository: RecommendationRepository
) {
    @Cacheable(value = ["allRecommendations"], key = "'all'")
    fun findAll(): List<RecommendationResponse> {
        val recommendations = recommendationRepository.findAll() * 10

        return recommendations.map { RecommendationResponse(it) }
    }
}

operator fun <T> Iterable<T>.times(count: Int): List<T> = List(count) { this }.flatten()
