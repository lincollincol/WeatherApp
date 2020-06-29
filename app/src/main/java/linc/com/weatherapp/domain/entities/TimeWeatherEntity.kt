package linc.com.weatherapp.domain.entities

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TimeWeatherEntity(
    val time: String,
    val maxTemperature: Byte,
    val minTemperature: Byte,
    val weatherDetails: String
) : Parcelable