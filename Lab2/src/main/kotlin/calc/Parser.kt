package calc

class Parser {
    private val tokens: List<Char> = listOf(
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '(', ')', '+', '-', '*', '/', '^'
    )

    fun isCorrectExpression(input: String): Boolean {
        val expr = input.replace(" ", "")
        var bracketsCount = 0
        if (expr.isBlank())
            throw IllegalArgumentException("Incorrect expression!")
        for (item in expr) {
            if (!tokens.contains(item)) {
                throw IllegalArgumentException("The expression contains an invalid character.")
            }
            if (item == '(')
                bracketsCount++
            if (item == ')' && bracketsCount == 0)
                throw IllegalArgumentException("Incorrect expression!")
            if (item == ')')
                bracketsCount--
        }
        return true
    }
}