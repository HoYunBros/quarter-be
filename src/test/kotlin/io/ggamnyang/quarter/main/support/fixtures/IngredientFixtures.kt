package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName
import io.ggamnyang.quarter.main.domain.ingredient.IngredientResponse

private val INGREDIENT_NAME = IngredientName.CHOCOLATE
private const val INGREDIENT_IMAGE_URL = "www.url.com"

fun createIngredient(
    name: IngredientName = INGREDIENT_NAME,
    imageUrl: String = INGREDIENT_IMAGE_URL,
    relation: List<FlavorIngredientRelation> = emptyList(),
    id: Long = 0L
): Ingredient {
    return Ingredient(name, imageUrl, relation, id)
}

fun createIngredientResponse(
    ingredient: Ingredient = createIngredient()
): IngredientResponse {
    return IngredientResponse(ingredient)
}
