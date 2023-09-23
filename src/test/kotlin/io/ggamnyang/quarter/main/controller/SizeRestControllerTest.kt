package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.size.SizeResponse
import io.ggamnyang.quarter.main.domain.size.SizeService
import io.ggamnyang.quarter.main.support.fixtures.createSize
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.test.web.servlet.get

@WebMvcTest(SizeRestController::class)
class SizeRestControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var sizeService: SizeService

    @Test
    fun `모든 사이즈를 조회한다`() {
        val sizes = listOf(createSize(), createSize())
        val responses = sizes.map { SizeResponse(it) }

        every { sizeService.findAll() } returns responses

        mockMvc.get("/api/sizes")
            .andExpect {
                status { isOk() }
                content { success(responses) }
            }.andDo {
                handle(document("sizes-get"))
            }
    }
}
