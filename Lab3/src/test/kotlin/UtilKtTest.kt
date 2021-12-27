import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith
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
    fun `square incorrect length`() {
        val shapeFactor = ShapeFactoryImpl()
        val exception =
            assertFailsWith<IllegalArgumentException> { shapeFactor.createSquare(-5.0) }
        assertEquals("Invalid argument. The length can't be less than 1.", exception.message)
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

}