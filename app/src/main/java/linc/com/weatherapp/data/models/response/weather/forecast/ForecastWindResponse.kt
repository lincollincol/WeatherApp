package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastWindResponse(
    @SerializedName("speed")
    @Expose val speed: Double,
    @SerializedName("deg")
    @Expose val deg: Int
)