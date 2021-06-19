package linc.com.weatherapp.data.network

import linc.com.weatherapp.data.models.response.weather.current.CurrentWeatherApiResponse
import linc.com.weatherapp.data.models.response.weather.daily.DailyApiResponse
import linc.com.weatherapp.data.models.response.weather.forecast.ForecastApiResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ForecastApi {

    // http://api.openweathermap.org
    // /data/2.5/forecast?q=Lviv&appid=d183e48c4ae3b24a8f0d829f452950be

    // TODO: as main weather for current day
    // http://api.openweathermap.org/data/2.5/forecast?q=Lviv&appid=d183e48c4ae3b24a8f0d829f452950be

    //?q={city}
    // Current weather
    @GET("/data/2.5/weather")
    fun getCurrentWeatherData(
        @Query("q") q: String,
        @Query("appid") key: String
    ) : Call<CurrentWeatherApiResponse>

    //http://api.openweathermap.org/data/2.5/forecast?q=Lviv&cnt=1&appid=d183e48c4ae3b24a8f0d829f452950be
    //http://api.openweathermap.org/data/2.5/forecast?lang=ua&units=metric&q=Lviv&cnt=1&appid=d183e48c4ae3b24a8f0d829f452950be

    // forecast
    @GET("/data/2.5/forecast?lang=ua&units=metric")
    suspend fun getForecastData(
        @Query("q") city: String,
        @Query("cnt") count: Int,
        @Query("appid") key: String
    ) : ForecastApiResponse

    // daily

    //https://api.openweathermap.org
    @GET("/data/2.5/onecall?lat=33.441792&lon=-94.037689&exclude=hourly,minutely")
    fun getDailyData(
//        @Path("city") city: String,
        @Query("appid") key: String
    ) : Call<DailyApiResponse>

    //https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude=hourly,minutely&appid=d183e48c4ae3b24a8f0d829f452950be
    @GET("/data/2.5/onecall?&exclude=hourly,minutely")
    fun getDailyForecastByCity(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") key: String
    ) : Call<DailyApiResponse>


    // Week forecast
    // http://api.openweathermap.org/data/2.5/onecall?
    // lang=ua&
    // units=metric&
    // lat=33.441792&lon=-94.037689&
    // cnt=1&
    // appid=d183e48c4ae3b24a8f0d829f452950be&
    // exclude=minutely,hourly,alerts


    // Detailed current
    // http://api.openweathermap.org/data/2.5/forecast?lang=ua&units=metric&q=Lviv&cnt=5&appid=d183e48c4ae3b24a8f0d829f452950be
}