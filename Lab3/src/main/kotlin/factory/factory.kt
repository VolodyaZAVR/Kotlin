package factory

import kotlin.math.*

interface Shape {
    fun calcArea(): Double
    fun calcPerimeter(): Double
}

// this class describes a geometric shape circle
class Circle(private val radius: Double) : Shape {
    init {
        if (radius <= 0) { // checking the correctness of the entered circle radius
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

// this class describes a geometric shape square
class Square(private val length: Double) : Shape {
    init {
        if (length <= 0) { // checking the correctness of the entered side of square
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

// this class describes a geometric shape rectangle
class Rectangle(private val length: Double, private val width: Double) : Shape {
    init {
        if (length <= 0) { // checking for correction entered sides of rectangle
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

// this class describes a geometric shape triangle
class Triangle(private val a: Double, private val b: Double, private val c: Double) : Shape {
    init {
        if (a <= 0 || b <= 0 || c <= 0) { // checking the sides for positivity
            throw IllegalArgumentException("Invalid argument. The length can't be less than 1.")
        }
        if (a + b <= c || a + c <= b || b + c <= a) { //checking sides for existing triangle
            throw IllegalArgumentException("Invalid arguments. A triangle with such sides can't exist.")
        }
    }

    // the formula for the area of a triangle through a half - perimeter
    override fun calcArea(): Double {
        val p: Double = (a + b + c) / 2
        return sqrt(p * (p - a) * (p - b) * (p - c))
    }

    override fun calcPerimeter(): Double {
        return a + b + c
    }
}
