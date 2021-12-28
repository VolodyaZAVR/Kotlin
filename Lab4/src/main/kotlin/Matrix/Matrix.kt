package Matrix

class Matrix(private var matrixArray: Array<Array<Double>>){
    // ...
    var matrix: Array<Array<Double>> = emptyArray()

    init {
        if (matrixArray.isEmpty() || matrixArray[0].isEmpty())
            throw IllegalArgumentException("Error. Empty Matrix")
        var sizeMatrix = matrixArray[0].size
        matrix = Array(matrixArray.size) { Array(matrixArray[0].size) { 0.0 } }
        for (i in matrixArray)
            if (i.size != sizeMatrix)
                throw IllegalArgumentException("Error. Incorrect sizes of the matrix.")
        for (i in matrixArray.indices)
            for (j in matrixArray[0].indices)
                matrix[i][j] = matrixArray[i][j]
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
    // ...
}

