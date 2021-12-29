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
        if (this.rows != other.rows || this.columns != other.columns)
            throw IllegalArgumentException("Error. It is impossible to add matrices of different sizes.")
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                resultMatrix[i][j] = this[i, j] + other[i, j]
        return Matrix(resultMatrix)
    }

    operator fun minus(other: Matrix): Matrix {
        if (this.rows != other.rows || this.columns != other.columns)
            throw IllegalArgumentException("Error. It is impossible to subtract matrices of different sizes.")
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                resultMatrix[i][j] = this[i, j] - other[i, j]
        return Matrix(resultMatrix)
    }

    operator fun times(other: Matrix): Matrix {
        if (this.columns != other.rows)
            throw IllegalArgumentException("Error. The number of columns of the first matrix does not match the number of rows of the second matrix")
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        var res = 0.0
        for (i in matrix.indices)
            for (j in matrix[i].indices)
            {
                for (k in matrix[i].indices) {
                    res += this[i, k] * other[k, j]
                }
                resultMatrix[i][j] = res
                res = 0.0
            }
        return Matrix(resultMatrix)
    }

    operator fun plusAssign(other: Matrix) {
        TODO("Not yet implemented")
    }

    operator fun times(scalar: Double): Matrix {
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = this[i, j] * scalar
        return Matrix(resultMatrix)
    }

    operator fun timesAssign(scalar: Double) {
        TODO("Not yet implemented")
    }

    operator fun div(scalar: Double): Matrix {
        if (scalar == 0.0)
            throw IllegalArgumentException("Error. Division by zero is banned")
        val resultMatrix: Array<Array<Double>>  =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = this[i, j] / scalar
        return Matrix(resultMatrix)
    }

    operator fun set(i: Int, j: Int, value: Double) {
        TODO("Not yet implemented")
    }

    operator fun get(i: Int, j: Int): Double {
        TODO("Not yet implemented")
    }

    operator fun unaryMinus(): Matrix {
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.columns) { 0.0 } }
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = -this[i, j]
        return Matrix(resultMatrix)
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

