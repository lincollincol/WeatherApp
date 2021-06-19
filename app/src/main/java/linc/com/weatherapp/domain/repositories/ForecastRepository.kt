package linc.com.weatherapp.domain.repositories

interface ForecastRepository {

    suspend fun getForecast() : List<Any>

}