package io.ggamnyang.quarter.support

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelationRepository
import io.ggamnyang.quarter.main.domain.flavor.FlavorRepository
import io.ggamnyang.quarter.main.domain.flavor.FlavorService
import io.ggamnyang.quarter.main.domain.flavor.TASTE
import io.ggamnyang.quarter.main.domain.flavor.getByName
import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName
import io.ggamnyang.quarter.main.domain.ingredient.IngredientName.*
import io.ggamnyang.quarter.main.domain.ingredient.IngredientRepository
import io.ggamnyang.quarter.main.domain.ingredient.IngredientService
import io.ggamnyang.quarter.main.domain.ingredient.getByName
import io.ggamnyang.quarter.main.domain.recipe.Recipe
import io.ggamnyang.quarter.main.domain.recipe.RecipeRepository
import io.ggamnyang.quarter.main.domain.recommendation.Recommendation
import io.ggamnyang.quarter.main.domain.recommendation.RecommendationRepository
import io.ggamnyang.quarter.main.domain.size.Size
import io.ggamnyang.quarter.main.domain.size.SizeName
import io.ggamnyang.quarter.main.domain.size.SizeRepository
import io.ggamnyang.quarter.main.domain.size.getByName
import jakarta.annotation.PostConstruct
import org.springframework.stereotype.Service

@Service
class DatabaseInitializer(
    private val ingredientRepository: IngredientRepository,
    private val ingredientService: IngredientService,
    private val flavorService: FlavorService,
    private val flavorRepository: FlavorRepository,
    private val flavorIngredientRelationRepository: FlavorIngredientRelationRepository,
    private val sizeRepository: SizeRepository,
    private val recipeRepository: RecipeRepository,
    private val recommendationRepository: RecommendationRepository
) {

    @PostConstruct
    fun initializeData() {
        initializeIngredients()
        initializeFlavors()
        initializeSizes()
        initializeFlavorIngredientRelations()
        initializeRecommendations()
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
        saveIngredientRelations("아몬드 봉봉", CHOCOLATE, ALMOND)
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
        saveIngredientRelations("찰떡이구마", MILK_CREAM)
        saveIngredientRelations("초코야 민트해", CHOCOLATE, MINT)
        saveIngredientRelations("아이스 노티드 우유 생크림", MILK_CREAM)
        saveIngredientRelations("초코 퐁당 쿠키런", CHOCOLATE, BUTTER_COOKIE)
    }

    private fun initializeRecommendations() {
        saveRecommendation(
            "호불호 없는 스테디셀러 조합",
            "여러명과 함께 먹을 때 추천해요. 누구나 좋아하는 맛으로 담았어요!",
            "steady_combination",
            SizeName.QUARTER,
            "엄마는 외계인",
            "뉴욕 치즈케이크",
            "바람과 함께 사라지다",
            "오레오 쿠키 앤 크림"
        )

        saveRecommendation(
            "이상해씨 조합",
            "기분 전환 하고 싶은 날 추천해요. 재밌는 추억이 될 거예요!",
            "bulbasaur_combination",
            SizeName.DOUBLE_REGULAR,
            "민트 초콜릿 칩",
            "그린티"
        )

        saveRecommendation(
            "씹는 재미가 있는 조합",
            "고소한 견과류, 촉촉한 과일로 더 풍부한 맛을 즐길 수 있어요.",
            "bite_combination",
            SizeName.PINT,
            "아몬드 봉봉",
            "사랑에 빠진 딸기",
            "디노 젤리"
        )

        saveRecommendation(
            "입안 난리 나는 조합", "개성 강한 맛들을 모았어요. 신선한 맛을 경험하고 싶다면 추천해요(벌칙 아님)", "sharp_combination",
            SizeName.FAMILY, "슈팅스타", "민트 초콜릿 칩", "피스타치오 아몬드", "레인보우 샤베트", "레드 라즈베리 소르베"
        )

        saveRecommendation(
            "식후땡! 입가심 조합", "밥 먹고 후식으로 입가심 하기 좋은 조합이에요. 이달의 맛이 포함되어 있으니 얼른 먹는 걸 추천해요.", "after_meal_combination",
            SizeName.HALF_GALLON, "오레오 쿠키 앤 크림", "베리베리 스트로베리", "31요거트", "초코 퐁당 쿠키런", "아이스 노티드 우유 생크림", "라이언 망고 마카롱"
        )
    }

    private fun saveRecommendation(title: String, subTitle: String, imageUrl: String, sizeName: SizeName, vararg flavorNames: String): Recommendation {
        val recipe = saveRecipe(title, sizeName, *flavorNames)
        val recommendation = Recommendation(title, subTitle, recommendationUrl(imageUrl), recipe)

        return recommendationRepository.save(recommendation)
    }

    private fun saveRecipe(recipeName: String, sizeName: SizeName, vararg flavorNames: String): Recipe {
        val recipe = Recipe(recipeName, sizeRepository.getByName(sizeName))
        val flavors = flavorNames.map { flavorService.getByName(it) }
        recipe.addFlavors(flavors)

        return recipe
    }

    private fun saveIngredientRelations(flavorName: String, vararg ingredientNames: IngredientName) {
        val flavor = flavorService.getByName(flavorName)
        val ingredients = ingredientNames.map { ingredientService.getByName(it) }

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
            Flavor("바람과 함께 사라지다", flavorUrl("disappear_with_wind"), TASTE.FRUITY),
            Flavor("베리베리 스트로베리", flavorUrl("very_berry"), TASTE.FRUITY),
            Flavor("피스타치오 아몬드", flavorUrl("pistachio_almond"), TASTE.NUTTY),
            Flavor("뉴욕 치즈케이크", flavorUrl("newyork_cheese"), TASTE.MILD),
            Flavor("초코나무 숲", flavorUrl("choco_forest"), TASTE.BITTER),
            Flavor("슈팅스타", flavorUrl("shooting_star"), TASTE.SHARP),
            Flavor("민트 초콜릿 칩", flavorUrl("mint_choco"), TASTE.SHARP),
            Flavor("아몬드 봉봉", flavorUrl("almond_bong"), TASTE.NUTTY),
            Flavor("오레오 쿠키 앤 크림치즈", flavorUrl("oreo_cheese"), TASTE.SWEET_SALTY),
            Flavor("엄마는 외계인", flavorUrl("mother_alien"), TASTE.SWEET_SALTY),
            Flavor("바닐라 아몬드 크런치", flavorUrl("vanilla_almond"), TASTE.NUTTY),
            Flavor("오레오 쿠키 앤 크림", flavorUrl("oreo_cream"), TASTE.SWEET),
            Flavor("사랑에 빠진 딸기", flavorUrl("love_with_strawberry"), TASTE.SWEET),
            Flavor("체리쥬빌레", flavorUrl("cherry_jubilee"), TASTE.FRUITY),
            Flavor("바닐라", flavorUrl("vanilla"), TASTE.MILD),
            Flavor("그린티", flavorUrl("greentea"), TASTE.BITTER),
            Flavor("31요거트", flavorUrl("yogurt"), TASTE.FRUITY),
            Flavor("초콜릿", flavorUrl("chocolate"), TASTE.SWEET),
            Flavor("이상한 나라의 솜사탕", flavorUrl("weird_cotton_candy"), TASTE.SHARP),
            Flavor("초콜릿 무스", flavorUrl("chocolate_mousse"), TASTE.SWEET),
            Flavor("자모카 아몬드 훠지", flavorUrl("jamoca_almond"), TASTE.NUTTY),
            Flavor("레인보우 샤베트", flavorUrl("rainbow"), TASTE.FRUITY),
            Flavor("레드 라즈베리 소르베", flavorUrl("red_raspberry_sorbet"), TASTE.SHARP),
            Flavor("디노 젤리", flavorUrl("dino_jelly"), TASTE.FRUITY),
            Flavor("라이언 망고 마카롱", flavorUrl("lion_mango"), TASTE.SWEET),
            Flavor("찰떡이구마", flavorUrl("perfect_sweet_potato"), TASTE.SWEET),
            Flavor("초코야 민트해", flavorUrl("choco_mint"), TASTE.SHARP),
            Flavor("아이스 노티드 우유 생크림", flavorUrl("ice_knotted_milk"), TASTE.MILD),
            Flavor("초코 퐁당 쿠키런", flavorUrl("choco_cookierun"), TASTE.SWEET)
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
        private fun flavorUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/flavors/$name.svg"
        private fun sizeUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/sizes/$name.svg"
        private fun recommendationUrl(name: String) = "https://kr.object.ncloudstorage.com/best-robbins/recommendations/$name.svg"
    }
}
