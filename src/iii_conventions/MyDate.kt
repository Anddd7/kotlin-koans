package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

fun MyDate.toString() = "$year$month$dayOfMonth"

operator fun MyDate.compareTo(other: MyDate): Int = this.toString().compareTo(other.toString())
operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)

operator fun DateRange.contains(value: MyDate): Boolean = start < value && value < endInclusive
