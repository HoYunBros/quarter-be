package io.ggamnyang.quarter.main.domain.user

data class UserResponse(
    val id: Long,
    val name: String,
    val email: String
) {
    constructor(user: User) : this(
        user.id,
        user.name,
        user.email
    )
}

data class UserRequest(
    val name: String
)
