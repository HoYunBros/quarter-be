package io.ggamnyang.quarter.main.domain.user

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class UserInformation(
    @Column(nullable = false)
    val name: String,

    @Column(unique = true, nullable = false)
    val email: String
)
