import org.junit.Test
import org.junit.Assert.*
import kotlin.test.assertFailsWith
import TextAlign.AlignedText

class UtilKtTest {

    @Test
    fun `checking for string length`() {
        val text = ""
        val alText = AlignedText()
        val exception =
            assertFailsWith<IllegalArgumentException> { alText.alignText(text, -20, AlignedText.Alignment.LEFT) }
        assertEquals("Invalid argument. String length can't be less than 1.", exception.message)
    }

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
                    "Миллионы воскликнут: «Как \n" +
                    "раз!»"
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

    @Test
    fun `left align checking the reaction to spaces from the right alignment`() {
        val text = "12345\n" + " 2345\n" + "  345\n" + "   45\n" + "    5"
        val alText = AlignedText()
        val res = alText.alignText(text, 5, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "12345\n" + "2345\n" + "345\n" + "45\n" + "5"
        )
    }

    @Test
    fun `left align checking the reaction to spaces from the central alignment`() {
        val text = "12345\n" + "2345 \n" + " 345 \n" + " 45  \n" + "  5  "
        val alText = AlignedText()
        val res = alText.alignText(text, 5, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "12345\n" + "2345\n" + "345\n" + "45\n" + "5"
        )
    }

    @Test
    fun `left align checking the correctness of dividing one word into many lines`() {
        val text = "Тридцать три коробля лавировалилавировалиданевылавировали"
        val alText = AlignedText()
        val res = alText.alignText(text, 15, AlignedText.Alignment.LEFT)
        assertEquals(
            res, "Тридцать три \n" + "коробля \n" + "лавировалилавир\n" + "овалиданевылави\n" + "ровали"
        )
    }

    @Test
    fun `right align checking for an empty string`() {
        val text = ""
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, ""
        )
    }

    @Test
    fun `right align checking for the absence of new symbols`() {
        val text = "Текст"
        val alText = AlignedText()
        val res = alText.alignText(text, 10, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, "     Текст"
        )
    }

    @Test
    fun `right align checking for the absence of new characters`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 31, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, "  Над нашей страной вьются тучи\n" +
                    "         И головы мёрзнут у нас\n" +
                    "        И если один купит шляпу\n" +
                    "Миллионы воскликнут: «Как раз!»"
        )
    }

    @Test
    fun `right align checking for the absence of new characters after line breaks`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 25, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, "Над нашей страной вьются \n" +
                    "                     тучи\n" +
                    "   И головы мёрзнут у нас\n" +
                    "  И если один купит шляпу\n" +
                    "Миллионы воскликнут: «Как \n" +
                    "                    раз!»"
        )
    }

    @Test
    fun `right align checking for simple line breaks`() {
        val text = "Декабрь - лучшее время для сдачи первой лабораторной"
        val alText = AlignedText()
        val res = alText.alignText(text, 20, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, "   Декабрь - лучшее \n" + "    время для сдачи \n" + " первой лабораторной"
        )
    }

    @Test
    fun `right align checking the reaction to spaces from the central alignment`() {
        val text = "12345\n" + "2345 \n" + " 345 \n" + " 45  \n" + "  5  "
        val alText = AlignedText()
        val res = alText.alignText(text, 5, AlignedText.Alignment.RIGHT)
        assertEquals(
            res, "12345\n" + " 2345\n" + "  345\n" + "   45\n" + "    5"
        )
    }

    @Test
    fun `center align checking for an empty string`() {
        val text = ""
        val alText = AlignedText()
        val res = alText.alignText(text, 40, AlignedText.Alignment.CENTER)
        assertEquals(
            res, ""
        )
    }

    @Test
    fun `center align checking for the absence of new symbols`() {
        val text = "Текст"
        val alText = AlignedText()
        val res = alText.alignText(text, 10, AlignedText.Alignment.CENTER)
        assertEquals(
            res, "  Текст"
        )
    }

    @Test
    fun `center align checking for the absence of new characters`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 31, AlignedText.Alignment.CENTER)
        assertEquals(
            res, " Над нашей страной вьются тучи\n" +
                    "    И головы мёрзнут у нас\n" +
                    "    И если один купит шляпу\n" +
                    "Миллионы воскликнут: «Как раз!»"
        )
    }

    @Test
    fun `center align checking for the absence of new characters after line breaks`() {
        val text =
            "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
        val alText = AlignedText()
        val res = alText.alignText(text, 25, AlignedText.Alignment.CENTER)
        assertEquals(
            res, "Над нашей страной вьются \n" +
                    "          тучи\n" +
                    " И головы мёрзнут у нас\n" +
                    " И если один купит шляпу\n" +
                    "Миллионы воскликнут: «Как \n" +
                    "          раз!»"
        )
    }

    @Test
    fun `center align checking for simple line breaks`() {
        val text = "Декабрь - лучшее время для сдачи первой лабораторной"
        val alText = AlignedText()
        val res = alText.alignText(text, 20, AlignedText.Alignment.CENTER)
        assertEquals(
            res, " Декабрь - лучшее \n" + "  время для сдачи \n" + "первой лабораторной"
        )
    }

    @Test
    fun `center align checking the reaction to spaces from the right alignment`() {
        val text = "12345\n" + " 2345\n" + "  345\n" + "   45\n" + "    5"
        val alText = AlignedText()
        val res = alText.alignText(text, 5, AlignedText.Alignment.CENTER)
        assertEquals(
            res, "12345\n" + "2345\n" + " 345\n" + " 45\n" + "  5"
        )
    }
}

