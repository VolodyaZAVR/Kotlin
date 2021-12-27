import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith
import kotlin.test.assertEquals
import factory.ShapeFactoryImpl

class UtilKtTest {

    @Test
    fun `circle incorrect radius`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createCircle(-5.0) }
        assertEquals("Invalid argument. The radius can't be less than 1.", exception.message)
    }

    @Test
    fun `circle area`() {
        val shapeFactor = ShapeFactoryImpl()
        val area = shapeFactor.createCircle(5.0).calcArea()
        assertEquals(area, 78.53981633974483)
    }

    @Test
    fun `circle perimeter`() {
        val shapeFactor = ShapeFactoryImpl()
        val perimeter = shapeFactor.createCircle(5.0).calcPerimeter()
        assertEquals(perimeter, 31.41592653589793)
    }

    @Test
    fun `square incorrect length`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createSquare(-5.0) }
        assertEquals("Invalid argument. The length can't be less than 1.", exception.message)
    }

    @Test
    fun `square area`() {
        val shapeFactor = ShapeFactoryImpl()
        val area = shapeFactor.createSquare(5.0).calcArea()
        assertEquals(area, 25.0)
    }

    @Test
    fun `square perimeter`() {
        val shapeFactor = ShapeFactoryImpl()
        val perimeter = shapeFactor.createSquare(5.0).calcPerimeter()
        assertEquals(perimeter, 20.0)
    }

    @Test
    fun `rectangle incorrect length`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createRectangle(-5.0, 2.0) }
        assertEquals("Invalid argument. The length can't be less than 1.", exception.message)
    }

    @Test
    fun `rectangle incorrect width`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createRectangle(5.0, -2.0) }
        assertEquals("Invalid argument. The width can't be less than 1.", exception.message)
    }

    @Test
    fun `rectangle area`() {
        val shapeFactor = ShapeFactoryImpl()
        val area = shapeFactor.createRectangle(5.0, 2.0).calcArea()
        assertEquals(area, 10.0)
    }

    @Test
    fun `rectangle perimeter`() {
        val shapeFactor = ShapeFactoryImpl()
        val perimeter = shapeFactor.createRectangle(5.0, 2.0).calcPerimeter()
        assertEquals(perimeter, 14.0)
    }

    @Test
    fun `triangle incorrect length`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createTriangle(5.0, -2.0, 4.0) }
        assertEquals("Invalid argument. The length can't be less than 1.", exception.message)
    }

    @Test
    fun `triangle nonexistent`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createTriangle(8.0, 4.0, 4.0) }
        assertEquals("Invalid arguments. A triangle with such sides can't exist.", exception.message)
    }

    @Test
    fun `triangle area`() {
        val shapeFactor = ShapeFactoryImpl()
        val area = shapeFactor.createTriangle(5.0, 5.0, 8.0).calcArea()
        assertEquals(area, 12.0)
    }

    @Test
    fun `triangle perimeter`() {
        val shapeFactor = ShapeFactoryImpl()
        val perimeter = shapeFactor.createTriangle(5.0, 5.0, 8.0).calcPerimeter()
        assertEquals(perimeter, 18.0)
    }
}