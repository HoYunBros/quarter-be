package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.ingredient.IngredientResponse
import io.ggamnyang.quarter.main.domain.ingredient.IngredientService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/ingredients")
class IngredientRestController(
    private val ingredientService: IngredientService
) {

    @GetMapping
    fun findAll(): ResponseEntity<ApiResponse<List<IngredientResponse>>> {
        val response = ingredientService.findAll()
        return ResponseEntity.ok(ApiResponse.success(response))
    }
}
