package io.ggamnyang.quarter.main.domain.recipe

import io.ggamnyang.quarter.main.domain.flavor.Flavor
import io.ggamnyang.quarter.main.domain.size.Size
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
class Recipe(
    @Column(nullable = false)
    val name: String,

    @ManyToOne
    @JoinColumn(name = "size_id")
    val size: Size,

    @OneToMany(mappedBy = "recipe", fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    var recipeFlavorRelation: MutableList<RecipeFlavorRelation> = mutableListOf(),
    id: Long = 0L
) : BaseEntity(id) {

    fun getFlavors(): List<Flavor> {
        return this.recipeFlavorRelation.map { it.flavor }
    }

    private fun addFlavor(flavor: Flavor) {
        val recipeFlavorRelation = RecipeFlavorRelation(this, flavor)
        this.recipeFlavorRelation.add(recipeFlavorRelation)
    }

    fun addFlavors(flavors: List<Flavor>) {
        flavors.forEach { addFlavor(it) }
    }
}
