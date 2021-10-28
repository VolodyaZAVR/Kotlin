class AlignedText {
    enum class Alignment {
        LEFT,
        RIGHT,
        CENTER,
        JUSTIFY
    }

    fun alignText(
        text: String,
        lineWidth: Int = 120,
        alignment: Alignment = Alignment.LEFT
    ): String {
        return when (alignment) {
            Alignment.LEFT -> alightTextLeft(text, lineWidth)
            Alignment.RIGHT -> alightTextRight(text, lineWidth)
            Alignment.CENTER -> alightTextCenter(text, lineWidth)
            Alignment.JUSTIFY -> alightTextJustify(text, lineWidth)
        }
    }

    private fun alightTextLeft(
        text: String,
        lineWidth: Int = 120
    ): String {
        TODO("implement left alight")
    }

    private fun alightTextRight(
        text: String,
        lineWidth: Int = 120
    ): String {
        return "not realized"
    }

    private fun alightTextCenter(
        text: String,
        lineWidth: Int = 120
    ): String {
        return "not realized"
    }

    private fun alightTextJustify(
        text: String,
        lineWidth: Int = 120
    ): String {
        return "not realized"
    }
}


fun main() {
    val text = "Text for format"
    val alText = AlignedText()
    println(alText.alignText(text, 140, AlignedText.Alignment.LEFT))
}