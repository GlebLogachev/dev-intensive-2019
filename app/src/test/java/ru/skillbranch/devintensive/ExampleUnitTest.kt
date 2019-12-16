package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Sena")
    }

    @Test
    fun test_factory() {
        val user_test = User.Factory.makeUser("Alex Wick")
    }

    @Test
    fun test_decomposition() {
        /*есть функция, которая возвращает нам информацию о пользователе. Ррезультатом выполнения
            данной функции может является DTO (Data Transfer Object), t.e data class user. Соответственно
            если мы обратимся к этой функции мы сможем вытянуть интересующие нас поля, обращаясь по имени
            в именованном представлении(см.val (id, firstname, lastName))*/
        val user = User.Factory.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstname, lastName) = getUserInfo()
      //  println("${user.component1()}, $firstname, $lastName")

    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add (-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Cena", lastVisit = Date().add(2,TimeUnits.HOUR))

    }
    @Test
    fun test_data_mapping() {
        val user = User.makeUser("глеб логачев")
        val newUser = user.copy(lastVisit = Date().add(13, TimeUnits.SECOND))
        println(newUser)
        val userView = newUser.toUserView()
        userView.printMe()
    }


    @Test
     fun test_abstract_factory() {
        val user = User.makeUser("Глеб Логачев")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0") , payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0") , payload = "any image url", type = "image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}