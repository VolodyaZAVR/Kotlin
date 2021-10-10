import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith

fun parsePair(string: String): Pair<Int, Int> = Pair(
    string.substringBefore(" ").toInt(),
    string.substringAfter(" ").toInt()
)

class UtilKtTest {

    @Test
    fun testSimpleParsing() {
        assertEquals(Pair(10, 10), parsePair("10 10"))
    }

    @Test(expected = AssertionError::class)
    fun testException() {
        assertEquals(Pair(10, 10), parsePair(("100 10")))
    }

    @Test
    fun `test than compleated exception`() {
        assertFailsWith<AssertionError> {
            assertEquals(Pair(10, 10), parsePair(("1010")))
        }
    }
}