package io.ggamnyang.quarter.main.domain.user

import io.ggamnyang.quarter.support.domain.BaseEntity
import jakarta.persistence.Embedded
import jakarta.persistence.Entity

@Entity
class User(
    @Embedded
    val information: UserInformation,

    id: Long = 0L
) : BaseEntity(id) {
    val name: String
        get() = information.name

    val email: String
        get() = information.email

    constructor(
        name: String,
        email: String,
        id: Long = 0L
    ) : this(
        UserInformation(name, email),
        id
    )
}
