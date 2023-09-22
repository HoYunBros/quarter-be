package io.ggamnyang.quarter.support

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelationRepository
import io.ggamnyang.quarter.main.domain.flavor.FlavorRepository
import io.ggamnyang.quarter.main.domain.flavor.TASTE
import io.ggamnyang.quarter.main.domain.flavor.getByName
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName.*
import io.ggamnyang.quarter.main.domain.ingredient.IngredientRepository
import io.ggamnyang.quarter.main.domain.ingredient.IngredientService
import io.ggamnyang.quarter.main.domain.ingredient.getByName
import io.ggamnyang.quarter.main.domain.size.Size
import io.ggamnyang.quarter.main.domain.size.SizeName
import io.ggamnyang.quarter.main.domain.size.SizeRepository
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class DatabaseInitializer(
    private val ingredientService: IngredientService,
    private val ingredientRepository: IngredientRepository,
    private val flavorRepository: FlavorRepository,
    private val flavorIngredientRelationRepository: FlavorIngredientRelationRepository,
    private val sizeRepository: SizeRepository
) {

    @PostConstruct
    fun initializeData() {
        initializeIngredients()
        initializeFlavors()
        initializeSizes()
        initializeFlavorIngredientRelations()
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

    private fun initializeSizes() {
        sizes.forEach { size ->
            sizeRepository.findByName(size.name) ?: sizeRepository.save(size)
        }
    }

    private fun initializeFlavorIngredientRelations() {
        saveIngredientRelations("바람과 함께 사라지다", BLUEBERRY, STRAWBERRY, CHEESE_CAKE)
        saveIngredientRelations("베리베리 스트로베리", STRAWBERRY)
        saveIngredientRelations("피스타치오 아몬드", PISTACHIO, ALMOND)
        saveIngredientRelations("뉴욕 치즈케이크", CHEESE_CAKE)
        saveIngredientRelations("초코나무 숲", CHOCOLATE, GREEN_TEA)
        saveIngredientRelations("슈팅스타", CHERRY)
        saveIngredientRelations("민트 초콜릿 칩", MINT, CHOCOLATE)
        saveIngredientRelations("아몬드 붕붕", CHOCOLATE, ALMOND)
        saveIngredientRelations("오레오 쿠키 앤 크림치즈", CHEESE_CAKE, OREO)
        saveIngredientRelations("엄마는 외계인", CHOCOLATE)
        saveIngredientRelations("바닐라 아몬드 크런치", ALMOND)
        saveIngredientRelations("오레오 쿠키 앤 크림", VANILLA, OREO)
        saveIngredientRelations("사랑에 빠진 딸기", CHOCOLATE, CHEESE_CAKE, STRAWBERRY)
        saveIngredientRelations("체리쥬빌레", CHERRY)
        saveIngredientRelations("바닐라", VANILLA)
        saveIngredientRelations("그린티", GREEN_TEA)
        saveIngredientRelations("31요거트", YOGURT)
        saveIngredientRelations("초콜릿", CHOCOLATE)
        saveIngredientRelations("이상한 나라의 솜사탕", COTTON_CANDY)
        saveIngredientRelations("초콜릿 무스", CHOCOLATE)
        saveIngredientRelations("자모카 아몬드 훠지", CHOCOLATE, COFFEE, ALMOND)
        saveIngredientRelations("레인보우 샤베트", PINEAPPLE, ORANGE, RASPBERRY)
        saveIngredientRelations("레드 라즈베리 소르베", RASPBERRY)
        saveIngredientRelations("디노 젤리", PINEAPPLE, APPLE)
        saveIngredientRelations("라이언 망고 마카롱", APPLE_MANGO)
        saveIngredientRelations("프릳츠 커피 아이스크림", COFFEE, CHOCOLATE)
        saveIngredientRelations("초코야 민트해", CHOCOLATE, MINT)
        saveIngredientRelations("아이스 노티드 우유 생크림", MILK_CREAM)
        saveIngredientRelations("초코 퐁당 쿠키런", CHOCOLATE, BUTTER_COOKIE)
    }

    private fun saveIngredientRelations(flavorName: String, vararg ingredientNames: IngredientName) {
        val flavor = flavorRepository.getByName(flavorName)
        val ingredients = ingredientNames.map { ingredientRepository.getByName(it) }

        ingredients.forEach { flavorIngredientRelationRepository.save(FlavorIngredientRelation(flavor, it)) }
    }

    companion object {
        private val ingredients = listOf(
            Ingredient(MINT, ingredientUrl("mint")),
            Ingredient(STRAWBERRY, ingredientUrl("strawberry")),
            Ingredient(CHOCOLATE, ingredientUrl("chocolate")),
            Ingredient(GREEN_TEA, ingredientUrl("green_tea")),
            Ingredient(CHEESE_CAKE, ingredientUrl("cheese_cake")),
            Ingredient(BLUEBERRY, ingredientUrl("blueberry")),
            Ingredient(YOGURT, ingredientUrl("yogurt")),
            Ingredient(COFFEE, ingredientUrl("coffee")),
            Ingredient(ALMOND, ingredientUrl("almond")),
            Ingredient(OREO, ingredientUrl("oreo")),
            Ingredient(CHERRY, ingredientUrl("cherry")),
            Ingredient(ORANGE, ingredientUrl("orange")),
            Ingredient(PINEAPPLE, ingredientUrl("pineapple")),
            Ingredient(RASPBERRY, ingredientUrl("raspberry")),
            Ingredient(COTTON_CANDY, ingredientUrl("cotton_candy")),
            Ingredient(VANILLA, ingredientUrl("vanilla")),
            Ingredient(PISTACHIO, ingredientUrl("pistachio")),
            Ingredient(APPLE, ingredientUrl("apple")),
            Ingredient(APPLE_MANGO, ingredientUrl("apple_mango")),
            Ingredient(MILK_CREAM, ingredientUrl("milk_cream")),
            Ingredient(BUTTER_COOKIE, ingredientUrl("butter_cookie"))
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

        private val sizes = listOf(
            Size(SizeName.SINGLE_REGULAR, 1, sizeUrl("single")),
            Size(SizeName.SINGLE_KING, 1, sizeUrl("single")),
            Size(SizeName.DOUBLE_JUNIOR, 2, sizeUrl("double")),
            Size(SizeName.DOUBLE_REGULAR, 2, sizeUrl("double")),
            Size(SizeName.PINT, 3, sizeUrl("pint")),
            Size(SizeName.QUARTER, 4, sizeUrl("quarter")),
            Size(SizeName.FAMILY, 5, sizeUrl("family")),
            Size(SizeName.HALF_GALLON, 6, sizeUrl("half_gallon"))
        )

        private fun ingredientUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/ingredients/$name.png"
        private fun flavorUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/flavors/$name.png"
        private fun sizeUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/sizes/$name.png"
    }
}
