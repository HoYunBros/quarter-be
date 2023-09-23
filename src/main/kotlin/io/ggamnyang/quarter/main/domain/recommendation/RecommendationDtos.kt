package io.ggamnyang.quarter.main.domain.recommendation

import io.ggamnyang.quarter.main.domain.recipe.RecipeResponse

data class RecommendationResponse(
    val cover: CoverResponse,
    val recipe: RecipeResponse
) {
    constructor(recommendation: Recommendation) : this(
        CoverResponse(recommendation),
        RecipeResponse(recommendation.recipe)
    )
}

data class CoverResponse(
    val id: Long,
    val title: String,
    val subTitle: String,
    val imageUrl: String
) {
    constructor(recommendation: Recommendation) : this(
        recommendation.id,
        recommendation.title,
        recommendation.subTitle,
        recommendation.imageUrl
    )
}
