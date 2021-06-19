package linc.com.weatherapp.domain.repositories

import kotlinx.coroutines.flow.Flow

interface ForecastRepository {

    suspend fun getForecast() : Flow<List<Any>>

}