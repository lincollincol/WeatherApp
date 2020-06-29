package linc.com.weatherapp.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeekDayEntity(
    val dayOfWeek: String,
    val monthTitle: String,
    val dayOfMonth: Int,
    val city: String,
    val timeWeatherDetails: List<TimeWeatherEntity>
) : Parcelable