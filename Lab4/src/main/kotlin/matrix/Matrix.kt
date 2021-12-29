package matrix

// this is class of unmutable matrix
open class Matrix(private var matrixElements: Array<Array<Double>>) {
    protected var matrix: Array<Array<Double>> = emptyArray()

    val rows: Int
        get() {
            return matrix.size
        }

    val cols: Int
        get() {
            return matrix[0].size
        }

    init {
        // checking for errors
        if (matrixElements.isEmpty() || matrixElements[0].isEmpty())
            throw IllegalArgumentException("Error. Empty Matrix")
        val size = matrixElements[0].size
        for (i in matrixElements)
            if (i.size != size) throw IllegalArgumentException("Error. Incorrect dimensions of the matrix.")
        // copying matrix to local variable
        matrix = Array(matrixElements.size) { Array(matrixElements[0].size) { 0.0 } }
        for (i in matrixElements.indices)
            for (j in matrixElements[0].indices)
                matrix[i][j] = matrixElements[i][j]
    }

    open operator fun plus(other: Matrix): Matrix {
        // checking for errors
        if (this.rows != other.rows || this.cols != other.cols)
            throw IllegalArgumentException("Error. It is impossible to add matrices of different sizes.")
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // calculations
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                resultMatrix[i][j] = this[i, j] + other[i, j]
        return Matrix(resultMatrix)
    }

    open operator fun minus(other: Matrix): Matrix {
        // checking for errors
        if (this.rows != other.rows || this.cols != other.cols)
            throw IllegalArgumentException("Error. It is impossible to subtract matrices of different sizes.")
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // calculations
        for (i in matrix.indices)
            for (j in matrix[i].indices)
                resultMatrix[i][j] = this[i, j] - other[i, j]
        return Matrix(resultMatrix)
    }

    open operator fun times(other: Matrix): Matrix {
        // checking for errors
        if (this.cols != other.rows)
            throw IllegalArgumentException("Error. The number of columns of the first matrix does not match the number of rows of the second matrix")
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        var res = 0.0
        // calculations
        for (i in matrix.indices)
            for (j in matrix[i].indices) {
                for (k in matrix[i].indices) {
                    res += this[i, k] * other[k, j]
                }
                resultMatrix[i][j] = res
                res = 0.0
            }
        return Matrix(resultMatrix)
    }

    open operator fun times(scalar: Double): Matrix {
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // calculations
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = this[i, j] * scalar
        return Matrix(resultMatrix)
    }

    open operator fun div(scalar: Double): Matrix {
        // checking for division by zero
        if (scalar == 0.0)
            throw IllegalArgumentException("Error. Division by zero is banned")
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // calculations
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = this[i, j] / scalar
        return Matrix(resultMatrix)
    }

    private operator fun set(i: Int, j: Int, value: Double) {
        if (i < 0 || j < 0 || cols - 1 < i || rows - 1 < j) // checking for errors
            throw IllegalArgumentException("Error. Wrong index.")
        matrix[i][j] = value
    }

    operator fun get(i: Int, j: Int): Double {
        if (i < 0 || j < 0 || cols - 1 < i || rows - 1 < j) // checking for errors
            throw IllegalArgumentException("Error. Wrong index.")
        return matrix[i][j]
    }

    open operator fun unaryMinus(): Matrix {
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // do the unary minus for matrix elements
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = -this[i, j]
        return Matrix(resultMatrix)
    }

    open operator fun unaryPlus(): Matrix {
        return this
    }

    override fun hashCode(): Int {
        return matrix.contentDeepHashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Matrix)
            return false
        if (rows != other.rows)
            return false
        if (cols != other.cols)
            return false
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                if (this[i, j] != other[i, j]) return false
        return true
    }

    override fun toString(): String {
        var out = ""
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                out += matrix[i][j].toString() + " "
            }
            out += "\n"
        }
        return out
    }

    fun toMutableMatrix(): MutableMatrix {
        return MutableMatrix(this.matrix)
    }
}

class MutableMatrix constructor(matrix: Array<Array<Double>>) : Matrix(matrix) {
    operator fun set(i: Int, j: Int, value: Double) {
        if (i < 0 || j < 0 || cols - 1 < i || rows - 1 < j)
            throw IllegalArgumentException("Error. Wrong index.")
        matrix[i][j] = value
    }

    /*
    Цe bring the data type to Matrix, do the calculations that were described in the Matrix class
     and bring them back to MutableMatrix. And then we rest by the palm tree
     */
    override operator fun plus(other: Matrix): MutableMatrix {
        return (this.toMatrix() + other).toMutableMatrix()
    }

    override fun minus(other: Matrix): MutableMatrix {
        return (this.toMatrix() - other).toMutableMatrix()
    }

    override fun times(other: Matrix): MutableMatrix {
        return (this.toMatrix() * other).toMutableMatrix()
    }

    override fun times(scalar: Double): MutableMatrix {
        return (this.toMatrix() * scalar).toMutableMatrix()
    }

    override fun div(scalar: Double): MutableMatrix {
        return (this.toMatrix() / scalar).toMutableMatrix()
    }

    override fun unaryMinus(): MutableMatrix {
        return this.toMatrix().unaryMinus().toMutableMatrix()
    }

    override fun unaryPlus(): MutableMatrix {
        return this
    }

    operator fun plusAssign(other: Matrix) {
        // checking for errors
        if (this.rows != other.rows || this.cols != other.cols)
            throw IllegalArgumentException("Error. It is impossible to add matrices of different sizes.")
        // calculations
        for (i in this.matrix.indices)
            for (j in this.matrix[i].indices)
                this[i, j] += other[i, j]
    }

    operator fun minusAssign(other: Matrix) {
        // checking for errors
        if (this.rows != other.rows || this.cols != other.cols)
            throw IllegalArgumentException("Error. It is impossible to add matrices of different sizes.")
        // calculations
        for (i in this.matrix.indices)
            for (j in this.matrix[i].indices)
                this[i, j] -= other[i, j]
    }

    operator fun timesAssign(other: Matrix) {
        // checking for errors
        if (this.cols != other.rows)
            throw IllegalArgumentException("Error. The number of columns of the first matrix does not match the number of rows of the second matrix")
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        var res = 0.0
        // calculations
        for (i in this.matrix.indices)
            for (j in this.matrix[i].indices) {
                for (k in this.matrix[i].indices) {
                    res += this[i, k] * other[k, j]
                }
                resultMatrix[i][j] = res
                res = 0.0
            }
        this.matrix = resultMatrix
    }

    operator fun timesAssign(scalar: Double) {
        // create temporary array
        val resultMatrix: Array<Array<Double>> =
            Array(this.rows) { Array(this.cols) { 0.0 } }
        // calculations
        for (i in matrix.indices)
            for (j in matrix[0].indices)
                resultMatrix[i][j] = this[i, j] * scalar
        this.matrix = resultMatrix
    }

    fun toMatrix(): Matrix {
        return Matrix(this.matrix)
    }
}
