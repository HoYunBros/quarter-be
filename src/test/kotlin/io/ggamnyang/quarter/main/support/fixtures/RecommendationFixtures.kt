package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.recipe.Recipe
import io.ggamnyang.quarter.main.domain.recommendation.Recommendation

private const val TITLE = "Recommendation Title"
private const val SUB_TITLE = "Recommendation Sub Title"
private const val IMAGE_URL = "www.imageUrl.com"

fun createRecommendation(
    title: String = TITLE,
    subTitle: String = SUB_TITLE,
    imageUrl: String = IMAGE_URL,
    recipe: Recipe = createRecipe(),
    id: Long = 0L
): Recommendation {
    return Recommendation(title, subTitle, imageUrl, recipe, id)
}
