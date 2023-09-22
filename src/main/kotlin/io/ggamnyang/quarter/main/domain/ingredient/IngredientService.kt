package io.ggamnyang.quarter.main.domain.ingredient

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class IngredientService(
    private val ingredientRepository: IngredientRepository
) {

    fun findAll(): List<IngredientResponse> {
        val ingredients = ingredientRepository.findAll()

        return ingredients.map { IngredientResponse(it) }
    }

    @Cacheable(value = ["ingredient"], key = "#name")
    fun getByName(name: IngredientName): Ingredient {
        return ingredientRepository.findByName(name) ?: throw IllegalArgumentException("$name 해당하는 재료가 없습니다")
    }
}
