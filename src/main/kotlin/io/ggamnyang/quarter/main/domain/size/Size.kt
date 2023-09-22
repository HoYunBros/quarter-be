package io.ggamnyang.quarter.main.domain.size

import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated

@Entity
class Size(
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val name: SizeName,

    @Column(nullable = false)
    val value: Int,

    @Column(nullable = false)
    val imageUrl: String,

    id: Long = 0L
) : BaseEntity(id)
