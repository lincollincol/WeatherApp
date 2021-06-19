package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastApiResponse(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<ForecastDailyResponse>,
    @SerializedName("city")
    val forecastCity: ForecastCityResponse
)