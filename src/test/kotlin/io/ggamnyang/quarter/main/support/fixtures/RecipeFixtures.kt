package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.recipe.Recipe
import io.ggamnyang.quarter.main.domain.recipe.RecipeFlavorRelation
import io.ggamnyang.quarter.main.domain.recipe.RecipeRequest
import io.ggamnyang.quarter.main.domain.size.Size

private const val RECIPE_NAME = "recipe name"

fun createRecipe(
    name: String = RECIPE_NAME,
    size: Size = createSize(),
    recipeFlavorRelations: Set<RecipeFlavorRelation> = emptySet(),
    id: Long = 0L
): Recipe {
    return Recipe(name, size, recipeFlavorRelations, id)
}

fun createRecipeRequest(
    sizeId: Long = 1L,
    ids: List<Long> = listOf(1, 2, 3)
): RecipeRequest {
    return RecipeRequest(sizeId, ids)
}
