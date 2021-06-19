package linc.com.weatherapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import linc.com.weatherapp.data.network.ForecastApi
import linc.com.weatherapp.domain.repositories.ForecastRepository

class ForecastRepositoryImpl(
    private val forecastApi: ForecastApi
) : ForecastRepository {

    override suspend fun getForecast(): Flow<List<Any>> = flow {
        try {
            emit(forecastApi.getForecastData("Lviv", 5, "d183e48c4ae3b24a8f0d829f452950be").list)
        }catch (e: Exception) {
            e.printStackTrace()
        }
    }
}