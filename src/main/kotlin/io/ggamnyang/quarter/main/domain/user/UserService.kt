package io.ggamnyang.quarter.main.domain.user

import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun getInformation(id: Long): UserResponse {
        val user = userRepository.getByIdNotNull(id)
        return UserResponse(user)
    }
}
