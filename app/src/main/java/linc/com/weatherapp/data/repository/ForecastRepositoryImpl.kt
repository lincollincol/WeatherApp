package linc.com.weatherapp.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import linc.com.weatherapp.data.remote.api.ForecastApi
import linc.com.weatherapp.domain.repositories.ForecastRepository

class ForecastRepositoryImpl(
    private val forecastApi: ForecastApi
) : ForecastRepository {

    override suspend fun getForecast(): Flow<List<Any>> = flow {
        try {
            println("today")
            emit(forecastApi.getTodayForecast(
                "Lviv",
                "ua",
                "metric",
                5,
                "d183e48c4ae3b24a8f0d829f452950be"
            ).todayForecast)
            println("daily")
            emit(forecastApi.getDailyForecast(
                50.0,
                50.0,
                "ua",
                "metric",
                "minutely,hourly,alerts,current",
                5,
                "d183e48c4ae3b24a8f0d829f452950be"
            ).dailyForecast)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
}