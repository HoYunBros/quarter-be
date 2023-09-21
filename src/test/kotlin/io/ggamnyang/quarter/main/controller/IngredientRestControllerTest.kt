package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.ingredient.IngredientResponse
import io.ggamnyang.quarter.main.domain.ingredient.IngredientService
import io.ggamnyang.quarter.main.support.fixtures.createIngredient
import io.mockk.every
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.test.web.servlet.get

@WebMvcTest(IngredientRestController::class)
class IngredientRestControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var ingredientService: IngredientService

    @Test
    fun `모든 재료를 조회한다`() {
        val ingredients = listOf(createIngredient(), createIngredient())
        val responses = ingredients.map { IngredientResponse(it) }

        every { ingredientService.findAll() } returns responses

        mockMvc.get("/api/ingredients")
            .andExpect {
                status { isOk() }
                content { success(responses) }
            }.andDo {
                handle(document("ingredient-get"))
            }
    }
}
