package io.ggamnyang.quarter.main.domain.ingredient

import io.ggamnyang.quarter.main.domain.flavor.FlavorIngredientRelation
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.OneToMany

@Entity
class Ingredient(
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val name: IngredientName,

    @Column(nullable = false)
    val imageUrl: String,

    @OneToMany(mappedBy = "ingredient", fetch = FetchType.LAZY)
    val flavorIngredientRelation: List<FlavorIngredientRelation> = emptyList(),

    id: Long = 0L
) : BaseEntity(id) {
    fun getFlavorIds(): List<Long> = this.flavorIngredientRelation.map { it.flavor.id }
}
