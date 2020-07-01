package linc.com.weatherapp.data.models.response.weather.current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentCoordResponse(
    @SerializedName("lon")
    @Expose val lon: Double,
    @SerializedName("lat")
    @Expose val lat: Double
)