import org.junit.Test
import org.junit.Assert.*

fun pee(): String {
    return "pee"
}

class UtilKtTest {
    @Test
    fun test1() {
        val text = "pee"
        assertEquals(text, pee())
    }
}