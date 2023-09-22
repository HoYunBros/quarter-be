package io.ggamnyang.quarter.support

import io.ggamnyang.quarter.main.domain.flavor.FlavorRepository
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName
import io.ggamnyang.quarter.main.domain.ingredient.IngredientRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class DatabaseInitializer(
    private val ingredientRepository: IngredientRepository,
    private val flavorRepository: FlavorRepository
) {

    @PostConstruct
    fun initializeData() {
        initializeIngredients()
        initializeFlavors()
    }

    private fun initializeIngredients() {
        ingredients.forEach { ingredient ->
            ingredientRepository.findByName(ingredient.name) ?: ingredientRepository.save(ingredient)
        }
    }

    private fun initializeFlavors() {
//        val flavors = listOf(
//            Flavor(name = "민트초코", imageUrl = "imageUrl2", taste = TASTE.MINTY),
//            // ... 다른 맛들
//        )
//
//        flavors.forEach { flavor ->
//            flavorRepository.findByName(flavor.name) ?: flavorRepository.save(flavor)
//        }
    }

    companion object {
        private val ingredients = listOf(
            Ingredient(IngredientName.MINT, url("mint")),
            Ingredient(IngredientName.STRAWBERRY, url("strawberry")),
            Ingredient(IngredientName.CHOCOLATE, url("chocolate")),
            Ingredient(IngredientName.GREEN_TEA, url("green_tea")),
            Ingredient(IngredientName.CHEESE_CAKE, url("cheese_cake")),
            Ingredient(IngredientName.BLUEBERRY, url("blueberry")),
            Ingredient(IngredientName.YOGURT, url("yogurt")),
            Ingredient(IngredientName.COFFEE, url("coffee")),
            Ingredient(IngredientName.ALMOND, url("almond")),
            Ingredient(IngredientName.OREO, url("oreo")),
            Ingredient(IngredientName.CHERRY, url("cherry")),
            Ingredient(IngredientName.ORANGE, url("orange")),
            Ingredient(IngredientName.PINEAPPLE, url("pineapple")),
            Ingredient(IngredientName.RASPBERRY, url("raspberry")),
            Ingredient(IngredientName.COTTON_CANDY, url("cotton_candy")),
            Ingredient(IngredientName.VANILLA, url("vanilla")),
            Ingredient(IngredientName.PISTACHIO, url("pistachio")),
            Ingredient(IngredientName.APPLE, url("apple")),
            Ingredient(IngredientName.APPLE_MANGO, url("apple_mango")),
            Ingredient(IngredientName.MILK_CREAM, url("milk_cream")),
            Ingredient(IngredientName.BUTTER_COOKIE, url("butter_cookie"))
        )

        private fun url(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/flavors/$name.png"
    }
}
