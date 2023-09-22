package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.recipe.Recipe
import io.ggamnyang.quarter.main.domain.recipe.RecipeFlavorRelation
import io.ggamnyang.quarter.main.domain.recipe.RecipeRequest

private const val RECIPE_NAME = "recipe name"
private const val SIZE_VALUE = 3
private const val SIZE_IMAGE_URL = "www.url.com"

fun createRecipe(
    name: String = RECIPE_NAME,
    recipeFlavorRelations: List<RecipeFlavorRelation>,
    id: Long = 0L
): Recipe {
    return Recipe(name, recipeFlavorRelations, id)
}

fun createRecipeRequest(
    ids: List<Long>
): RecipeRequest {
    return RecipeRequest(ids)
}
