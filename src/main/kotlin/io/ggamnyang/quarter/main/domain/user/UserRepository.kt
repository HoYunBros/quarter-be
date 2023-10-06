package io.ggamnyang.quarter.main.domain.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

fun UserRepository.getByIdNotNull(id: Long): User = findByIdOrNull(id)
    ?: throw NoSuchElementException("아이디 $id 에 해당하는 User가 없습니다.")

@Repository
interface UserRepository : JpaRepository<User, Long>
