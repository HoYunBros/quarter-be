package io.ggamnyang.quarter.main.domain.size

data class SizeResponse(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val value: Int
) {
    constructor(size: Size) : this(
        size.id,
        size.name.kr,
        size.imageUrl,
        size.value
    )
}
