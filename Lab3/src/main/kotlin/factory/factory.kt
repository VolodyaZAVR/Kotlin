package factory
import kotlin.math.*

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

class Circle(private val radius: Double) : Shape {
    init {
        if (radius <= 0) {
            throw IllegalArgumentException("Invalid argument. The radius can't be less than 1.")
        }
    }

    override fun calcArea(): Double {
        return PI * radius.pow(2)
    }

    override fun calcPerimeter(): Double {
        return 2 * PI * radius
    }
}

class Square(private val length: Double) : Shape {
    init {
        if (length <= 0) {
            throw IllegalArgumentException("Invalid argument. The length can't be less than 1.")
        }
    }

    override fun calcArea(): Double {
        return length.pow(2)
    }

    override fun calcPerimeter(): Double {
        return 4 * length
    }

}

class Rectangle(private val length: Double, private val width: Double) : Shape {
    init {
        if (length <= 0) {
            throw IllegalArgumentException("Invalid argument. The length can't be less than 1.")
        }
        if (width <= 0) {
            throw IllegalArgumentException("Invalid argument. The width can't be less than 1.")
        }
    }

    override fun calcArea(): Double {
        return length * width
    }

    override fun calcPerimeter(): Double {
        return 2 * (length + width)
    }

}

class Triangle(private val a: Double, private val b: Double, private val c: Double) : Shape {
    init {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw IllegalArgumentException("Invalid argument. The length can't be less than 1.")
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            throw IllegalArgumentException("Invalid arguments. A triangle with such sides can't exist.")
        }

    }

    override fun calcArea(): Double {
        return sqrt(((a + b + c) / 2) * ((a + b + c) / 2 - a) * ((a + b + c) / 2 - b) * ((a + b + c) / 2 - c))
    }

    override fun calcPerimeter(): Double {
        return a * b * c
    }

}
