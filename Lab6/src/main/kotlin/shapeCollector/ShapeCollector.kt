package shapeCollector

object Comparators {
    val sortArea = compareBy<Shape> { it.calcArea() }
    val sortAreaDesc = compareByDescending<Shape> { it.calcArea() }
    val sortPerimeter = compareBy<Shape> { it.calcPerimeter() }
    val sortPerimeterDesc = compareByDescending<Shape> { it.calcPerimeter() }
    val sortCircleRadius = compareBy<Circle> { it.radius }
    val sortCircleRadiusDesc = compareByDescending<Circle> { it.radius }
}

class ShapeCollector<T : Shape> {
    private val allShapes = mutableListOf<T>()

    fun add(new: T) {
        allShapes.add(new)
    }

    fun addAll(newCollection: Collection<T>) {
        for (item in newCollection)
            allShapes.add(item)
    }

    fun getAll(): List<T> {
        return allShapes.toList()
    }

    fun getAllSorted(comparator: Comparator<in T>): List<T> {
        return getAll().sortedWith(comparator)
    }
}