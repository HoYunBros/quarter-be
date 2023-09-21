package io.ggamnyang.quarter.main.domain.recipe

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity
class RecipeFlavorRelation(
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    val recipe: Recipe,

    @ManyToOne
    @JoinColumn(name = "flavor_id")
    val flavor: Flavor,

    id: Long = 0L
) : BaseEntity(id)
