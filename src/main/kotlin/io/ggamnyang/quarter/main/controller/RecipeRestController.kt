package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.recipe.PostRecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeRequest
import io.ggamnyang.quarter.main.domain.recipe.RecipeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/recipes")
class RecipeRestController(
    private val recipeService: RecipeService
) {

    @PostMapping
    fun findOrCreateRecipe(
        @RequestBody request: RecipeRequest
    ): ResponseEntity<ApiResponse<PostRecipeResponse>> {
        // FIXME: FIX
        return ResponseEntity.ok(ApiResponse.success(PostRecipeResponse(1L)))
    }
}
