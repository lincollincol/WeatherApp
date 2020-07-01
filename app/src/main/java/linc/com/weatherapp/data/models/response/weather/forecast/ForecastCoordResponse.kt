package linc.com.weatherapp.data.models.response.weather.forecast

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ForecastCoordResponse(
    @SerializedName("lat")
    @Expose val lat: Double,
    @SerializedName("lon")
    @Expose var lon: Double
)