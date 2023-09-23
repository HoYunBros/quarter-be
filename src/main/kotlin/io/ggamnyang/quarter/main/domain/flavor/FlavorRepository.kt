package io.ggamnyang.quarter.main.domain.flavor

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

fun FlavorRepository.getByName(name: String) = findByName(name)
    ?: throw IllegalArgumentException("$name 해당하는 재료가 없습니다")

@Repository
interface FlavorRepository : JpaRepository<Flavor, Long> {
    fun findByName(name: String): Flavor?
}
