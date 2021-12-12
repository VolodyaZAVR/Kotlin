import TextAlign.AlignedText


fun main() {
    val text = "— Кто ты?! \n" +
            "— Я тот, кого ты из меня сделал! Я вел жизнь, которую ты ценил, но сам воплотить боялся! Я стал всем тем, кем сам ты испугался быть! Но я всегда... всегда старался быть лучше, чем я есть."
    val alText = AlignedText()
    println(alText.alignText(text, 20, AlignedText.Alignment.LEFT))
}