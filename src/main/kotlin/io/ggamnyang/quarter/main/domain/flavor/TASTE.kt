package io.ggamnyang.quarter.main.domain.flavor

enum class TASTE(val kr: String) {
    SWEET("달달한"),
    FRUITY("상큼한"),
    NUTTY("고소한"),
    MILD("부드러운"),
    SWEET_SALTY("단짠단짠"),
    SHARP("톡쏘는"),
    BITTER("씁쓸한");

    companion object {
        fun countTastes(tastes: List<TASTE>): Map<TASTE, Int> {
            return tastes.groupingBy { it }.eachCount()
        }

        fun tasteToRecipeName(taste: TASTE, isPlural: Boolean): String {
            if (isPlural) return PLURAL
            return when (taste) {
                SWEET -> "당 충전 제.대.로!"
                FRUITY -> "비타민C 충전! 새콤달콤 조합"
                NUTTY -> "입 안 가득 퍼지는 고소한 매력"
                MILD -> "에스프레소와 함께 먹기 좋은 부드러운 조합"
                SWEET_SALTY -> "끝없이 들어가는 단짠의 매력"
                SHARP -> "나른함을 날려버릴 한 방!"
                BITTER -> "달콤씁쓸! 끝까지 질리지 않는 맛"
            }
        }

        private const val PLURAL = "서로 달라 보여도, 제법 잘 어울려요"
    }
}
