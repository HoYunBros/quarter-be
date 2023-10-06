package io.ggamnyang.quarter.main.support.fixtures

import io.ggamnyang.quarter.main.domain.user.User

const val NAME: String = "유저"
const val EMAIL: String = "user@email.com"

fun createUser(
    name: String = NAME,
    email: String = EMAIL,
    id: Long = 0L
): User {
    return User(name, email, id)
}
