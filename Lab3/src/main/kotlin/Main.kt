import factory.ShapeFactoryImpl

fun main() {
    val factory = ShapeFactoryImpl()
    val shapes = listOf(
        factory.createRandomCircle(),
        factory.createRandomSquare(),
        factory.createRandomRectangle(),
        factory.createRandomTriangle(),
        factory.createRandomShape()
    )

}