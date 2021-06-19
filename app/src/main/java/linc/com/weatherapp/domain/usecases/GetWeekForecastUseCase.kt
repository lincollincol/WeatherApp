package linc.com.weatherapp.domain.usecases

import linc.com.weatherapp.domain.base.BaseUseCase
import linc.com.weatherapp.domain.repositories.ForecastRepository

class GetWeekForecastUseCase(
    private val forecastRepository: ForecastRepository
) : BaseUseCase<GetWeekForecastUseCase.Params, Any> {

    data class Params(
        val date: String = ""
    )

    /*override suspend fun execute(params: Params): Any {
        forecastRepository.getForecast()
        return Any()
    }*/

    override suspend fun invoke(params: Params): Any {
        forecastRepository.getForecast()
        return Any()
    }
}