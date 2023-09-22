package io.ggamnyang.quarter.main.domain.size

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SizeRepository : JpaRepository<Size, Long> {

    fun findByName(name: SizeName): Size?
}
