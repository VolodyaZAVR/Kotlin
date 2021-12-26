package textAlign

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
        if (lineWidth < 1)
            throw IllegalArgumentException("Invalid argument. String length can't be less than 1.")
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
        var currLength: Int // current line length of aligned text
        val listStrings: List<String> = text.split("\n").map { it.trim() }  // splitting the text into lines
        for (str in listStrings) { // passing through the list of strings
            if (resultText != "") // adding a line break if we are not at the first step
                resultText += "\n"
            currLength = 0 // zeroing the variable length of the current string
            val listValues: List<String> = str.split(" ").map { it.trim() } // splitting the text into words
            for (item in listValues) { // passing through the list of words
                if (currLength != 0) { // checking for hyphenation after inserting a word into the aligned text
                    if (currLength == lineWidth) {
                        resultText = resultText.plus(" ")
                        resultText = resultText.plus("\n")
                        currLength = 0
                    } else { // if you don't need to do a transfer, then a space
                        resultText = resultText.plus(" ")
                        currLength += 1
                    }
                }
                if ((item.length + currLength) > lineWidth) { // checking that the word and the current text do not fit into the line limit
                    if (item.length > lineWidth) { // checking if the word itself is longer than the length of the string
                        resultText = resultText.plus("\n") // word transposition (so does word)
                        currLength = 0
                        val charArr: CharArray = item.toCharArray()
                        for (c in charArr) { // character - by - character passage by word
                            if (currLength < lineWidth) { // if you haven't reached the limit by character
                                resultText = resultText.plus(c)
                                currLength += 1
                            } else { // transfer if you have reached the limit
                                resultText = resultText.plus("\n")
                                resultText = resultText.plus(c)
                                currLength = 1
                            }
                        }
                    } else { // if the word does not fit, but it is no longer than the length of the string
                        resultText = resultText.plus("\n")
                        resultText = resultText.plus(item)
                        currLength = item.length
                    }
                } else { // insert a word if it fits in a string
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
        var result: String = alightTextLeft(text, lineWidth) // fitting text into the size of the line
        val listStrings: List<String> = result.split("\n") // splitting text into lines
        result = ""
        for (str in listStrings) { // passing through the list of lines
            if (result != "") result += "\n"
            for (i in str.length..lineWidth - 1) // add the required number of spaces to the left
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
        var result: String = alightTextLeft(text, lineWidth) // fitting text into the size of the line
        val listStrings: List<String> = result.split("\n") // splitting text into lines
        result = ""
        for (str in listStrings) { // passing through the list of lines
            if (result != "") result += "\n"
            for (i in 1..(lineWidth - str.length) / 2) // add the required number of spaces on the left
                reserveLine += " "
            result = result + reserveLine + str
            reserveLine = ""
        }
        return result
    }
}
