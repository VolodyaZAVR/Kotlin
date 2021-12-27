import factory.ShapeFactoryImpl

fun main() {
    val factory = ShapeFactoryImpl()
    val shapes = listOf(
        factory.createRandomCircle(),
        factory.createRandomSquare(),
        factory.createRandomRectangle(),
        factory.createRandomTriangle(),
        factory.createRandomShape(),
        factory.createRandomCircle(),
        factory.createRandomRectangle(),
        factory.createRandomTriangle(),
        factory.createRandomSquare(),
        factory.createRandomShape()
    )

    println("The total area: ${shapes.sumOf { it.calcArea() }}")
    println("The total perimeter: ${shapes.sumOf { it.calcPerimeter() }}")
    println("The figure with the max area: ${shapes.maxByOrNull { it.calcArea() }}")
    println("The figure with the min area: ${shapes.minByOrNull { it.calcArea() }}")
    println("The figure with the max perimeter: ${shapes.maxByOrNull { it.calcPerimeter() }}")
    println("The figure with the min perimeter: ${shapes.minByOrNull { it.calcPerimeter() }}")
}