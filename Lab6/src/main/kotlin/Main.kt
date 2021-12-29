import shapeCollector.Comparators
import shapeCollector.ShapeCollector
import shapeCollector.ShapeFactoryImpl
import shapeCollector.Shape
import shapeCollector.Circle

fun main() {
    val factory = ShapeFactoryImpl()
    val shapeCollector = ShapeCollector<Shape>()
    val circleCollector = ShapeCollector<Circle>()

    // I have no idea how to make a beautiful output for figures,
    circleCollector.add(factory.createCircle(10.0))
    circleCollector.add(factory.createCircle(20.0))
    circleCollector.add(factory.createRandomCircle())
    circleCollector.add(factory.createRandomCircle())
    circleCollector.add(factory.createRandomCircle())

    println(circleCollector.getAllSorted(Comparators.sortCircleRadiusDesc))
    println("\n")

    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())
    shapeCollector.add(factory.createRandomShape())

    println(shapeCollector.getAllSorted(Comparators.sortPerimeter))
    println("\n")
    println(shapeCollector.getAllSorted(Comparators.sortAreaDesc))
}