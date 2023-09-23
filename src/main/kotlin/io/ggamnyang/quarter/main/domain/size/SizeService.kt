package io.ggamnyang.quarter.main.domain.size

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class SizeService(
    private val sizeRepository: SizeRepository
) {
    @Cacheable(value = ["allSizes"], key = "'all'")
    fun findAll(): List<SizeResponse> {
        val sizes = sizeRepository.findAll()

        return sizes.map { SizeResponse(it) }
    }
}
