import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith
import matrix.Matrix

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
val array3 = arrayOf(
    arrayOf(1.0, 2.0, 3.0),
    arrayOf(1.0, 2.0, 3.0)
)

val matrix1 = Matrix(array1)
val matrix2 = Matrix(array2)
val matrix3 = Matrix(array3)

class UtilKtTest {
    @Test
    fun `checking the operation of an exception when an array is empty`() {
        val arrayError = arrayOf(
            arrayOf(),
            arrayOf(1.0)
        )
        val exception =
            assertFailsWith<IllegalArgumentException> { Matrix(arrayError)}
        assertEquals("Error. Empty Matrix", exception.message)
    }

    @Test
    fun `checking the operation of an exception when an array has incorrect sizes`() {
        val arrayError = arrayOf(
            arrayOf(1.0),
            arrayOf(1.0, 2.0)
        )
        val exception =
            assertFailsWith<IllegalArgumentException> { Matrix(arrayError)}
        assertEquals("Error. Incorrect dimensions of the matrix.", exception.message)
    }

    @Test
    fun `checking the operation of the exception when matrices of different sizes are added together`() {
        val exception =
            assertFailsWith<IllegalArgumentException> {matrix1.plus(matrix3)}
        assertEquals("Error. It is impossible to add matrices of different sizes.", exception.message)
    }

    @Test
    fun `checking the operation of the exception when matrices of different sizes are subtracted`() {
        val exception =
            assertFailsWith<IllegalArgumentException> {matrix1.minus(matrix3)}
        assertEquals("Error. It is impossible to subtract matrices of different sizes.", exception.message)
    }

    @Test
    fun `checking the operation of the exception when matrices of incorrect sizes are multiplied`() {
        val exception =
            assertFailsWith<IllegalArgumentException> {matrix1.times(matrix3)}
        assertEquals("Error. The number of columns of the first matrix does not match the number of rows of the second matrix", exception.message)
    }

    @Test
    fun `checking the operation of the exception when dividing by zero`() {
        val exception =
            assertFailsWith<IllegalArgumentException> {matrix1.div(0.0)}
        assertEquals("Error. Division by zero is banned", exception.message)
    }

    @Test
    fun `checking the operation of the unary plus`() {
        val array = arrayOf(
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(1.0, 2.0, 3.0),
            arrayOf(1.0, 2.0, 3.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.unaryPlus())
    }

    @Test
    fun `checking the operation of the unary minus`() {
        val array = arrayOf(
            arrayOf(-1.0, -2.0, -3.0),
            arrayOf(-1.0, -2.0, -3.0),
            arrayOf(-1.0, -2.0, -3.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.unaryMinus())
    }

    @Test
    fun `checking the operation of the plus`() {
        val array = arrayOf(
            arrayOf(2.0, 4.0, 5.0),
            arrayOf(2.0, 4.0, 5.0),
            arrayOf(2.0, 4.0, 5.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.plus(matrix2))
    }

    @Test
    fun `checking the operation of the minus`() {
        val array = arrayOf(
            arrayOf(0.0, 0.0, 1.0),
            arrayOf(0.0, 0.0, 1.0),
            arrayOf(0.0, 0.0, 1.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.minus(matrix2))
    }

    @Test
    fun `checking the operation of the times`() {
        val array = arrayOf(
            arrayOf(6.0, 12.0, 12.0),
            arrayOf(6.0, 12.0, 12.0),
            arrayOf(6.0, 12.0, 12.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.times(matrix2))
    }

    @Test
    fun `checking the operation of the times (scalar)`() {
        val array = arrayOf(
            arrayOf(3.0, 6.0, 9.0),
            arrayOf(3.0, 6.0, 9.0),
            arrayOf(3.0, 6.0, 9.0)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.times(3.0))
    }

    @Test
    fun `checking the operation of the div`() {
        val array = arrayOf(
            arrayOf(0.5, 1.0, 1.5),
            arrayOf(0.5, 1.0, 1.5),
            arrayOf(0.5, 1.0, 1.5)
        )
        val matrix = Matrix(array)
        assertEquals(matrix, matrix1.div(2.0))
    }
}