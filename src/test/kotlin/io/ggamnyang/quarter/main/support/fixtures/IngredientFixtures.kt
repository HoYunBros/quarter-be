package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient

private const val INGREDIENT_NAME = "초코"
private const val INGREDIENT_IMAGE_URL = "www.url.com"

fun createIngredient(
    name: String = INGREDIENT_NAME,
    imageUrl: String = INGREDIENT_IMAGE_URL,
    relation: List<FlavorIngredientRelation> = emptyList(),
    id: Long = 0L
): Ingredient {
    return Ingredient(name, imageUrl, relation, id)
}
