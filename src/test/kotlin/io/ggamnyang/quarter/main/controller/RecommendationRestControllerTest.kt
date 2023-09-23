package io.ggamnyang.quarter.main.controller

import com.ninjasquad.springmockk.MockkBean
import io.ggamnyang.quarter.main.domain.recommendation.RecommendationResponse
import io.ggamnyang.quarter.main.domain.recommendation.RecommendationService
import io.ggamnyang.quarter.main.support.fixtures.createRecommendation
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*
import org.springframework.test.web.servlet.get

@WebMvcTest(RecommendationRestController::class)
class RecommendationRestControllerTest : RestControllerTest() {
    @MockkBean
    private lateinit var recommendationService: RecommendationService

    @Test
    fun `모든 추천 조합을 조회한다`() {
        val recommendations = listOf(createRecommendation())
        val responses = recommendations.map { RecommendationResponse(it) }

        every { recommendationService.findAll() } returns responses

        mockMvc.get("/api/recommendations")
            .andExpect {
                status { isOk() }
                content { success(responses) }
            }.andDo {
                handle(document("recommendations-get"))
            }
    }
}
