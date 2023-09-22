package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.size.Size
import io.ggamnyang.quarter.main.domain.size.SizeName
import io.ggamnyang.quarter.main.domain.size.SizeResponse

private val SIZE_NAME = SizeName.PINT
private const val SIZE_VALUE = 3
private const val SIZE_IMAGE_URL = "www.url.com"

fun createSize(
    name: SizeName = SIZE_NAME,
    value: Int = SIZE_VALUE,
    imageUrl: String = SIZE_IMAGE_URL,
    id: Long = 0L
): Size {
    return Size(name, value, imageUrl, id)
}

fun createSizeResponse(
    size: Size
): SizeResponse {
    return SizeResponse(size)
}
