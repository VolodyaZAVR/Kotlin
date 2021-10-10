typealias UserId = String

class User(
    val id: UserId,
    val firstName: UserId,
    val lastName: UserId
) {
    fun getFullName(): String = "$id $firstName $lastName"
}

fun main() {
    val user = User("Зубенко", "Михаил", "Петрович")
    println(user.getFullName())
}