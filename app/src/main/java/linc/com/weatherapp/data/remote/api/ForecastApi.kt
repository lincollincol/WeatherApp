package linc.com.weatherapp.data.remote.api

import linc.com.weatherapp.data.models.response.weather.ForecastResponse
import linc.com.weatherapp.data.models.response.weather.TodayWeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastApi {

    @GET("/data/2.5/forecast")
    suspend fun getTodayForecast(
        @Query("q") city: String,
        @Query("lang") language: String,
        @Query("units") units: String,
        @Query("cnt") count: Int,
        @Query("appid") key: String
    ) : TodayWeatherResponse

    @GET("/data/2.5/onecall")
    suspend fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("lang") lang: String,
        @Query("units") units: String,
        @Query("exclude") exclude: String,
        @Query("cnt") count: Int,
        @Query("appid") key: String
    ) : ForecastResponse

}