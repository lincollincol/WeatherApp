package linc.com.weatherapp.data.models.response.weather.daily

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyCurrentResponse(
    @SerializedName("dt")
    @Expose val dt: Int,
    @SerializedName("sunrise")
    @Expose val sunrise: Int,
    @SerializedName("sunset")
    @Expose val sunset: Int,
    @SerializedName("temp")
    @Expose val temp: Double,
    @SerializedName("feels_like")
    @Expose val feelsLike: Double,
    @SerializedName("pressure")
    @Expose val pressure: Int,
    @SerializedName("humidity")
    @Expose val humidity: Int,
    @SerializedName("dew_point")
    @Expose val dewPoint: Double,
    @SerializedName("uvi")
    @Expose val uvi: Double,
    @SerializedName("clouds")
    @Expose val clouds: Int,
    @SerializedName("visibility")
    @Expose val visibility: Int,
    @SerializedName("wind_speed")
    @Expose val windSpeed: Double,
    @SerializedName("wind_deg")
    @Expose val windDeg: Int,
    @SerializedName("weather")
    @Expose val weather: List<DailyWeatherResponse>
)