package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.recipe.PostRecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeRequest
import io.ggamnyang.quarter.main.domain.recipe.RecipeResponse
import io.ggamnyang.quarter.main.domain.recipe.RecipeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
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
    fun createRecipe(
        @RequestBody request: RecipeRequest
    ): ResponseEntity<ApiResponse<PostRecipeResponse>> {
        val response = recipeService.createRecipe(request)

        return ResponseEntity.ok(ApiResponse.success(response))
    }

    @GetMapping("{recipeId}")
    fun findRecipe(
        @PathVariable recipeId: Long
    ): ResponseEntity<ApiResponse<RecipeResponse>> {
        val response = recipeService.findById(recipeId)

        return ResponseEntity.ok(ApiResponse.success(response))
    }
}
