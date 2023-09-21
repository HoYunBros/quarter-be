package io.ggamnyang.quarter.main.domain.flavor

import io.ggamnyang.quarter.main.domain.recipe.RecipeFlavorRelation
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class Flavor(
    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val imageUrl: String,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val taste: TASTE,

    @OneToMany(mappedBy = "flavor", fetch = FetchType.LAZY)
    val flavorIngredientRelation: List<FlavorIngredientRelation>,

    @OneToMany(mappedBy = "flavor", fetch = FetchType.LAZY)
    val recipeFlavorRelation: List<RecipeFlavorRelation>,
    id: Long = 0L
) : BaseEntity(id)
