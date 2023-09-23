package io.ggamnyang.quarter.main.domain.recipe

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.flavor.FlavorService
import io.ggamnyang.quarter.main.domain.flavor.TASTE
import io.ggamnyang.quarter.main.domain.size.Size
import io.ggamnyang.quarter.main.domain.size.SizeRepository
import io.ggamnyang.quarter.main.domain.size.getByIdNotNull
import org.springframework.stereotype.Service

@Service
class RecipeService(
    private val flavorService: FlavorService,
    private val sizeRepository: SizeRepository,
    private val recipeRepository: RecipeRepository
) {

    fun createRecipe(request: RecipeRequest): PostRecipeResponse {
        val size = sizeRepository.getByIdNotNull(request.sizeId)
        val flavors = getRecommendedFlavors(request.ingredientIds, size)

//        val recipe = recipeRepository.findByFlavors(flavors) ?: save(flavors) FIXME: 조회 후 저장 로직 필요
        val recipe = save(flavors, size)

        return PostRecipeResponse(recipe)
    }

    private fun getRecommendedFlavors(ingredientIds: List<Long>, size: Size): List<Flavor> {
        val flavors = flavorService.findFlavorsByIngredientIds(ingredientIds)

        return flavors.shuffled().take(size.value) // FIXME: shuffled 병목이 생긴다면 index 랜덤으로 수정
    }

    private fun save(flavors: List<Flavor>, size: Size): Recipe {
        val name = createName(flavors)
        val recipe = Recipe(name, size)
        recipe.addFlavors(flavors)

        return recipeRepository.save(recipe)
    }

    private fun createName(flavors: List<Flavor>): String {
        val tastes = flavors.map { it.taste }
        val tasteMap = TASTE.countTastes(tastes)

        val maxTaste = tasteMap.maxBy { it.value }
        val isPlural = tasteMap.all { it.value == maxTaste.value }

        return TASTE.tasteToRecipeName(maxTaste.key, isPlural)
    }

    fun findById(id: Long): RecipeResponse {
        val recipe = recipeRepository.getByIdNotNull(id)

        return RecipeResponse(recipe)
    }
}
