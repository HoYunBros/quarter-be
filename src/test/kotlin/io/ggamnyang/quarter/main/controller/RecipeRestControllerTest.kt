package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.recipe.PostRecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeService
import io.ggamnyang.quarter.main.support.fixtures.createRecipeRequest
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

        mockMvc.post("/api/recipes") {
            jsonContent(createRecipeRequest(listOf(1, 2, 3)))
        }
            .andExpect {
                status { isOk() }
                content { success(response) }
            }.andDo {
                handle(document("recipe-post"))
            }
    }
}
