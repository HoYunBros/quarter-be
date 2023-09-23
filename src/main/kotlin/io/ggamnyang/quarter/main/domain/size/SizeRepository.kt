package io.ggamnyang.quarter.main.domain.size

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

fun SizeRepository.getByIdNotNull(id: Long) = findByIdOrNull(id)
    ?: throw NoSuchElementException("$id 에 해당하는 Size가 없습니다.")

fun SizeRepository.getByName(name: SizeName) = findByName(name)
    ?: throw NoSuchElementException("$name 에 해당하는 Size가 없습니다.")

@Repository
interface SizeRepository : JpaRepository<Size, Long> {

    fun findByName(name: SizeName): Size?
}
