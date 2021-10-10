class Alignedtext {
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
        // code here
        return "0"
    }
}


fun main() {
    val alText = Alignedtext()
    println(alText.alignText("privet"))
}