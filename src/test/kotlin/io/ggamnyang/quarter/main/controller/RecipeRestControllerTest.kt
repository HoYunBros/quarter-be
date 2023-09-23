package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.recipe.PostRecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeService
import io.ggamnyang.quarter.main.support.fixtures.createRecipe
import io.ggamnyang.quarter.main.support.fixtures.createRecipeRequest
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@WebMvcTest(RecipeRestController::class)
class RecipeRestControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var recipeService: RecipeService

    @Test
    fun `조합을 만든다`() {
        val response = PostRecipeResponse(1L)

        every { recipeService.createRecipe(any()) } returns response

        mockMvc.post("/api/recipes") {
            jsonContent(createRecipeRequest())
        }
            .andExpect {
                status { isOk() }
                content { success(response) }
            }.andDo {
                handle(document("recipe-post"))
            }
    }

    @Test
    fun `RecipeId에 맞는 Recipe가 있다면 반환된다`() {
        val recipe = createRecipe(id = 1L)
        val response = RecipeResponse(recipe)

        every { recipeService.findById(any()) } returns response

        mockMvc.get("/api/recipes/{recipeId}", 1L)
            .andExpect {
                status { isOk() }
                content { success(response) }
            }.andDo {
                handle(document("recipe-get"))
            }
    }
}
