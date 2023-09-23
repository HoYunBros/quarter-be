package io.ggamnyang.quarter.main.domain.recommendation

import io.ggamnyang.quarter.main.domain.recipe.Recipe
import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
class Recommendation(
    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val subTitle: String,

    @Column(nullable = false)
    val imageUrl: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "recipe_id")
    val recipe: Recipe,
    id: Long = 0L
) : BaseEntity(id)
