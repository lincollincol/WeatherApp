package linc.com.weatherapp.data.network

import linc.com.weatherapp.data.models.response.weather.current.CurrentWeatherApiResponse
import linc.com.weatherapp.data.models.response.weather.forecast.ForecastApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    // http://api.openweathermap.org
    // /data/2.5/forecast?q=Lviv&appid=d183e48c4ae3b24a8f0d829f452950be

    // Current weather
    @GET("/data/2.5/weather?q=Lviv")
    fun getCurrentWeatherData(
//        @Path("city") city: String,
        @Query("appid") key: String
    ) : Call<CurrentWeatherApiResponse>

    //http://api.openweathermap.org/data/2.5/forecast?q=Lviv&cnt=1&appid=d183e48c4ae3b24a8f0d829f452950be

    @GET("/data/2.5/forecast?q=Lviv")
    fun getForecastData(
//        @Path("city") city: String,
        @Query("cnt") count: Int,
        @Query("appid") key: String
    ) : Call<ForecastApiResponse>
}