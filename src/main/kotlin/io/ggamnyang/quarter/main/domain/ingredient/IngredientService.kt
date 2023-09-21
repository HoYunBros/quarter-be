package io.ggamnyang.quarter.main.domain.ingredient

import org.springframework.stereotype.Service

@Service
class IngredientService(
    private val ingredientRepository: IngredientRepository
) {

    fun findAll(): List<IngredientResponse> {
        val ingredients = ingredientRepository.findAll()
        return ingredients.map { IngredientResponse(it) }
    }
}
