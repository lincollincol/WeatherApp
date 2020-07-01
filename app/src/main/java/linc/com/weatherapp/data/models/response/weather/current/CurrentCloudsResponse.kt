package linc.com.weatherapp.data.models.response.weather.current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentCloudsResponse(
    @SerializedName("all")
    @Expose val all: Int
)