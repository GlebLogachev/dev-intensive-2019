package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/*Создаем extension функцию, метод, которая будет превращть наш экземляр data класа User в объект
UserView и будет возвращать объект UserView*/
fun User.toUserView (): UserView {
val nickName = Utils.transliteration("$firstName $lastName")
val initials = Utils.toInitials (firstName, lastName)
val status = if (lastVisit==null) "Ещё ни разу не был" else if (isOnline) "онлайн" else "не онлайн"
    return UserView(
    id,
    fullName = "$firstName $lastName" ,
    avatar = avatar,
    nickName = nickName ,
    initials =initials,
    status = status)
// как мы видим, не пишем никаких конструкторов типа this итд. Идентификатор класса User автоматически
// замапился на идентификатор конструктора UserView
}

