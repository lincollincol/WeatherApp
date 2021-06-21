package linc.com.weatherapp.utils

import java.text.SimpleDateFormat
import java.util.*

object TimestampFormatter {

    private val time24h = SimpleDateFormat("HH:mm", Locale.US)
    private val shortWeekDate = SimpleDateFormat("EEE d", Locale.US)
    private val longWeekShortMonthDate = SimpleDateFormat("EEEE | MMM d", Locale.US)

    fun formatWeek(timestamp: Long) = shortWeekDate.format(Date(timestamp))

    fun formatFullDate(timestamp: Long) = longWeekShortMonthDate.format(Date(timestamp))

    fun formatTime24h(timestamp: Long) = time24h.format(Date(timestamp))

}