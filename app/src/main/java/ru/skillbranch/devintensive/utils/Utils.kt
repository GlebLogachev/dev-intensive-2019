package ru.skillbranch.devintensive.utils

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.Map as Map1

/* все методы, которые объявлены в данном объекте, будут доступны к доступу в любой части нашего кода
утилитная функция, или утилитный метод
+ у нас есть в2 строенных дата класса: это Pair и Triple*/
object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firsName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)
        if (firsName == null || firsName.length == 0) firsName = null
        if (lastName == null || lastName.length == 0) lastName = null
        return Pair(firsName, lastName)

    }
    fun cyrilicToLatin(c:Char):String{
        return when (c) {
            'а' -> "a"
            'б' -> "b"
            'в' -> "v"
            'г' -> "g"
            'д' -> "d"
            'е' -> "e"
            'ё' -> "e"
            'ж' -> "zh"
            'з' -> "z"
            'и' -> "i"
            'й' -> "i"
            'к' -> "k"
            'л' -> "l"
            'м' -> "m"
            'н' -> "n"
            'о' -> "o"
            'п' -> "p"
            'р' -> "r"
            'с' -> "s"
            'т' -> "t"
            'у' -> "u"
            'ф' -> "f"
            'х' -> "h"
            'ц' -> "c"
            'ч' -> "ch"
            'ш' -> "sh"
            'щ' -> "sh'"
            'ъ' -> ""
            'ы' -> "i"
            'ь' -> ""
            'э' -> "e"
            'ю' -> "yu"
            'я' -> "ya"
            'А' -> "A"
            'Б' -> "B"
            'В' -> "V"
            'Г' -> "G"
            'Д' -> "D"
            'Е' -> "E"
            'Ё' -> "E"
            'Ж' -> "Zh"
            'З' -> "Z"
            'И' -> "I"
            'Й' -> "I"
            'К' -> "K"
            'Л' -> "L"
            'М' -> "M"
            'Н' -> "N"
            'О' -> "O"
            'П' -> "P"
            'Р' -> "R"
            'С' -> "S"
            'Т' -> "T"
            'У' -> "U"
            'Ф' -> "F"
            'Х' -> "H"
            'Ц' -> "C"
            'Ч' -> "Ch"
            'Ш' -> "Sh"
            'Щ' -> "Sh"
            'Ъ' -> ""
            'Ы' -> "I"
            'Ь' -> ""
            'Э' -> "E"
            'Ю' -> "Yu"
            'Я' -> "Ya"
            else -> c.toString()
        }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val sb = StringBuilder()
        payload?.forEach()
        { sb.append(if(it == ' ') divider else cyrilicToLatin(it))
        }
        return sb.toString()

    }

    fun toInitials(firstName: String?, lastName: String?):String?{
        val initial_1 = firstName?.trim()?.getOrNull(0)
        val initial_2 = lastName?.trim()?.getOrNull(0)
        val result = listOfNotNull(initial_1, initial_2).joinToString("")
        return if(result == "") null else result.toUpperCase()
    }
}