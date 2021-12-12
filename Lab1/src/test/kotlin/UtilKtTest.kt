import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith

class UtilKtTest {

    @Test
    fun `left align test1`() { //проверка устраняемости лишних пробелов в начале и конце
        val text = " Текст  "
        val alText = AlignedText()
        val res = alText.alignText(text, 20, AlignedText.Alignment.LEFT)
        assertEquals(res, "Текст")
    }
    @Test
    fun `left align test2`() { //проверка устраняемости лишних пробелов между словами
        val text = "Текст  о      чем-то"
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.LEFT)
        assertEquals(res, "Текст о чем-то")
    }

    @Test
    fun `left align test3`() { //проверка сохраняемости переносов
        val text = "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 150, AlignedText.Alignment.LEFT)
        assertEquals(res, "Над нашей страной вьются тучи\n" +
                "И головы мёрзнут у нас\n" +
                "И если один купит шляпу\n" +
                "Миллионы воскликнут: «Как раз!»")
    }
}