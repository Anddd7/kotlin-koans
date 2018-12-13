package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate) =
        (year - other.year) * 10000 +
            (month - other.month) * 100 +
            (dayOfMonth - other.dayOfMonth)

    operator fun rangeTo(other: MyDate) = DateRange(this, other)

    operator fun plus(timeInterval: TimeInterval) = addTimeIntervals(timeInterval, 1)
    operator fun plus(repeatedTimeInterval: RepeatedTimeInterval) =
        addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.times)
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator() = DateRangeItr()

    inner class DateRangeItr : Iterator<MyDate> {
        private var next = start

        override fun hasNext() = next <= endInclusive

        override fun next(): MyDate {
            val current = next
            next = current.nextDay()
            return current
        }
    }
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(number: Int) = RepeatedTimeInterval(this, number)
}

class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)
