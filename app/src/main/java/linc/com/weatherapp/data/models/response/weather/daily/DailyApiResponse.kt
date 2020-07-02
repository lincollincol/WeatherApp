package linc.com.weatherapp.data.models.response.weather.daily

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyApiResponse(
    @SerializedName("lat")
    @Expose val lat: Double,
    @SerializedName("lon")
    @Expose val lon: Double,
    @SerializedName("timezone")
    @Expose val timezone: String,
    @SerializedName("timezone_offset")
    @Expose val timezoneOffset: Int,
    @SerializedName("current")
    @Expose val current: DailyCurrentResponse,
    @SerializedName("daily")
    @Expose val daily: List<DailyResponse>
)