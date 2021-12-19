package TextAlign

class AlignedText {
    enum class Alignment {
        LEFT,
        RIGHT,
        CENTER
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
        }
    }

    private fun alightTextLeft(
        text: String,
        lineWidth: Int = 120
    ): String {
        if (text.isBlank()) return ""
        var resultText = ""
        var currLength: Int // текущая длина строки выравненного текста
        val listStrings: List<String> = text.split("\n").map { it.trim() }  // разбиваем текст на строки
        for (str in listStrings) { // проходим по списку строк
            if (resultText != "") //добавляем перенос стоки если мы не на первом шаге
                resultText += "\n"
            currLength = 0 //обнуляем переменную длины текущей строки
            val listValues: List<String> = str.split(" ").map { it.trim() } // разбиваем текст на слова
            for (item in listValues) { // проходим по списку слов
                if (currLength != 0) { // проверка на перенос после вставки слова в выравненный текст
                    if (currLength == lineWidth) {
                        resultText = resultText.plus(" ")
                        resultText = resultText.plus("\n")
                        currLength = 0
                    } else { // если перенос делать не нужно - то пробел
                        resultText = resultText.plus(" ")
                        currLength += 1
                    }
                }
                if ((item.length + currLength) > lineWidth) { // проверка на то, что слово и текущий текст не помещаются в предел строки
                    if (item.length > lineWidth) { // проверка если само слово больше длины строки
                        resultText = resultText.plus("\n") // переносим слово (так делает word)
                        currLength = 0
                        val charArr: CharArray = item.toCharArray()
                        for (c in charArr) { // проходим посимвольно по слову
                            if (currLength < lineWidth) { // если посимвольно не достигли предела
                                resultText = resultText.plus(c)
                                currLength += 1
                            } else { // перенос, если достигли предела
                                resultText = resultText.plus("\n")
                                resultText = resultText.plus(c)
                                currLength = 1
                            }
                        }
                    } else { // если слово не помещается, но оно не больше длины строки
                        resultText = resultText.plus("\n")
                        resultText = resultText.plus(item)
                        currLength = item.length
                    }
                } else { // вставляем слово, если оно помещается в строку
                    resultText = resultText.plus(item)
                    currLength += item.length
                }
            }
        }
        return resultText
    }

    private fun alightTextRight(
        text: String,
        lineWidth: Int = 120
    ): String {
        var reserveLine = ""
        if (text.isBlank()) return ""
        var result: String = alightTextLeft(text, lineWidth)//загоняем текст в рамки размера строки
        val listStrings: List<String> = result.split("\n") // разбиваем текст на строки
        result = ""
        for (str in listStrings) { // проходим по списку строк
            if (result != "") result += "\n"
            for (i in str.length..lineWidth - 1) //добавляем нужное число пробелов влево
                reserveLine += " "
            result = result + reserveLine + str
            reserveLine = ""
        }
        return result
    }

    private fun alightTextCenter(
        text: String,
        lineWidth: Int = 120
    ): String {
        var reserveLine = ""
        if (text.isBlank()) return ""
        var result: String = alightTextLeft(text, lineWidth)//загоняем текст в рамки размера строки
        val listStrings: List<String> = result.split("\n") // разбиваем текст на строки
        result = ""
        for (str in listStrings) { // проходим по списку строк
            if (result != "") result += "\n"
            for (i in 1..(lineWidth - str.length) / 2) //добавляем нужное число пробелов влево
                reserveLine += " "
            result = result + reserveLine + str
            reserveLine = ""
        }
        return result
    }
}
