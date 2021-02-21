package linc.com.weatherapp.utils

import android.content.res.Resources
import linc.com.weatherapp.R
import linc.com.weatherapp.utils.Constants.AFTERNOON
import linc.com.weatherapp.utils.Constants.AUTUMN
import linc.com.weatherapp.utils.Constants.EVENING
import linc.com.weatherapp.utils.Constants.MORNING
import linc.com.weatherapp.utils.Constants.NIGHT
import linc.com.weatherapp.utils.Constants.SPRING
import linc.com.weatherapp.utils.Constants.SUMMER
import linc.com.weatherapp.utils.Constants.WINTER
import org.jetbrains.annotations.NotNull
import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

object BackgroundProvider {

    private const val hour = "HH"
    private const val month = "MM"
    private val hourFormat = SimpleDateFormat(hour, Locale.US)
    private val monthFormat = SimpleDateFormat(month, Locale.US)
    private val calendar = Calendar.getInstance()
    private val images = linkedMapOf<Byte, @NotNull Map<Byte, Int>>()

    init {
        images[SPRING] = mapOf(
            MORNING to R.drawable.spring_morning,
            AFTERNOON to R.drawable.spring_day,
            EVENING to R.drawable.spring_evening,
            NIGHT to R.drawable.spring_night
        )
        images[SUMMER] = mapOf(
            MORNING to R.drawable.summer_morning,
            AFTERNOON to R.drawable.summer_day,
            EVENING to R.drawable.summer_evening,
            NIGHT to R.drawable.summer_night
        )
        images[AUTUMN] = mapOf(
            MORNING to R.drawable.autumn_morning,
            AFTERNOON to R.drawable.autumn_day,
            EVENING to R.drawable.autumn_evening,
            NIGHT to R.drawable.autumn_night
        )
        images[WINTER] = mapOf(
            MORNING to R.drawable.winter_morning,
            AFTERNOON to R.drawable.winter_day,
            EVENING to R.drawable.winter_evening,
            NIGHT to R.drawable.winter_night
        )
    }

    fun getBackgroundResource(currentMillis: Long) : Int {
        calendar.timeInMillis = currentMillis
        return when(hourFormat.format(calendar.time).toByte()) {
            in 5..10 -> images[getMonth()]!!.getValue(MORNING)
            in 5..10 -> images[getMonth()]!!.getValue(MORNING)
            in 11..17 -> images[getMonth()]!!.getValue(AFTERNOON)
            in 18..21 -> images[getMonth()]!!.getValue(EVENING)
            else -> images[getMonth()]!!.getValue(NIGHT)
        }
    }

    private fun getMonth(): Byte {
        return when(monthFormat.format(calendar.time).toByte()) {
            in 3..5 -> SPRING
            in 6..8 -> SUMMER
            in 9..11 -> AUTUMN
            else -> WINTER
        }
    }

}