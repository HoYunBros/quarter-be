package io.ggamnyang.quarter.main.controller

import io.ggamnyang.quarter.main.domain.user.UserResponse
import io.ggamnyang.quarter.main.domain.user.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class UserRestController(
    private val userService: UserService
) {
    @GetMapping("/me")
    fun getMyInformation(): ResponseEntity<ApiResponse<UserResponse>> {
        val tempId = 0L
        val response = userService.getInformation(tempId)
        return ResponseEntity.ok(ApiResponse.success(response))
    }
}
