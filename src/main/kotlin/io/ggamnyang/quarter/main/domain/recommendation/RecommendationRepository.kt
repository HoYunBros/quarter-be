package io.ggamnyang.quarter.main.domain.recommendation

import org.springframework.data.jpa.repository.JpaRepository

interface RecommendationRepository : JpaRepository<Recommendation, Long>
