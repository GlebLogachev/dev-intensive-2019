package ru.skillbranch.devintensive.extensions

import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR
/* extension по своей сути она генерирует статическую функцию, которую можно применить
 к экземпляру определенного класса */
fun Date.format (pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.add (value: Int, units: TimeUnits = TimeUnits.SECOND) : Date {
    var time = this.time
   time += when (units){
        TimeUnits.SECOND -> value *SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY-> value * DAY

    }
    this.time = time
return this
}

// TODO ВОТ ТУТ 1:16:24 video ^


enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}