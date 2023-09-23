package io.ggamnyang.quarter.main.domain.flavor

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class FlavorService(
    private val flavorRepository: FlavorRepository
) {
    @Cacheable(value = ["allFlavors"], key = "'all'")
    fun findAll(): List<Flavor> {
        return flavorRepository.findAll()
    }

    @Cacheable(value = ["flavor"], key = "#name")
    fun getByName(name: String): Flavor {
        return flavorRepository.findAll().find { it.name == name } ?: throw NoSuchElementException("$name Flavor가 존재하지 않습니다.")
    }

    fun findFlavorsByIngredientIds(ingredientIds: List<Long>): List<Flavor> {
        val allFlavors = findAll()

        return allFlavors.filter { flavor ->
            flavor.flavorIngredientRelation.any { fi -> fi.ingredient.id in ingredientIds }
        }
    }
}
