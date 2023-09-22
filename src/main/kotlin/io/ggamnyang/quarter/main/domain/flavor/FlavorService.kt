package io.ggamnyang.quarter.main.domain.flavor

import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class FlavorService(
    private val flavorRepository: FlavorRepository
) {

    @Cacheable(value = ["flavor"], key = "#name")
    fun getByName(name: String): Flavor {
        return flavorRepository.findByName(name) ?: throw IllegalArgumentException("$name 해당하는 Flavor가 없습니다")
    }
}
