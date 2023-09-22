package io.ggamnyang.quarter.main.domain.recipe

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class Recipe(
    @Column(nullable = false)
    val name: String,

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY)
    val recipeFlavorRelation: List<RecipeFlavorRelation>,
    id: Long = 0L
) : BaseEntity(id) {

    fun getFlavors(): List<Flavor> {
        return this.recipeFlavorRelation.map { it.flavor }
    }
}
