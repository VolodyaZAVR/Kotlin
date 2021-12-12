package calc

class Parser {
    fun isCorrectExpression(input : String) : Boolean{
        val expr = input.replace(" ", "")
        if (expr.isBlank())
            throw IllegalArgumentException("Incorrect expression!")
        // TODO("доделать проверку выражения на корректность")
        return true
    }
}