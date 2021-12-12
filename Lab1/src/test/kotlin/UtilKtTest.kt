import org.junit.Test
import org.junit.Assert.*
import TextAlign.AlignedText

class UtilKtTest {

    @Test
    fun `left align checking for an empty string`() {
        val text = ""
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.LEFT)
        assertEquals(
            res, ""
        )
    }

    @Test
    fun `left align checking for an blank string`() {
        val text = "            "
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.LEFT)
        assertEquals(
            res, ""
        )
    }

    @Test
    fun `left align checking for the absence of new symbols`() {
        val text = "Текст"
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "Текст"
        )
    }


    @Test
    fun `left align checking for the absence of new characters`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "Над нашей страной вьются тучи\n" +
                    "И головы мёрзнут у нас\n" +
                    "И если один купит шляпу\n" +
                    "Миллионы воскликнут: «Как раз!»"
        )
    }

    @Test
    fun `left align checking for the absence of new characters after line breaks`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 25, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "Над нашей страной вьются \n" +
                    "тучи\n" +
                    "И головы мёрзнут у нас\n" +
                    "И если один купит шляпу\n" +
                    "Миллионы воскликнут: \n" +
                    "«Как раз!»"
        )
    }

    @Test
    fun `left align checking for simple line breaks`() {
        val text = "Декабрь - лучшее время для сдачи первой лабораторной"
        val alText = AlignedText()
        val res = alText.alignText(text, 20, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "Декабрь - лучшее \n" + "время для сдачи \n" + "первой лабораторной"
        )
    }

}

