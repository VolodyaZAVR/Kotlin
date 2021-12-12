package calc

class Calculator {
    private fun getPriority(operator: String): Int {
        return when (operator) {
            "+", "-" -> 1
            "*", "/" -> 2
            "^" -> 3
            else -> 0
        }
    }

    fun calculate(input: String): Double {
        if (Parser().isCorrectExpression(input)) {
            val listOfElements = getListOfElements(input)
            val expression = makeExpression(listOfElements)
            return getResult(expression)
        } else
            throw IllegalArgumentException("Incorrect expression!")
    }

    private fun getListOfElements(str: String): Pair<String, String>? {
        return null
    }

    private fun makeExpression(p: Pair<String, String>?): MutableList<Pair<String, String>>? {
        return null
    }

    private fun getResult(expr: MutableList<Pair<String, String>>?): Double {
        return 0.0
    }

}