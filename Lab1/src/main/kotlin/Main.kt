typealias UserId = String

interface ShowInformation {
    fun show()
}

open class User(
    private val id: UserId,
    private val firstName: UserId,
    private val lastName: UserId
) {
    fun getFullName(): String = "id=$id Name : $firstName $lastName"
}

class UserBase : ShowInformation {
    private var users: ArrayList<User> = arrayListOf()

    fun addUser(newUser: User) {
        users.add(newUser)
    }

    override fun show() {
        println("Users base:")
        for (user in users) {
            println(user.getFullName())
        }
    }
}


fun main() {
    val userBase = UserBase()
    userBase.addUser(User("1", "Зубенко", "Михаил"))
    userBase.addUser(User("2", "Владимир", "Владимирович"))
    userBase.addUser(User("3", "Олешер", "Моргенштерн"))
    userBase.show()
    println("Hello world!")
}
