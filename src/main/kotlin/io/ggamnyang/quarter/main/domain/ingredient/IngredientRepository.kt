package io.ggamnyang.quarter.main.domain.ingredient

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : JpaRepository<Ingredient, Long> {

    @Query("SELECT i FROM Ingredient i LEFT JOIN FETCH i.flavorIngredientRelation")
    override fun findAll(): List<Ingredient>
}
