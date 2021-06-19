package linc.com.weatherapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import linc.com.weatherapp.data.network.ForecastApi
import linc.com.weatherapp.domain.repositories.ForecastRepository

class ForecastRepositoryImpl(
    private val forecastApi: ForecastApi
) : ForecastRepository {

    override suspend fun getForecast(): List<Any> {
        println("=============== load data ${forecastApi}")
        try {
//            val response = forecastApi.getForecastData("Lviv", 5, "d183e48c4ae3b24a8f0d829f452950be").execute()
//            val response = forecastApi.getForecastData("Lviv", 5, "d183e48c4ae3b24a8f0d829f452950be").execute()
//            println("=== cod = ${response.body()?.cod}")
            println("=== cod = ${forecastApi.getForecastData("Lviv", 5, "d183e48c4ae3b24a8f0d829f452950be")}")

        }catch (e: Exception) {
            e.printStackTrace()
        }
        return mutableListOf()
        /*return withContext(Dispatchers.IO) {
            forecastApi.getForecastData(5, "d183e48c4ae3b24a8f0d829f452950be")
            mutableListOf()
        }*/
    }
}