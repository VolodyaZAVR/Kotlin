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
        lineWidth: Int
    ): String {
        if (text.isBlank()) return ""
        var resultText: String = ""
        var currLength: Int = 0
        val listValues: List<String> = text.split(" ").map { it.trim() }
        for (item in listValues) {
            if ((item.length + currLength) > lineWidth) {
                if (item.length > lineWidth) {
                    resultText = resultText.plus("\n")
                    currLength = 0
                    val charArr: CharArray = item.toCharArray()
                    for (c in charArr) {
                        if (currLength < lineWidth) {
                            resultText = resultText.plus(c)
                            currLength += 1
                        } else {
                            resultText = resultText.plus("\n")
                            resultText = resultText.plus(c)
                            currLength = 1
                        }
                    }
                } else {
                    resultText = resultText.plus("\n")
                    resultText = resultText.plus(item)
                    currLength = item.length
                }
            } else {
                resultText = resultText.plus(item)
                currLength += item.length
            }
            if (currLength == lineWidth) {
                resultText = resultText.plus("S")
                resultText = resultText.plus("\n")
                currLength = 1
            } else {
                resultText = resultText.plus("S")
                currLength += 1
            }
        }
        return resultText
    }

    private fun alightTextRight(
        text: String,
        lineWidth: Int
    ): String {
        return "not realized"
    }

    private fun alightTextCenter(
        text: String,
        lineWidth: Int
    ): String {
        return "not realized"
    }

    private fun alightTextJustify(
        text: String,
        lineWidth: Int
    ): String {
        return "not realized"
    }
}


fun main() {
    val text = "..... ...... ............ ................../"
    val alText = AlignedText()
    println(alText.alignText(text, 10, AlignedText.Alignment.LEFT))
}