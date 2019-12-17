package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils

//Делаем data mapping (мэпим данные ) из наших DTO классов на наши экземпляры других классов
// как на User view можно замапить данные из нашего DTO(Data class) объекта User
class UserView(
    val id: String,
    val fullName: String,
    val nickName:String,
    var avatar: String? = null,
    var status: String? = "ofline",
    val initials: String?)

{
    fun printMe (){
        println("""
            id: $id 
            fullName: $fullName
            nickName: $nickName
            avatar: $avatar 
            status: $status
            initials: $initials 
        """.trimIndent()
        )
    }
}