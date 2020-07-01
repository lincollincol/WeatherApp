package linc.com.weatherapp.data.models.response.weather.current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentWindResponse(
    @SerializedName("speed")
    @Expose val speed: Int,
    @SerializedName("deg")
    @Expose val deg: Int
)