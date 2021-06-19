package linc.com.weatherapp.domain.usecases

import kotlinx.coroutines.flow.Flow
import linc.com.weatherapp.domain.base.BaseUseCase
import linc.com.weatherapp.domain.repositories.ForecastRepository

class GetWeekForecastUseCase(
    private val forecastRepository: ForecastRepository
) : BaseUseCase<GetWeekForecastUseCase.Params, Flow<Any>> {

    data class Params(
        val date: String = ""
    )

    override suspend fun invoke(params: Params): Flow<Any> {
        return forecastRepository.getForecast()
    }
}