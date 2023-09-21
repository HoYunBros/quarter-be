package io.ggamnyang.quarter.main.domain.flavor

import io.ggamnyang.quarter.main.domain.ingredient.Ingredient
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class FlavorIngredientRelation(
    @ManyToOne
    @JoinColumn(name = "flavor_id")
    val flavor: Flavor,

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    val ingredient: Ingredient,

    id: Long = 0L
) : BaseEntity(id)
