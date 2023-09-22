package io.ggamnyang.quarter.main.domain.ingredient

data class IngredientResponse(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val flavorIdList: List<Long>
) {
    constructor(ingredient: Ingredient) : this(
        ingredient.id,
        ingredient.name.kr,
        ingredient.imageUrl,
        ingredient.getFlavorIds()
    )
}
