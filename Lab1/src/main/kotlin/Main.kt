import TextAlign.AlignedText


fun main() {
    val text =
        "Над нашей страной вьются тучи\nИ головы мёрзнут у нас\nИ если один купит шляпу\nМиллионы воскликнут: «Как раз!»"
    val alText = AlignedText()
    println(alText.alignText(text, 25, AlignedText.Alignment.RIGHT))
}