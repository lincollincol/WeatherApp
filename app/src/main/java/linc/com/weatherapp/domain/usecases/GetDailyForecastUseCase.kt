package linc.com.weatherapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import linc.com.weatherapp.domain.base.BaseUseCase
import linc.com.weatherapp.domain.entities.WeatherEntity
import linc.com.weatherapp.domain.repositories.ForecastRepository

class GetDailyForecastUseCase(
    private val forecastRepository: ForecastRepository
) : BaseUseCase<GetDailyForecastUseCase.Params, Flow<List<WeatherEntity>>> {

    data class Params(
        val date: String = ""
    )

    override suspend fun invoke(params: Params) = forecastRepository.getDailyForecast()
}