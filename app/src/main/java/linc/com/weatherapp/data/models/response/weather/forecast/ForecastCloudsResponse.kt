package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastCloudsResponse(
    @SerializedName("all")
    @Expose val all: Int
)