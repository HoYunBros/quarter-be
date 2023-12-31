package io.ggamnyang.quarter.main.domain.flavor

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FlavorIngredientRelationRepository : JpaRepository<FlavorIngredientRelation, Long>
