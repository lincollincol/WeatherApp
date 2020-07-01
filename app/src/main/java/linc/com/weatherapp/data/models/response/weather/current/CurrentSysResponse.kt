package linc.com.weatherapp.data.models.response.weather.current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentSysResponse(
    @SerializedName("type")
    @Expose val type: Int,
    @SerializedName("id")
    @Expose val id: Int,
    @SerializedName("country")
    @Expose val country: String,
    @SerializedName("sunrise")
    @Expose val sunrise: Int,
    @SerializedName("sunset")
    @Expose val sunset: Int
)