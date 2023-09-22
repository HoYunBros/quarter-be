package io.ggamnyang.quarter.main.domain.recipe

import org.springframework.stereotype.Service

@Service
class RecipeService(
    private val recipeRepository: RecipeRepository
)
