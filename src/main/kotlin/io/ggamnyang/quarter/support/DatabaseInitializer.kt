package io.ggamnyang.quarter.support

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.flavor.FlavorRepository
import io.ggamnyang.quarter.main.domain.flavor.TASTE
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName
import io.ggamnyang.quarter.main.domain.ingredient.IngredientRepository
import io.ggamnyang.quarter.main.domain.ingredient.IngredientService
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class DatabaseInitializer(
    private val ingredientRepository: IngredientRepository,
    private val ingredientService: IngredientService,
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
        flavors.forEach { flavor ->
            flavorRepository.findByName(flavor.name) ?: flavorRepository.save(flavor)
        }
    }

    companion object {
        private val ingredients = listOf(
            Ingredient(IngredientName.MINT, ingredientUrl("mint")),
            Ingredient(IngredientName.STRAWBERRY, ingredientUrl("strawberry")),
            Ingredient(IngredientName.CHOCOLATE, ingredientUrl("chocolate")),
            Ingredient(IngredientName.GREEN_TEA, ingredientUrl("green_tea")),
            Ingredient(IngredientName.CHEESE_CAKE, ingredientUrl("cheese_cake")),
            Ingredient(IngredientName.BLUEBERRY, ingredientUrl("blueberry")),
            Ingredient(IngredientName.YOGURT, ingredientUrl("yogurt")),
            Ingredient(IngredientName.COFFEE, ingredientUrl("coffee")),
            Ingredient(IngredientName.ALMOND, ingredientUrl("almond")),
            Ingredient(IngredientName.OREO, ingredientUrl("oreo")),
            Ingredient(IngredientName.CHERRY, ingredientUrl("cherry")),
            Ingredient(IngredientName.ORANGE, ingredientUrl("orange")),
            Ingredient(IngredientName.PINEAPPLE, ingredientUrl("pineapple")),
            Ingredient(IngredientName.RASPBERRY, ingredientUrl("raspberry")),
            Ingredient(IngredientName.COTTON_CANDY, ingredientUrl("cotton_candy")),
            Ingredient(IngredientName.VANILLA, ingredientUrl("vanilla")),
            Ingredient(IngredientName.PISTACHIO, ingredientUrl("pistachio")),
            Ingredient(IngredientName.APPLE, ingredientUrl("apple")),
            Ingredient(IngredientName.APPLE_MANGO, ingredientUrl("apple_mango")),
            Ingredient(IngredientName.MILK_CREAM, ingredientUrl("milk_cream")),
            Ingredient(IngredientName.BUTTER_COOKIE, ingredientUrl("butter_cookie"))
        )

        private val flavors = listOf(
            Flavor("바람과 함께 사라지다", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("베리베리 스트로베리", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("피스타치오 아몬드", flavorUrl("icecream_octopus"), TASTE.NUTTY),
            Flavor("뉴욕 치즈케이크", flavorUrl("icecream_octopus"), TASTE.MILD),
            Flavor("초코나무 숲", flavorUrl("icecream_octopus"), TASTE.BITTER),
            Flavor("슈팅스타", flavorUrl("icecream_octopus"), TASTE.SHARP),
            Flavor("민트 초콜릿 칩", flavorUrl("icecream_octopus"), TASTE.SHARP),
            Flavor("아몬드 붕붕", flavorUrl("icecream_octopus"), TASTE.NUTTY),
            Flavor("오레오 쿠키 앤 크림치즈", flavorUrl("icecream_octopus"), TASTE.SWEET_SALTY),
            Flavor("엄마는 외계인", flavorUrl("icecream_octopus"), TASTE.SWEET_SALTY),
            Flavor("바닐라 아몬드 크런치", flavorUrl("icecream_octopus"), TASTE.NUTTY),
            Flavor("오레오 쿠키 앤 크림", flavorUrl("icecream_octopus"), TASTE.SWEET),
            Flavor("사랑에 빠진 딸기", flavorUrl("icecream_octopus"), TASTE.SWEET),
            Flavor("체리쥬빌레", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("바닐라", flavorUrl("icecream_octopus"), TASTE.MILD),
            Flavor("그린티", flavorUrl("icecream_octopus"), TASTE.BITTER),
            Flavor("31요거트", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("초콜릿", flavorUrl("icecream_octopus"), TASTE.SWEET),
            Flavor("이상한 나라의 솜사탕", flavorUrl("icecream_octopus"), TASTE.SHARP),
            Flavor("초콜릿 무스", flavorUrl("icecream_octopus"), TASTE.SWEET),
            Flavor("자모카 아몬드 훠지", flavorUrl("icecream_octopus"), TASTE.NUTTY),
            Flavor("레인보우 샤베트", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("레드 라즈베리 소르베", flavorUrl("icecream_octopus"), TASTE.SHARP),
            Flavor("디노 젤리", flavorUrl("icecream_octopus"), TASTE.FRUITY),
            Flavor("라이언 망고 마카롱", flavorUrl("icecream_octopus"), TASTE.SWEET),
            Flavor("프릳츠 커피 아이스크림", flavorUrl("icecream_octopus"), TASTE.BITTER),
            Flavor("초코야 민트해", flavorUrl("icecream_octopus"), TASTE.SHARP),
            Flavor("아이스 노티드 우유 생크림", flavorUrl("icecream_octopus"), TASTE.MILD),
            Flavor("초코 퐁당 쿠키런", flavorUrl("icecream_octopus"), TASTE.SWEET)
        )

        private fun ingredientUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/ingredients/$name.png"
        private fun flavorUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/flavors/$name.png"
    }
}
