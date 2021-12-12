import org.junit.Test
import org.junit.Assert.*

fun pee(): String {
    return "pee"
}

class UtilKtTest {
    @Test
    fun `asalyami aleykum`() {
        val text = "pee"
        assertEquals(text, pee())
    }
}