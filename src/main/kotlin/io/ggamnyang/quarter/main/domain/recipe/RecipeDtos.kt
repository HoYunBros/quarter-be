package io.ggamnyang.quarter.main.domain.recipe

import io.ggamnyang.quarter.main.domain.flavor.FlavorResponse

data class RecipeRequest(
    val sizeId: Long,
    val ingredientIds: List<Long>
)

data class RecipeResponse(
    val id: Long,
    val recipeName: String,
    val flavors: List<FlavorResponse>
) {
    constructor(recipe: Recipe) : this(
        recipe.id,
        recipe.name,
        recipe.getFlavors().map { FlavorResponse(it) } // FIXME: nah
    )
}

data class PostRecipeResponse(
    val id: Long
) {
    constructor(recipe: Recipe) : this(
        recipe.id
    )
}
