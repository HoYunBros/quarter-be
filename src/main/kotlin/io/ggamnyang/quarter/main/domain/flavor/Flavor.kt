package io.ggamnyang.quarter.main.domain.flavor

import io.ggamnyang.quarter.main.domain.recipe.RecipeFlavorRelation
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.CascadeType
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

    @OneToMany(mappedBy = "flavor", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    val flavorIngredientRelation: Set<FlavorIngredientRelation> = hashSetOf(),

    @OneToMany(mappedBy = "flavor", fetch = FetchType.LAZY)
    val recipeFlavorRelation: MutableSet<RecipeFlavorRelation> = hashSetOf(),
    id: Long = 0L
) : BaseEntity(id)
