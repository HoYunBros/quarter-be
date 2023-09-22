package io.ggamnyang.quarter.main.domain.flavor

data class FlavorResponse(
    val id: Long,
    val name: String,
    val imageUrl: String
) {
    constructor(flavor: Flavor) : this(
        flavor.id,
        flavor.name,
        flavor.imageUrl
    )
}
