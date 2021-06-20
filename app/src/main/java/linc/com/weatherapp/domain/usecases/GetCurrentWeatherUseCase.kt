package linc.com.weatherapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import linc.com.weatherapp.domain.base.BaseUseCase
import linc.com.weatherapp.domain.entities.CurrentWeatherEntity
import linc.com.weatherapp.domain.repositories.ForecastRepository

class GetCurrentWeatherUseCase(
    private val forecastRepository: ForecastRepository
) : BaseUseCase<GetCurrentWeatherUseCase.Params, Flow<CurrentWeatherEntity>> {

    class Params()

    override suspend fun invoke(params: Params) = forecastRepository.getCurrentForecast()
}