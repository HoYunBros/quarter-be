package io.ggamnyang.quarter.main.domain.ingredient

import org.springframework.cache.annotation.Cacheable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : JpaRepository<Ingredient, Long> {

    @Cacheable(value = ["allIngredients"], key = "'all'")
    @Query("SELECT i FROM Ingredient i LEFT JOIN FETCH i.flavorIngredientRelation ORDER BY i.id ASC")
    override fun findAll(): List<Ingredient>

    fun findByName(name: IngredientName): Ingredient?
}
