package Matrix

class Matrix(private var matrixElements: Array<Array<Double>>) {
    private var matrix: Array<Array<Double>> = emptyArray()

    private val rows: Int
        get() {
            return matrix.size
        }

    private val columns: Int
        get() {
            return matrix[0].size
        }

    init {
        if (matrixElements.isEmpty() || matrixElements[0].isEmpty())
            throw IllegalArgumentException("Error. Empty Matrix")
        val size = matrixElements[0].size
        for (i in matrixElements)
            if (i.size != size) throw IllegalArgumentException("Error. Incorrect dimensions of the matrix.")
        matrix = Array(matrixElements.size) { Array(matrixElements[0].size) { 0.0 } }
        for (i in matrixElements.indices)
            for (j in matrixElements[0].indices)
                matrix[i][j] = matrixElements[i][j]
    }

    operator fun plus(other: Matrix): Matrix {
        TODO("Not yet implemented")
    }

    operator fun plusAssign(other: Matrix) {
        TODO("Not yet implemented")
    }

    operator fun times(scalar: Double) {
        TODO("Not yet implemented")
    }

    operator fun timesAssign(scalar: Double) {
        TODO("Not yet implemented")
    }

    operator fun set(i: Int, j: Int, value: Double) {
        TODO("Not yet implemented")
    }

    operator fun get(i: Int, j: Int): Double {
        TODO("Not yet implemented")
    }

    operator fun unaryMinus(): Matrix {
        TODO("Not yet implemented")
    }

    operator fun unaryPlus(): Matrix {
        return this
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }

    override fun toString(): String {
        return "Matrix(matrix=${matrix.contentToString()})"
    }
}

