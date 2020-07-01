package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastApiResponse(
    @SerializedName("cod")
    @Expose val cod: String,
    @SerializedName("message")
    @Expose val message: Int,
    @SerializedName("cnt")
    @Expose val cnt: Int,
    @SerializedName("list")
    @Expose val list: List<ForecastDailyResponse>,
    @SerializedName("city")
    @Expose val forecastCity: ForecastCityResponse
)