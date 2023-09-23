package io.ggamnyang.quarter.main.domain.recipe

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

fun RecipeRepository.getByIdNotNull(id: Long) = findByIdOrNull(id)
    ?: throw NoSuchElementException("$id 에 해당하는 id의 Recipe가 없습니다.")

@Repository
interface RecipeRepository : JpaRepository<Recipe, Long>
