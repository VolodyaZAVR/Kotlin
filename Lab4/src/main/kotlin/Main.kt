import matrix.Matrix
fun main() {
    val array1 = arrayOf(
        arrayOf(1.0, 2.0, 3.0),
        arrayOf(1.0, 2.0, 3.0),
        arrayOf(1.0, 2.0, 3.0)
    )
    val array2 = arrayOf(
        arrayOf(1.0, 2.0, 2.0),
        arrayOf(1.0, 2.0, 2.0),
        arrayOf(1.0, 2.0, 2.0)
    )
    val matrix1 = Matrix(array1)
    val matrix2 = Matrix(array2)
    println("Matrix:\n$matrix1")

    var resultMatrix = matrix1.unaryMinus()
    println("Unary minus:\n$resultMatrix")

    resultMatrix = matrix1.plus(matrix2)
    println("Plus:\n$matrix1+\n$matrix2=\n$resultMatrix")

    resultMatrix = matrix1.minus(matrix2)
    println("Minus:\n$matrix1-\n$matrix2=\n$resultMatrix")

    resultMatrix = matrix1.times(matrix2)
    println("Times:\n$matrix1*\n$matrix2=\n$resultMatrix")

    resultMatrix = matrix1.times(10.0)
    println("Times 10:\n$resultMatrix")

    resultMatrix = matrix1.div(2.0)
    println("Div 2:\n$resultMatrix")
}
