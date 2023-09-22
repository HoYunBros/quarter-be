package io.ggamnyang.quarter.main.domain.ingredient

import io.ggamnyang.quarter.main.support.fixtures.createIngredient
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk

class IngredientServiceTest : BehaviorSpec({

    afterTest { clearAllMocks() }
    val ingredientRepository = mockk<IngredientRepository>()

    val ingredientService = IngredientService(ingredientRepository)

    Given("재료가 저장된 경우") {
        val ingredients = listOf(createIngredient(), createIngredient())

        When("모든 재료 조회를 한번하면") {
            every { ingredientRepository.findAll() } returns ingredients
            val actual = ingredientService.findAll()
            val expect = ingredients.map { IngredientResponse(it) }

            Then("모든 재료가 반환된다.") {
                actual shouldBe expect
            }
        }
    }
})
