package linc.com.weatherapp.data.models.response.weather.current

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CurrentWeatherApiResponse(
    @SerializedName("coord")
    @Expose val currentCoord: CurrentCoordResponse,
    @SerializedName("weather")
    @Expose val currentWeather: List<CurrentWeatherResponse>,
    @SerializedName("base")
    @Expose val base: String,
    @SerializedName("main")
    @Expose val currentMain: CurrentMainResponse,
    @SerializedName("visibility")
    @Expose val visibility: Int,
    @SerializedName("wind")
    @Expose val currentWind: CurrentWindResponse,
    @SerializedName("clouds")
    @Expose val currentClouds: CurrentCloudsResponse,
    @SerializedName("dt")
    @Expose val dt: Int,
    @SerializedName("sys")
    @Expose val currentSys: CurrentSysResponse,
    @SerializedName("timezone")
    @Expose val timezone: Int,
    @SerializedName("id")
    @Expose val id: Int,
    @SerializedName("name")
    @Expose val name: String,
    @SerializedName("cod")
    @Expose val cod: Int
)