package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastDailyResponse(
    @SerializedName("dt")
    @Expose val dt: Int,
    @SerializedName("main")
    @Expose val main: ForecastMainResponse,
    @SerializedName("weather")
    @Expose val weather: List<ForecastWeatherResponse>,
    @SerializedName("clouds")
    @Expose val clouds: ForecastCloudsResponse,
    @SerializedName("wind")
    @Expose val wind: ForecastWindResponse,
    @SerializedName("sys")
    @Expose val sys: ForecastSysResponse,
    @SerializedName("dt_txt")
    @Expose val dtTxt: String
)