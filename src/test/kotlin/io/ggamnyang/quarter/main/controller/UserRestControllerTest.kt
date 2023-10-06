package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.user.UserResponse
import io.ggamnyang.quarter.main.domain.user.UserService
import io.ggamnyang.quarter.main.support.fixtures.createUser
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.test.web.servlet.get

@WebMvcTest(UserRestController::class)
class UserRestControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var userService: UserService

    @Test
    fun `본인의 유저 정보를 조회할 수 있다`() {
        val response = UserResponse(createUser())

        every { userService.getInformation(any()) } returns response

        mockMvc.get("/api/users/me")
            .andExpect {
                status { isOk() }
                content { success(response) }
            }.andDo {
                handle(document("users-me-get"))
            }
    }
}
