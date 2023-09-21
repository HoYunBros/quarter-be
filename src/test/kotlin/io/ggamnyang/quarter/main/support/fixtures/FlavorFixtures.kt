package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.main.domain.flavor.TASTE
import io.ggamnyang.quarter.main.domain.recipe.RecipeFlavorRelation

private const val FLAVOR_NAME = "엄마는 외계인"
private const val FLAVOR_IMAGE_URL = "www.url.com"

fun createFlavor(
    name: String = FLAVOR_NAME,
    imageUrl: String = FLAVOR_IMAGE_URL,
    taste: TASTE = TASTE.SWEET,
    relation1: List<FlavorIngredientRelation> = emptyList(),
    relation2: List<RecipeFlavorRelation> = emptyList(),
    id: Long = 0L
): Flavor {
    return Flavor(name, imageUrl, taste, relation1, relation2, id)
}
